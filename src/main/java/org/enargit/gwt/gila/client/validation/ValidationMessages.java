package org.enargit.gwt.gila.client.validation;

public interface ValidationMessages extends org.hibernate.validator.ValidationMessages {
    @DefaultStringValue("characters long.")
    @Key("custom.message")
    String custom_message();
}
