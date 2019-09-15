package org.enargit.gwt.gila.client.data.request;

public enum SortDirection {


    ASC("asc"),
    DESC("desc");

    private String sorted = "";

    SortDirection(String sorted) {
        this.sorted = sorted;
    }

    public String getSorted() {
        return sorted;
    }
}
