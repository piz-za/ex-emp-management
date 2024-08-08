package com.example.form;


/**
 * ログインフォームクラス
 */
public class LoginForm {
    private String mailAddress;
    private String password;

    @Override
    public String toString() {
        return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public String getPassword() {
        return password;
    }
    
}
