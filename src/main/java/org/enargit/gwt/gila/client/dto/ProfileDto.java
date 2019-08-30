package org.enargit.gwt.gila.client.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ProfileDto extends BaseDto<Long>{


    private String givenName;

    private String surName;

    private Date birthday;

    private Set<ProfileAttributesDto> attributes = new HashSet<>(0);

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<ProfileAttributesDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<ProfileAttributesDto> attributes) {
        this.attributes = attributes;
    }
}
