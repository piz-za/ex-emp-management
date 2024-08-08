package com.example.form;


/** 
 * 管理者のフォームクラス
 */
public class InsertAdministratorForm {
    private String name;
    private String mailAddress;
    private String password;

    @Override
    public String toString() {
        return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public String getPassword() {
        return password;
    }
    
}
