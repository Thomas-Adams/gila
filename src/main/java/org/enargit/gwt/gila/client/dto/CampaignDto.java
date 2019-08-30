package org.enargit.gwt.gila.client.dto;


import java.util.HashSet;
import java.util.Set;


public class CampaignDto extends BaseDto<Long> {

    private String name;

    private String code;

    private String description;

    private boolean needsLogin;

    private boolean hasMailings;

    private Set<CampaignAttributesDto> attributes = new HashSet<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNeedsLogin() {
        return needsLogin;
    }

    public void setNeedsLogin(boolean needsLogin) {
        this.needsLogin = needsLogin;
    }

    public boolean isHasMailings() {
        return hasMailings;
    }

    public void setHasMailings(boolean hasMailings) {
        this.hasMailings = hasMailings;
    }

    public Set<CampaignAttributesDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<CampaignAttributesDto> attributes) {
        this.attributes = attributes;
    }
}
