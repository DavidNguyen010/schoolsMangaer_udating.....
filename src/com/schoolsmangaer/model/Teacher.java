package com.schoolsmangaer.model;

public class Teacher extends Person{
    String subject;

    public Teacher(String id, String name, String age, String subject) {
        super(id, name, age);
        this.subject = subject;
    }
}
