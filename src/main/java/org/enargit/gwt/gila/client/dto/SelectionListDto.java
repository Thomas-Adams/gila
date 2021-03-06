package org.enargit.gwt.gila.client.dto;


import java.util.Date;


public class SelectionListDto extends BaseDto<Long> {

    private String name;

    private AttributeDto attribute;

    private Date dateValue;

    private Float floatValue;

    private Long longValue;

    private String stringValue;

    private Boolean booleanValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeDto getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeDto attribute) {
        this.attribute = attribute;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }
}
