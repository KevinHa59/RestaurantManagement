/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import restaurantmanagement.DatabaseConnection;
import restaurantmanagement.mylibs.Transition;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Position_AddController implements Initializable {

    DatabaseConnection database;
    Transition trans;
    
    @FXML
    private AnchorPane pane_ManagerInforamtion_5;
    @FXML
    private TextField txt_Title;
    @FXML
    private TextArea txt_Desc;

    @FXML
    private TextField txt_TrainWage;
    @FXML
    private TextField txt_MainWage;

        
    AnchorPane _root;
    @FXML
    private AnchorPane NewPotitionParent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        trans = new Transition();
        trans.FadeIn(NewPotitionParent);
    }    

    void GetInformation(AnchorPane _root){
        this._root = _root;
    }
    
    public void Show(AnchorPane _root){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Position_Add.fxml"));
        
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(Employee_AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Position_AddController controller = loader.getController();
        controller.GetInformation(_root);
        
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        
    }
    
    @FXML
    private void OnAddClicked(MouseEvent event) {

        database.AddNewPosition(txt_Title.getText(), txt_Desc.getText(), txt_MainWage.getText(), txt_TrainWage.getText());
        
        trans.FadeOutExit(NewPotitionParent, event);
        _root.setEffect(null);
        _root.setDisable(false);

    }

    @FXML
    private void OnExitClicked(MouseEvent event) {
        trans.FadeOutExit(NewPotitionParent, event);
        _root.setEffect(null);
        _root.setDisable(false);
    }
    
}
