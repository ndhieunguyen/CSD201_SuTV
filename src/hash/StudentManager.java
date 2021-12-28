/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;
import Utils.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author LENOVO
 */
public class StudentManager {
    public static void main(String[] args) throws UnsupportedEncodingException {
        final String filename = "students.txt";
        Menu m = new Menu();
        m.add("Add new student");
        m.add("Search a student");
        m.add("Remove a student");
        m.add("Update a student");
        m.add("Print list of students");
        m.add("Save the list to file");
        m.add("Quit");
        int choice;
        
        StudentList L = new StudentList();
        L.loadFromFile(filename);
        do {
            System.out.println("\n----------STUDENT MANAGER----------");
            choice = m.getUserChoice();
            switch (choice){
                case 1:{
                    L.addStudent();
                    break;
                }
                case 2:{
                    L.searchStudent();
                    break;
                }
                case 3: {
                    L.removeStudent();
                    break;
                }
                case 4: {
                    L.updateStudent();
                    break;
                }
                case 5:{
                    L.print();
                    break;
                }
                case 6:{
                    L.saveToFile(filename);
                    break;
                }
            }
        }
        while (choice>=0 && choice<7);
//        String test = Utils.getVie("Enter: ");
//        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"UTF-8"));
//        System.out.println(test);
    }
}
