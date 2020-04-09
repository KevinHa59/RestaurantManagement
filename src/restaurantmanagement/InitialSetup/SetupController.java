/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.InitialSetup;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import restaurantmanagement.mylibs.Transition;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class SetupController implements Initializable {

    @FXML
    private AnchorPane pane_RestaurantName_1;
    @FXML
    private TextField txt_restName;
    @FXML
    private AnchorPane pane_RestaurantAddress_2;
    @FXML
    private TextField txt_restAddressStreet;
    @FXML
    private TextField txt_restAddressCity;
    @FXML
    private TextField txt_restAddressState;
    @FXML
    private TextField txt_restAddressZip;
    @FXML
    private AnchorPane pane_RestaurantContact_3;
    @FXML
    private TextField txt_restContactEmail;
    @FXML
    private TextField txt_restContactPhone;
    @FXML
    private AnchorPane pane_RestaurantMoreInfo_4;
    @FXML
    private TextField txt_restContactCountry;
    @FXML
    private TextField txt_restContactTable;
    @FXML
    private AnchorPane pane_ManagerInforamtion_5;
    @FXML
    private TextField txt_ManagerFirstname;
    @FXML
    private TextField txt_ManagerEmail;
    @FXML
    private TextField txt_ManagerLastname;
    @FXML
    private TextField txt_ManagerPhone;
    @FXML
    private AnchorPane pane_ManagerAccount_6;
    @FXML
    private TextField txt_ManagerUsername;
    @FXML
    private PasswordField txt_ManagerPassword;
    @FXML
    private PasswordField txt_ManagerConfirmPassword;
    @FXML
    private PasswordField txt_ManagerPin;
    @FXML
    private PasswordField txt_ManagerConfirmPin;
    @FXML
    private AnchorPane root;
    @FXML
    private Label lbl_page;
    /**
     * Initializes the controller class.
     */
    
    Transition trans;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        trans = new Transition();
        PaneSetup();
        trans.TransitionSetup();
        trans.TransitionSetWidth(root.getPrefWidth());
        
        
    }    

    // Pane Setup
    void PaneSetup(){
        trans.TransitionAddPane(pane_RestaurantName_1);
        trans.TransitionAddPane(pane_RestaurantAddress_2);
        trans.TransitionAddPane(pane_RestaurantContact_3);
        trans.TransitionAddPane(pane_RestaurantMoreInfo_4);
        trans.TransitionAddPane(pane_ManagerInforamtion_5);
        trans.TransitionAddPane(pane_ManagerAccount_6);
    }
    @FXML
    private void OnNextClicked(MouseEvent event) {
        trans.PanelTransitionNextSlideFade();
        trans.PanelTransitionPageUpdate(lbl_page);
    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        trans.PanelTransitionBackSlideFade();
        trans.PanelTransitionPageUpdate(lbl_page);
    }
    
}
