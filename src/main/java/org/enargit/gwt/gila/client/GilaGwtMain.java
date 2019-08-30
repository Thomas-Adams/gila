package org.enargit.gwt.gila.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import org.enargit.gwt.gila.client.composites.RoleForm;
import org.fusesource.restygwt.client.util.Base64Codec;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class GilaGwtMain implements EntryPoint {

    private static Logger logger = Logger
            .getLogger(GilaGwtMain.class.getName());


    public static String createAuthHeader() {
        String credentials = "tadams:tadams";
        try {
            return Base64Codec.encode(credentials.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onModuleLoad() {


        RoleForm roleForm = new RoleForm();
        RootPanel.get("mainPanel").add(roleForm);


//        Defaults.setServiceRoot("/smilodon");
//        RoleService roleService = GWT.create(RoleService.class);
//
//        roleService.getRoles(new MethodCallback<List<RoleDto>>() {
//            @Override
//            public void onFailure(Method method, Throwable throwable) {
//                RootPanel.get("mainPanel").add(new HTML("Error occured : " + throwable.getMessage()));
//                for (StackTraceElement e : throwable.getStackTrace()) {
//                    RootPanel.get("mainPanel").add(new HTML(e.toString()));
//                }
//
//            }
//
//            @Override
//            public void onSuccess(Method method, List<RoleDto> roleProxies) {
//                for (RoleDto role : roleProxies) {
//                    RootPanel.get("mainPanel").add(new HTML(role.getRole()));
//                }
//            }
//        });
    }
}
