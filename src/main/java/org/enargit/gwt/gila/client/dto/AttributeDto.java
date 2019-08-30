package org.enargit.gwt.gila.client.dto;


import org.enargit.gwt.gila.client.enums.ObjectTypes;
import org.enargit.gwt.gila.client.enums.ValueTypes;

import java.util.HashSet;
import java.util.Set;


public class AttributeDto extends BaseDto<Long> {

    private String name;

    private String description;

    private ObjectTypes type;

    private ValueTypes dataType;

    private Set<SelectionListDto> selectionLists = new HashSet<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectTypes getType() {
        return type;
    }

    public void setType(ObjectTypes type) {
        this.type = type;
    }

    public ValueTypes getDataType() {
        return dataType;
    }

    public void setDataType(ValueTypes dataType) {
        this.dataType = dataType;
    }

    public Set<SelectionListDto> getSelectionLists() {
        return selectionLists;
    }

    public void setSelectionLists(Set<SelectionListDto> selectionLists) {
        this.selectionLists = selectionLists;
    }
}
