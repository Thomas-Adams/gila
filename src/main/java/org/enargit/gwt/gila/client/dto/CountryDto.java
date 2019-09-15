package org.enargit.gwt.gila.client.dto;

public class CountryDto extends BaseDto<Long> {

    private String name;

    private String domain;

    private String abbreviation;

    private String phone;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDomain() {
        return domain;
    }


    public void setDomain(String domain) {
        this.domain = domain;
    }


    public String getAbbreviation() {
        return abbreviation;
    }


    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


}
