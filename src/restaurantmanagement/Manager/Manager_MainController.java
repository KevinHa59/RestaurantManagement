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
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javax.swing.text.View;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Manager_MainController implements Initializable {

    @FXML
    private AnchorPane primaryStage;
    double Pane_Content_Width = 0;
    @FXML
    private AnchorPane pane_left;
    @FXML
    private BorderPane borderPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SizeSetup();
    }    
    
    void SizeSetup(){
        Screen sc = Screen.getPrimary();
        Rectangle2D bound = sc.getBounds();
        primaryStage.setPrefSize(bound.getMaxX(), bound.getMaxY()-40);
        
        // get pane center width
        Pane_Content_Width = bound.getMaxX() - pane_left.getPrefWidth(); 
        
        
    }

    @FXML
    private void OnEmployeesClicked(MouseEvent event) {
        Parent root = null;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Employees_Manage.fxml"));

        try {
            root = loader.load();
            
        } catch (IOException ex) {
            Logger.getLogger(Manager_MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Employees_ManageController controller = loader.getController();
        controller.GetDetail(Pane_Content_Width, primaryStage);
        borderPane.setCenter(root);
        
    }

    @FXML
    private void OnPositionClicked(MouseEvent event) {
        Parent root = null;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Position_Manage.fxml"));

        try {
            root = loader.load();
            
        } catch (IOException ex) {
            Logger.getLogger(Manager_MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Position_ManageController controller = loader.getController();
        controller.GetDetail(Pane_Content_Width, primaryStage);
        borderPane.setCenter(root);
    }
    
    
    
}
