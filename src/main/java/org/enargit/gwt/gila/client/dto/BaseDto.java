package org.enargit.gwt.gila.client.dto;


import java.io.Serializable;
import java.util.Date;


public class BaseDto<ID extends Serializable> {

    protected ID id;

    protected long version;

    protected Date created;

    protected Date modified;

    protected String createdBy;

    protected String modifiedBy;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
