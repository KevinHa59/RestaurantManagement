/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.Manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import restaurantmanagement.DatabaseConnection;
import restaurantmanagement.mylibs.Transition;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Position_ManageController implements Initializable {

    DatabaseConnection database;
    Transition trans;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane pane_list;
    @FXML
    private VBox Vbox_Employee_Unit_list;
    @FXML
    private HBox HBox_employessList_header1;

    AnchorPane primaryStage;
    ArrayList<ArrayList<String>> list;
    double width = 0;
    @FXML
    private AnchorPane Pane_List_title;
    @FXML
    private Label List_title;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        trans = new Transition();
        trans.FadeIn(root);
        
    }
// Get Detail
    public void GetDetail(double Width, AnchorPane primaryStage){
        width = Width;
        this.primaryStage = primaryStage;
        
        LoadAllPosition();
        
    }
    
    // Load Position
    public void LoadAllPosition(){
        list = database.LoadAllPosition();
        Vbox_Employee_Unit_list.getChildren().clear();
        for(int i = 0; i < list.get(0).size();i++){
            Position_Unit(list.get(1).get(i),list.get(2).get(i),list.get(3).get(i),list.get(4).get(i));
        }
    }

    // Position Detail Design
    void Position_Unit(String Title, String Desc, String MainWage, String TrainWage){
        VBox container = new VBox();
        container.getStyleClass().add("Position_Container");
        container.setPrefWidth(width);
        
        Label _Title = new Label();
        _Title.getStyleClass().add("Position_Title");
        _Title.setText(Title);
        
        Label _Desc = new Label();
        _Desc.setPrefWidth(width-100);
        _Desc.setWrapText(true);
        _Desc.getStyleClass().add("Position_Description");
        _Desc.setText(Desc);
        
        Label _Wage = new Label();
        _Wage.getStyleClass().add("Position_Wage");
        _Wage.setText("Main Wage: $ "+MainWage+"/hr");
        
        Label _TrainWage = new Label();
        _TrainWage.getStyleClass().add("Train_Wage");
        _TrainWage.setText("Training Wage: $ "+TrainWage+"/hr");
        
        container.getChildren().add(_Title);
        container.getChildren().add(_Desc);
        container.getChildren().add(_Wage);
        container.getChildren().add(_TrainWage);
        
        Vbox_Employee_Unit_list.getChildren().add(container);
    }
    
    
    
    //  Button Events
    @FXML
    private void OnAddNewPositionClicked(MouseEvent event) {
        Position_AddController controller = new Position_AddController();
        controller.Show(primaryStage);
        BoxBlur blur = new BoxBlur(5, 5, 5);
        ColorAdjust color = new ColorAdjust();
        color.setInput(blur);
        color.setBrightness(-0.5);
        primaryStage.setEffect(color);
        primaryStage.setDisable(true);
    }
    
}
