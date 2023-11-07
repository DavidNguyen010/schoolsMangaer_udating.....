package com.schoolsmangaer.controller;

import com.schoolsmangaer.model.Student;
import com.schoolsmangaer.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();
    private static final Scanner scanner = new Scanner(System.in);

    public  void studentController(){

        do {
            try{
                System.out.println("Quản lý sinh viên");
                System.out.println("------------------");
                System.out.println("Chọn chức năng");
                System.out.printf(
                         "1: Thêm sinh viên." +"\t"
                        +"2: Sửa thông tin sinh viên."+"\t"
                        +"3: Tìm kiếm sinh viên theo ID."+"\t"
                        +"4: Tìm kiếm sinh viên theo tên." + "\t"
                        +"5: Hiển thị danh sách sinh viên."+"\t"
                        +"5: Xóa sinh viên."+"\n");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        studentService.add();
                        break;
                    case 2:
                        studentService.edit("");
                        break;
                    case 3:
//                        studentService.showList();
                        break;
                    case 4:
                        studentService.sortByName();
                        break;
                    case 5:
                        studentService.showList();
                        break;
                    case 6:
                        studentService.delete();
                    case 0:
                            return;
                    default:
                        throw new NumberFormatException("Vui lòng nhập đúng lựa chọn");
                }

            }catch (NumberFormatException e){
                System.out.println("Nhập số từ 1 đến ");
                e.printStackTrace();
            }
        }while (true);
    }
}
