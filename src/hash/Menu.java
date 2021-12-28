/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;
import Utils.*;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Menu extends ArrayList<String>{
    int getUserChoice(){
        for (int i = 0; i < size(); i++) {
            System.out.println((i+1) + "-" + this.get(i));
        }
        return Utils.getInt("Choose operation: ");
    }
}
