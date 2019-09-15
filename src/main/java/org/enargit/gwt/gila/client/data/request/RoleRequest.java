package org.enargit.gwt.gila.client.data.request;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class RoleRequest {

    private long offset;

    private int limit;

    private Map<String, String> sortParams = new HashMap<>();

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Map<String, String> getSortParams() {
        return sortParams;
    }

    public void setSortParams(Map<String, String> sortParams) {
        this.sortParams = sortParams;
    }
}
