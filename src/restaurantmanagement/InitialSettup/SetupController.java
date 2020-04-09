/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.InitialSettup;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    /**
     * Initializes the controller class.
     */
    
    ArrayList<AnchorPane> pane_list;
    int PaneID = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PaneSetup();
    }    

    // Pane Setup
    void PaneSetup(){
        pane_list = new ArrayList<>();
        pane_list.add(pane_RestaurantName_1);
        pane_list.add(pane_RestaurantAddress_2);
        pane_list.add(pane_RestaurantContact_3);
        pane_list.add(pane_RestaurantMoreInfo_4);
        pane_list.add(pane_ManagerInforamtion_5);
        pane_list.add(pane_ManagerAccount_6);
        pane_list.get(PaneID).setVisible(true);
    }
    void SwitchPane(int PaneID){
        for(int i = 0;i < pane_list.size();i++){
            pane_list.get(i).setVisible(false);
        }
        pane_list.get(PaneID).setVisible(true);
    }
    @FXML
    private void OnNextClicked(MouseEvent event) {
        if(PaneID < pane_list.size()-1){
            PaneID+=1;
            SwitchPane(PaneID);
        }
    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        if(PaneID > 0){
            PaneID-=1;
            SwitchPane(PaneID);
        }
    }
    
}
