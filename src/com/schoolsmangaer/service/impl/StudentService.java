package com.schoolsmangaer.service.impl;

import com.schoolsmangaer.controller.StudentController;
import com.schoolsmangaer.data.StudentFile;
import com.schoolsmangaer.model.Student;
import com.schoolsmangaer.service.*;

import java.util.*;


public class StudentService implements IAdd, IEdit, IDlete, ISearchByName,IShowList {

    private StudentController controller;
    private List<Student> students;
    private StudentFile studentFile;

    public StudentService() {
        StudentFile studentFile = new StudentFile();
        students = studentFile.readFromFile();
    }

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Nhập id sinh viên");
        String id = SCANNER.nextLine();
        System.out.println("Nhập tên sinh viên");
        String name = SCANNER.nextLine();
        System.out.println("Nhập tuổi sinh viên");
        String age = SCANNER.nextLine();
        System.out.println("Nhập lớp học");
        String grade = SCANNER.nextLine();
        Student student = new Student(id, name, age, grade);
        try {
            students.add(student);
            studentFile.saveToFile(students);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    @Override
    public void edit(String id) {
        boolean isExisted = false;
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == id) {
                isExisted = true;
                System.out.println("Nhập tên cần sửa:");
                String name = SCANNER.nextLine();
                students.get(i).setName(name);
                System.out.println("Nhập tuổi cần sửa:");
                String age = SCANNER.nextLine();
                students.get(i).setAge(age);
                System.out.println("Nhập lớp cần sửa:");
                String grade = SCANNER.nextLine();
                students.get(i).setGrade(grade);
                break;
            }
        }


        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentFile.saveToFile(students);
        }

    }

    @Override
    public void delete() {
        Student student = null;
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == student.getId()) {
                student = students.get(i);
                break;
            }
        }
        if (student != null) {
            students.remove(student);
            studentFile.saveToFile(students);
        } else {
            System.out.printf("id = %d not existed.\n", student.getId());
        }
    }




    @Override
    public void sortByName() {
        ArrayList<String> students = new ArrayList<>();
        Collections.sort(students);
    }

    @Override
    public void showList() {
        for (Student student: students){
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%5d | ", student.getGrade());
        }
    }
}

