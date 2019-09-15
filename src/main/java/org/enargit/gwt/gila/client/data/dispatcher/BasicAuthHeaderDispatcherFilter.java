package org.enargit.gwt.gila.client.data.dispatcher;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.googlecode.gwt.crypto.bouncycastle.util.encoders.Base64;
import org.fusesource.restygwt.client.Dispatcher;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

import java.io.UnsupportedEncodingException;

public class BasicAuthHeaderDispatcherFilter implements DispatcherFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public boolean filter(Method method, RequestBuilder builder) {
        try {

            String basicAuthHeaderValue = createBasicAuthHeader(
                    Credentials.INSTANCE.getUserName(),
                    Credentials.INSTANCE.getPassword());

            builder.setHeader(AUTHORIZATION_HEADER, basicAuthHeaderValue);

        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return true;
    }

    private String createBasicAuthHeader(String userName, String password)
            throws UnsupportedEncodingException {
        String credentials = userName + ":" + password;
        String encodedCredentials = new String(Base64.encode(credentials
                .getBytes()), "UTF-8");

        return "Basic " + encodedCredentials;
    }
}