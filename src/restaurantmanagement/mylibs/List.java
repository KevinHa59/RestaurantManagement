/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.mylibs;

import java.util.ArrayList;

/**
 *
 * @author KevinHa
 */
public class List {
    public ArrayList<ArrayList<String>> ArrayList_C(int count){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i  = 0;i < count; i++){
            ArrayList<String> childList = new ArrayList<>();
            list.add(childList);
        }
        
        return list;
    }
}
