package org.enargit.gwt.gila.client.dto;


public class UserRoleDto extends BaseDto<Long> {


    private RoleDto role;

    private UserDto user;

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
