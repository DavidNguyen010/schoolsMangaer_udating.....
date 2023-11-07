package com.schoolsmangaer.model;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    String grade;

    public Student() {
    }

    public Student(String id, String name, String age,String grade) {
        super(id, name, age);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
