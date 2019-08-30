package org.enargit.gwt.gila.client.dto;


import java.util.HashSet;
import java.util.Set;


public class SubscriptionDto extends BaseDto<Long> {


    private CampaignDto campaign;

    private UserDto user;

    private Set<SubscriptionAttributesDto> attributes = new HashSet<>(0);

    public CampaignDto getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignDto campaign) {
        this.campaign = campaign;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Set<SubscriptionAttributesDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<SubscriptionAttributesDto> attributes) {
        this.attributes = attributes;
    }
}
