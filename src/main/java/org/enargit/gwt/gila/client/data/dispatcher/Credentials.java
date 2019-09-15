package org.enargit.gwt.gila.client.data.dispatcher;

public enum Credentials {

    INSTANCE ("anonymous", null);

    private String userName;
    private String password;

    private Credentials(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
