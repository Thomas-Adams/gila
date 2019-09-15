package org.enargit.gwt.gila.client.data.dispatcher;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;

public class BasicAuthDispatcher extends DefaultFilterawareDispatcher {

    public BasicAuthDispatcher() {
        addFilter(new BasicAuthHeaderDispatcherFilter());
    }

    public Request send(
            Method method,
            RequestBuilder builder) throws RequestException {
        return builder.send();
    }

}
