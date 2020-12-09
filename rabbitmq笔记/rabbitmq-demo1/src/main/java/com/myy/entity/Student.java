package com.myy.entity;



import java.io.Serializable;


public class Student implements Serializable {
    private int id;
    private String name;
    private char sex;

    public int getId() {
        return id;
    }

    public Student(int id, String name, char sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
