package org.enargit.gwt.gila.client.dto;

import java.util.Date;


public class UserDto extends BaseDto<Long> {


    private String username;

    private String password;

    private String email;

    private String mobile;

    private boolean enabled;

    private boolean locked;

    private boolean expired;

    private String accessToken;

    private String refreshToken;


    private Date lastChangeCredentials;

    private Date lastLogin;

}
