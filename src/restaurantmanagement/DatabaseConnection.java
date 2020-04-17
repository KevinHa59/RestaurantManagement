/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import restaurantmanagement.mylibs.List;

/**
 *
 * @author KevinHa
 */
public class DatabaseConnection {
    Connection con;
    public Connection getConnection(){
        String DB_name = "restaurantdb";
        String Username = "root";
        String Password = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB_name,Username,Password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    // Check FirstTime Run Software
    public boolean FirstTimeRunSoftware(){
        boolean firstTime = true;
        
        Connection con = getConnection();
        
        String SQL = "SELECT COUNT(*) FROM restaurantinformation";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                System.out.println("Count: " + rs.getInt("COUNT(*)"));
                if(rs.getInt("COUNT(*)") > 0){
                    firstTime = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return firstTime;
    }
    
    
    // Insert Initial Setup Restaurant Information
    public void AddNewRestaurant(String name, String subname, String address_street, String address_city, String address_state, String address_zipcode, String email, String phone, String table_quantity, String main_location ){
        Connection con = getConnection();
        
        SimpleDateFormat  f = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = new Date();
        
        String Code = name.substring(0, 1)+"" + address_city.substring(0, 1)+"" + address_state.substring(0, 1)+ (int)(Math.random()*1000);
        
        String SQL = "INSERT INTO restaurantinformation\n" +
                    "(code,name,subname,address_street,address_city,address_state,address_zipcode,email,phone,table_quantity,launch_date,main_location)\n" +
                    "VALUES\n" +
                    "('"+Code+"','"+name+"','"+subname+"','"+address_street+"','"+address_city+"','"+address_state+"','"+address_zipcode+"','"+email+"','"+phone+"','"+table_quantity+"','"+f.format(date)+"','"+main_location+"')";
        
        Statement statement = null;
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Insert Initial Setup Manager Information
    public void AddManager(String username, String password, String firstname, String lastname, String email, String phone, String pin){
        Connection con = getConnection();
        
        Date date = new Date();
        
        String SQL = "INSERT INTO manager\n" +
                    "(username,password,firstname,lastname,email, phone, pin)\n" +
                    "VALUES\n" +
                    "('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+email+"','"+phone+"','"+pin+"')";
        
        Statement statement = null;
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Position - Add New 
    public void AddNewPosition(String Title, String Desc, String MainWage, String TrainWage){
        Connection con = getConnection();
        
        String SQL = "INSERT INTO position (name, description, wage, trainwage) VALUES ('"+Title+"','"+Desc+"','"+MainWage+"','"+TrainWage+"')";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Position - Load All
    public ArrayList<ArrayList<String>> LoadAllPosition(){
        List clist = new List();
        ArrayList<ArrayList<String>> list = clist.ArrayList_C(5);
        
        Connection con = getConnection();
        
        String SQL = "SELECT * FROM position ORDER BY name ASC";
        
        Statement statement = null;
        
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            
            while (rs.next()){
                list.get(0).add(rs.getString(1)); // id
                list.get(1).add(rs.getString(2)); // title
                list.get(2).add(rs.getString(3)); // desc
                list.get(3).add(rs.getString(4)); // mainwage
                list.get(4).add(rs.getString(5)); // trainwage
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Size: " + list.get(0).size());
        return list;
    }
}
