/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.mylibs;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import restaurantmanagement.mylibs.CustomControl.PopupController;

/**
 *
 * @author KevinHa
 */
public class Validation {
    ArrayList<String> validate_list = new ArrayList<>();
    public void ValidationEmpty(TextField tf, String fieldname){
        String Message = "";
        if(tf.getText().equals("")){
            Message = fieldname + " cannot be empty";
            validate_list.add(Message);
        } 
    }
    public void ValidationNumber(TextField tf, String fieldname){
        String regex = "\\d+";
        String Message = "";
        if(!tf.getText().matches(regex)){
            Message = fieldname + " contain digit number only - '12'";
            validate_list.add(Message);
        } 
    }
    public void ValidationPin(TextField tf, String fieldname){
        String regex = "\\d+";
        String Message = "";
        if(tf.getText().length()!=4 || !tf.getText().matches(regex)){
            Message = fieldname + " contain 4 digit number - '1234'";
            validate_list.add(Message);
        } 
    }
    public void ValidationZipcode(TextField tf, String fieldname){
        String regex = "\\d+";
        String Message = "";
        if(tf.getText().length()!=5 || !tf.getText().matches(regex)){
            Message = fieldname + " contain 5 digit number - '12345'";
            validate_list.add(Message);
        } 
    }
    public void ValidationPhone(TextField tf, String fieldname){
        String regex = "\\d+";
        String Message = "";
        if(tf.getText().length()!=10 || !tf.getText().matches(regex)){
            Message = fieldname + " contain 10 digit number - '1234567899'";
            validate_list.add(Message);
        } 
    }
    public void ValidationEmail(TextField tf, String fieldname){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        
        String Message = "";
        if(!tf.getText().matches(regex)){
            Message = fieldname + " is incorrect format - 'example@gmail.com'";
            validate_list.add(Message);
        } 
    }
    public void ValidationMatch(TextField tf1, TextField tf2, String fieldname){
        String regex = "\\d+";
        String Message = "";
        if(!tf1.getText().equals(tf2.getText())){
            Message = fieldname + " does not match";
            validate_list.add(Message);
        } 
    }
    public boolean ValidationCheck(AnchorPane Root){
        
        boolean success = true;
        if(validate_list.size() > 0){
            BoxBlur blur = new BoxBlur(5, 5, 5);
                success = false;
                ErrorPopup(Root);
                Root.setDisable(true);
                Root.setEffect(blur);
        }
        validate_list.clear();
        return success;
    }
    
    // Error notification
    void ErrorPopup(AnchorPane Root){
        PopupController pc = new PopupController();
        pc.Show(validate_list, Root);
        
    }
}
