package com.company;

public class Student {
    //姓名
    private String name;
    //学号
    private int ID;
    //出生日期
    private String birDate;
    //性别
    private boolean gender;

    //构造函数

    public Student(String name, int ID, String birDate, boolean gender) {
        this.name = name;
        this.ID = ID;
        this.birDate = birDate;
        this.gender = gender;
    }

    public Student() {

    }

    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
