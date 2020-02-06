package com.example.kimschurch;

public class MemberDTO {

    private int pnum;
    private String name;
    private String phone;
    private String picture;



    private String position;
    private String department;
    private String part;
    private String srbName;
    private String srbLeader;
    private String work;
    private String birthday;

    public MemberDTO(String name, String phone, String picture, String position, String department, String part, String srbName) {
        this.name = name;
        this.phone = phone;
        this.picture = picture;
        this.position = position;
        this.department = department;
        this.part = part;
        this.srbName = srbName;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSrbName() {
        return srbName;
    }

    public void setSrbName(String srbName) {
        this.srbName = srbName;
    }

    public String getSrbLeader() {
        return srbLeader;
    }

    public void setSrbLeader(String srbLeader) {
        this.srbLeader = srbLeader;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
