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
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    @FXML
    private VBox VBox_TitlePage;
    @FXML
    private Label lbl_restName;
    @FXML
    private Label lbl_restAddress;
    @FXML
    private Label lbl_restEmail;
    @FXML
    private Label lbl_restPhone;
    @FXML
    private Label lbl_restCountryFood;
    @FXML
    private Label lbl_restTableQuan;
    @FXML
    private Label lbl_ManagerName;
    @FXML
    private Label lbl_ManagerEmail;
    @FXML
    private Label lbl_ManagerPhone;
    @FXML
    private AnchorPane pane_Review;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        trans = new Transition();
        PaneSetup();
        trans.TransitionSetup();
        trans.TransitionSetWidth(460);
        
        
    }    

    // Pane Setup
    void PaneSetup(){
        trans.TransitionAddPane(pane_RestaurantName_1);
        trans.TransitionAddPane(pane_RestaurantAddress_2);
        trans.TransitionAddPane(pane_RestaurantContact_3);
        trans.TransitionAddPane(pane_RestaurantMoreInfo_4);
        trans.TransitionAddPane(pane_ManagerInforamtion_5);
        trans.TransitionAddPane(pane_ManagerAccount_6);
        trans.TransitionAddPane(pane_Review);
        
        trans.TransitionAddTitlePage("Restaurant Name");
        trans.TransitionAddTitlePage("Restaurant Address");
        trans.TransitionAddTitlePage("Restaurant Contact");
        trans.TransitionAddTitlePage("Restaurant More Info");
        trans.TransitionAddTitlePage("Manager Info");
        trans.TransitionAddTitlePage("Manager Account");
        trans.TransitionAddTitlePage("Review Information");
        
        trans.TransitionAddTitlePageComplete(VBox_TitlePage);
    }
    
    // Final Review
    void Review(){
        lbl_restName.setText(txt_restName.getText());
        lbl_restAddress.setText(txt_restAddressStreet.getText() + ", " + txt_restAddressCity.getText()+", " + txt_restAddressState.getText() + " " + txt_restAddressZip.getText());
        lbl_restEmail.setText(txt_restContactEmail.getText());
        lbl_restPhone.setText(PhoneFormat(txt_restContactPhone.getText()));
        lbl_restCountryFood.setText(txt_restContactCountry.getText());
        lbl_restTableQuan.setText(txt_restContactTable.getText());
        lbl_ManagerName.setText(txt_ManagerFirstname.getText() + " " + txt_ManagerLastname.getText());
        lbl_ManagerEmail.setText(txt_ManagerEmail.getText());
        lbl_ManagerPhone.setText(PhoneFormat(txt_ManagerPhone.getText()));
        
    }
    String PhoneFormat(String phone){
        String _phone = "";
        if(!phone.equals("")){
        _phone = "(" + phone.charAt(0)+phone.charAt(1)+phone.charAt(2)+") " + phone.charAt(3)+phone.charAt(4)+phone.charAt(5)+ "-" +phone.charAt(6)+phone.charAt(7)+phone.charAt(8)+phone.charAt(9);
        }
        return _phone;
    }
    @FXML
    private void OnNextClicked(MouseEvent event) {
        trans.PanelTransitionNextSlide();
        trans.PanelTransitionPageUpdate(lbl_page);
        Review();
    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        trans.PanelTransitionBackSlide();
        trans.PanelTransitionPageUpdate(lbl_page);
    }

    @FXML
    private void OnExitClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
