package com.mac.cdp.androidbaidusign.bean;

/**
 * Created by cdpmac on 15/9/18.
 */
public class BaiduUser extends Entity{
    private String telphone;
    public BaiduUser(Long id,String telphone, String username, String password, String email) {
        super(id);
        this.telphone = telphone;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String password;
    private String email;
    public String getTelphone() {
        return telphone;
    }
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
