/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import Utils.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author LENOVO
 */
public class StudentList extends Hashtable<String, Student>{

    public StudentList() {
        super();
    }
    
    public boolean loadFromFile(String filename) {
        try{
            FileInputStream fi = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fi, "UTF8");
            BufferedReader bf = new BufferedReader(isr);
            String line;
            while ((line = bf.readLine()) != null){
                line = line.trim();
                String[] ar = line.split("[,]");
                if (ar.length==3){
                    Student st = new Student(ar[0], ar[1], Integer.parseInt(ar[2]));
                    this.put(st.code, st);
                }
            }
            bf.close();
            isr.close();
            fi.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean saveToFile(String filename){
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF8");
            PrintWriter pw = new PrintWriter(osw);
            Iterator<String> it = this.keySet().iterator();
            while (it.hasNext()){
                String key = it.next();
                Student st = this.get(key);
                pw.println(st);
            }
            pw.close();
            osw.close();
            fo.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public Student search(String code){
        return this.get(code);
    }
    
    public void addStudent(){
        String code, name;
        int mark;
        System.out.println("Enter data of new student: ");
        boolean cont = true;
        do{
            code = Utils.getString("Code: ").toUpperCase().trim();
            cont = search(code)!=null;
            if (cont) System.out.println("Duplicated !!!");
        }
        while (cont);
        name = Utils.getString("Name: ").toUpperCase().trim();
        mark = Utils.getInt("Marks: ");
        this.put(code, new Student(code, name, mark));
        System.out.println("New student " + code + " has been added.");
    }
    
    public void searchStudent(){
        if (this.isEmpty()){
            System.out.println("Empty list !");
            return;
        }
        String code = Utils.getString("Enter student code for searching: ").toUpperCase();
        Student st = this.search(code);
        if (st==null) System.out.println("This code doesn't exist");
        else System.out.println(st);
    }
    
    public void removeStudent(){
        if (this.isEmpty()){
            System.out.println("Empty list !");
            return;
        }
        String code = Utils.getString("Enter student code for removing: ").toUpperCase();
        Student st = this.search(code);
        if (st==null) System.out.println("This code doesn't exist");
        else {
            this.remove(code);
            System.out.println("Student " + code + " has been removed");
        }
    }
    
    public void updateStudent(){
        if (this.isEmpty()){
            System.out.println("Empty list !");
            return;
        }
        String code = Utils.getString("Enter student code for updating: ").toUpperCase();
        Student st = this.search(code);
        if (st==null) System.out.println("This code doesn't exist");
        else st.update();
        
    }
    
    public void print(){
        if (this.isEmpty()){
            System.out.println("Empty list !");
            return;
        }
        ArrayList<Student> list = new ArrayList();
        list.addAll(this.values());
        Collections.sort(list);
        for (Student st: list){
            System.out.println(st);
        }
    }
}
