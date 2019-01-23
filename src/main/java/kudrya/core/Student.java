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
}