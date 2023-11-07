package com.schoolsmangaer.view;

import com.schoolsmangaer.controller.StudentController;

import java.util.Scanner;

public class SchoolsManager {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        do {
          int  choice = sc.nextInt();
          switch (choice){
              case 1:
                  System.out.println("Student menu");
                  studentController.studentController();
          }
        }while (true);
    }
}
