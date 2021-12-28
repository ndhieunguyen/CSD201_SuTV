/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;
import Utils.*;
/**
 *
 * @author LENOVO
 */
public class Student implements Comparable{
    String code, name;
    int mark;

    public Student(String code, String name, int mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return code + ", " + name +", " + mark;
    }
    
    @Override
    public int compareTo(Object o) {
        return code.compareTo(((Student) o).code);
    }
    
    public void update(){
        this.name = Utils.getString("New name, ENTER for bypassing: ").trim();
        this.mark = Utils.getInt("New mark, ENTER for bypassing: ");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    
}
