package com.example.form;


/**
 * 従業員のフォームクラス
 */
public class UpdateEmployeeForm {

    private String id;
    private String dependentsCount;
    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }
    public String getId() {
        return id;
    }
    public String getDependentsCount() {
        return dependentsCount;
    }

    
}
