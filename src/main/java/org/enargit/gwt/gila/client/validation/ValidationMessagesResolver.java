package org.enargit.gwt.gila.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.validation.client.AbstractValidationMessageResolver;
import com.google.gwt.validation.client.UserValidationMessagesResolver;

public class ValidationMessagesResolver extends AbstractValidationMessageResolver implements UserValidationMessagesResolver {

    public ValidationMessagesResolver() {
        super((ConstantsWithLookup) GWT.create(ValidationMessages.class));
    }
}
