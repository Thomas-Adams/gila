package org.enargit.gwt.gila.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import org.enargit.gwt.gila.client.dto.RoleDto;

import javax.validation.Validator;

public final class GwtValidatorFactory extends AbstractGwtValidatorFactory {

    @GwtValidation(RoleDto.class)
    public interface GwtValidator extends Validator {
    }

    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }
}
