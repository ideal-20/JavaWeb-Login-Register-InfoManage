package cn.ideal.message.domain;

import java.io.Serializable;

public class User implements Serializable {
    private int uid;//用户id
    private String username;//用户名
    private String name;//真实姓名
    private String password;//密码
    private String email;//邮箱
    private String telephone;//手机号
    private String gender;//男或女
    private String birthday;//出生日期
    private String education;//教育信息
    private String family;//家庭信息
    private String treatment;//待遇信息
    private String department;//部门信息
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）

    public User() {
    }

    public User(int uid, String username, String name, String password, String email, String telephone, String gender, String birthday, String education, String family, String treatment, String department, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.gender = gender;
        this.birthday = birthday;
        this.education = education;
        this.family = family;
        this.treatment = treatment;
        this.department = department;
        this.status = status;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}