package com.schoolsmangaer.data;

import com.schoolsmangaer.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFile  {
    private static final String STUDENT_FILE_NAME = "students.txt";
    public static List<Student> readFromFile() throws IOException, ClassNotFoundException {


            FileInputStream fi = new FileInputStream("students.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fi);
            return (List<Student>) objectInputStream.readObject();


    }
    public void  saveToFile(List<Student> students) {
        try {
            FileOutputStream fo = new FileOutputStream("students.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);

            objectOutputStream.writeObject(students);
            objectOutputStream.flush();
            objectOutputStream.close();
            fo.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    public List<Student> readFromFile() {
//        List<Student> students = new ArrayList<>();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(new File(STUDENT_FILE_NAME));
//            ois = new ObjectInputStream(fis);
//            students = (List<Student>) ois.readObject();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fis);
//            closeStream(ois);
//        }
//        return students;
//    }
//
//
//    public void saveToFile(List<Student> students) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(new  File(STUDENT_FILE_NAME));
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(students);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fos);
//            closeStream(oos);
//        }
//    }
//
//    private void closeStream(InputStream is) {
//        if (is != null) {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    private void closeStream(OutputStream os) {
//        if (os != null) {
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
