package org.enargit.gwt.gila.client.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleDto extends BaseDto<Long> {

    @NotNull
    @Size(max = 30, message = "{custom.message}")
    private String role;

    @NotNull
    @Size(max = 500, message = "{custom.message}")
    private String description;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
