/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.Manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import restaurantmanagement.mylibs.Transition;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Employees_ManageController implements Initializable {
    Transition trans;
    
    @FXML
    private HBox HBox_employessList_header;
    @FXML
    private VBox Vbox_Employee_Unit_list;

    double Pane_Content_Width = 0;
    @FXML
    private AnchorPane pane_list;
    @FXML
    private AnchorPane pane_detail;
    
    ArrayList<AnchorPane> List_pane;
    @FXML
    private AnchorPane root;
    @FXML
    private HBox HBox_Detail_Header;
    @FXML
    private VBox Vbox_Employee_Working_List;
    @FXML
    private AnchorPane panel_left_detail;
    @FXML
    private HBox HBox_employessList_header1;
    
    AnchorPane primaryStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        trans = new Transition();
        trans.FadeIn(root);
        TransitionSetup();
    }    
    
    public void GetDetail(double size, AnchorPane _root){
        Pane_Content_Width = size;
        
        EmployeeList_Setup();
        Employee_Working_List();
        primaryStage = _root;
    }
    
    // Transition Setup
    void TransitionSetup(){
        
        List_pane = new ArrayList<>();
        List_pane.add(pane_list);
        List_pane.add(pane_detail);
        for(int  i = 0; i< List_pane.size();i++){
            List_pane.get(i).setVisible(false);
        }
        List_pane.get(0).setVisible(true);
    }
    
    void EmployeeList_Setup(){
        HBox_employessList_header.getStyleClass().add("List_Header");
        double ID = 5;
        double Fname = 10;
        double Lname = 10;
        double Phone = 10;
        double Email = 15;
        double Address = 30;
        double Wage = 10;
        double Action = 10;
        //header
        EmployeeList_Header_Add("ID", ID, HBox_employessList_header);
        EmployeeList_Header_Add("First Name", Fname, HBox_employessList_header);
        EmployeeList_Header_Add("Last Name", Lname, HBox_employessList_header);
        EmployeeList_Header_Add("Phone Number", Phone, HBox_employessList_header);
        EmployeeList_Header_Add("Email", Email, HBox_employessList_header);
        EmployeeList_Header_Add("Address", Address, HBox_employessList_header);
        EmployeeList_Header_Add("Wage", Wage, HBox_employessList_header);
        EmployeeList_Header_Add("Action", Action, HBox_employessList_header);
        
        for(int  i = 0;i <20;i++){
            HBox employee_unit = new HBox();
            employee_unit.getStyleClass().add("List_Unit");
            employee_unit.setPrefWidth(Pane_Content_Width);
            //employee_unit.setPrefHeight(50);
            employee_unit.getChildren().add(Employee_unit("t923",ID));
            employee_unit.getChildren().add(Employee_unit("Tong", Fname));
            employee_unit.getChildren().add(Employee_unit("Ha", Lname));
            employee_unit.getChildren().add(Employee_unit("3462191755", Phone));
            employee_unit.getChildren().add(Employee_unit("haquoctong59@gmail.com", Email));
            employee_unit.getChildren().add(Employee_unit("8515 Battle Plaints, Houston, TX 77040", Address));
            employee_unit.getChildren().add(Employee_unit("$9.75", Wage));
            employee_unit.getChildren().add(Employee_unit("", Action));
            
            employee_unit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    trans.FadeInOut(pane_detail,List_pane);
                }
            });

            Vbox_Employee_Unit_list.getChildren().add(employee_unit);
        }
        
    }
    
    // Working Detail List
    void Employee_Working_List(){
        HBox_Detail_Header.getStyleClass().add("List_Header");
        double Date = 20;
        double From = 15;
        double To = 15;
        double TotalHours = 15;
        double Wage = 10;
        double Total = 15;
        double Paid = 10;

        //header
        EmployeeList_Header_Add("Date", Date, HBox_Detail_Header);
        EmployeeList_Header_Add("From", From, HBox_Detail_Header);
        EmployeeList_Header_Add("To", To, HBox_Detail_Header);
        EmployeeList_Header_Add("Total Hours", TotalHours, HBox_Detail_Header);
        EmployeeList_Header_Add("Wage", Wage, HBox_Detail_Header);
        EmployeeList_Header_Add("Total", Total, HBox_Detail_Header);
        EmployeeList_Header_Add("Status", Paid, HBox_Detail_Header);
        
        for(int  i = 0;i <20;i++){
            HBox detail_unit = new HBox();
            detail_unit.getStyleClass().add("List_Unit");
            detail_unit.setPrefWidth(Pane_Content_Width - panel_left_detail.getPrefWidth());
            //employee_unit.setPrefHeight(50);
            detail_unit.getChildren().add(Employee_unit("Mar 8, 2020",Date));
            detail_unit.getChildren().add(Employee_unit("10:00", From));
            detail_unit.getChildren().add(Employee_unit("21:00", To));
            detail_unit.getChildren().add(Employee_unit("11:00 Hours", TotalHours));
            detail_unit.getChildren().add(Employee_unit("$9.75", Wage));
            detail_unit.getChildren().add(Employee_unit("$107.25", Total));
            detail_unit.getChildren().add(Employee_unit("Paid", Paid));


            Vbox_Employee_Working_List.getChildren().add(detail_unit);
        }
        
    }
    
    void EmployeeList_Header_Add(String name, double Size, HBox box){
        Label _header = new Label();
        _header.getStyleClass().add("List_Header_label");
        _header.setText(name);
        _header.setPrefWidth(Size * Pane_Content_Width / 100);
        box.getChildren().add(_header);
    }
    
    Label Employee_unit(String name, double Size){
        Label _unit = new Label();
        _unit.setPrefHeight(50);
        _unit.getStyleClass().add("List_label");
        _unit.setText(name);
        _unit.setPrefWidth(Size * Pane_Content_Width / 100);
        
        return _unit;

    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        trans.FadeInOut(pane_list,List_pane);
    }

    @FXML
    private void OnAddNewEmployeeClicked(MouseEvent event) {
        Employee_AddController controller = new Employee_AddController();
        controller.Show(primaryStage);
        BoxBlur blur = new BoxBlur(5, 5, 5);
        ColorAdjust color = new ColorAdjust();
        color.setInput(blur);
        color.setBrightness(-0.5);
        primaryStage.setEffect(color);
        primaryStage.setDisable(true);
    }
    
}
