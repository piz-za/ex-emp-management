package com.example.domain;

/*
 * 管理者クラス
 */
public class Administrator {
    private Integer id;
    private String name;
    private String mailAddress;
    private String password;
    
    /*
     * 引数のないコンストラクタ
     */
    public Administrator(){
    }

    /*
     * すべてのフィールドを引数に取るコンストラクタ
     */
    public Administrator(Integer id, String name, String mailAddress, String password) {
        this.id = id;
        this.name = name;
        this.mailAddress = mailAddress;
        this.password = password;
    }

    /*
     * toString()メソッドのオーバライド
     * @return フィールド変数に格納されている情報を返す
     */
    @Override
    public String toString() {
        return "Administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
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
