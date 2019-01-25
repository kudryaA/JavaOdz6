package kudrya.core;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String name;
    private String surname;
    private Date birthday;
    private String phone;
    private String address;
    private String course;
    private String group;
    private String facultet;

    public Student(String name, String surname, Date birthday, String phone, String address, String course, String group, String facultet) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.course = course;
        this.group = group;
        this.facultet = facultet;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return name + ' ' + surname + ' ' + group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }
}