package org.enargit.gwt.gila.client.composites;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import org.enargit.gwt.gila.client.GilaGwtMain;
import org.enargit.gwt.gila.client.data.rest.RoleService;
import org.enargit.gwt.gila.client.dto.RoleDto;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.constants.AlertType;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class RoleForm extends Composite {


    interface RoleFormUiBinder extends UiBinder<Widget, RoleForm> {
    }

    private static final RoleFormUiBinder uiBinder = GWT.create(RoleFormUiBinder.class);

    @UiField
    org.gwtbootstrap3.client.ui.TextBox role;

    @UiField
    org.gwtbootstrap3.client.ui.TextArea description;

    @UiField
    org.gwtbootstrap3.client.ui.Button saveButton;

    @UiField
    Alert message;


    public RoleForm() {
        initWidget(uiBinder.createAndBindUi(this));
    }


    @UiHandler({"saveButton"})
    public void onClick(ClickEvent event) {
        RoleDto roleDto = new RoleDto();
        roleDto.setRole(this.role.getValue());
        roleDto.setDescription(this.description.getValue());
        boolean isValid = true;

        StringBuilder errorMessages = new StringBuilder();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        for (ConstraintViolation<RoleDto> violation : validator.validate(roleDto)) {
            GWT.log(violation.getMessage());
            errorMessages.append(violation.getMessage());
            errorMessages.append("\r\n");
            isValid = false;
        }

        if (!isValid) {
            this.message.setType(AlertType.DANGER);
            this.message.setText(errorMessages.toString());
            this.message.setVisible(true);
        } else {
            Defaults.setServiceRoot("http://localhost:9900");
            RoleService roleService = GWT.create(RoleService.class);
            roleService.saveRole(GilaGwtMain.createAuthHeader(), roleDto, new CallBackHandler());
        }
    }


    class CallBackHandler implements MethodCallback<RoleDto> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            RoleForm.this.message.setVisible(true);
            RoleForm.this.message.setType(AlertType.DANGER);
            RoleForm.this.message.setText(throwable.getMessage());
        }

        @Override
        public void onSuccess(Method method, RoleDto roleDto) {
            RoleForm.this.message.setVisible(true);
            RoleForm.this.message.setType(AlertType.SUCCESS);
            RoleForm.this.message.setText("Role successfule created with ID : " + roleDto.getId());
        }
    }

    public static RoleFormUiBinder getUiBinder() {
        return uiBinder;
    }

}
