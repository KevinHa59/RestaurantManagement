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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;
import restaurantmanagement.DatabaseConnection;
import restaurantmanagement.mylibs.Transition;
import restaurantmanagement.mylibs.Validation;


/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class SetupController implements Initializable {

    DatabaseConnection database;
    
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
    
    Transition trans;
    Validation val;
    @FXML
    private Button btn_next;
    @FXML
    private CheckBox cbx_notFirstRestaurant;
    @FXML
    private AnchorPane pane_notFirstRestaurant;
    @FXML
    private TextField txt_restName_FirstCode;
    
    ArrayList<String> RestName_list;
    @FXML
    private TextField txt_restSubName;
    @FXML
    private Button btn_next1;
    @FXML
    private AnchorPane pane_button;
    
    BoxBlur blur;
    @FXML
    private AnchorPane Main;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        blur = new BoxBlur(3, 3, 3);
        database = new DatabaseConnection();
        trans = new Transition();
        val = new Validation();
        PaneSetup();
        trans.TransitionSetup();
        trans.TransitionSetWidth(460);
        
        RestName_list = new ArrayList<>();
        RestName_list.add("Pho And & Sushi Bar");
        RestName_list.add("Pho Dung");
        RestName_list.add("Pho Danh");
        RestName_list.add("Pho Dalat");
        RestName_list.add("Bun Bo Hue Duc Chuong");
        RestName_list.add("Com Tam 9");
        RestName_list.add("Com Tam Thuan Kieu");
        RestName_list.add("Pho 49");
        
        TextFields.bindAutoCompletion(txt_restName, RestName_list);
        
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
        
        for(int i = 0 ; i< trans.pane_list.size();i++){
            trans.pane_list.get(i).setVisible(true);
        }
        
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
        String ResName = txt_restName.getText();
        if(!txt_restSubName.getText().equals("")){
            ResName += " - " + txt_restSubName.getText();
        }
        
        lbl_restName.setText(ResName);
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
    
    // Validate Process
    void ValidationProcess(){
        val.ValidationEmpty(txt_restName, "Restaurant's Name");
        val.ValidationEmpty(txt_restAddressStreet, "Restaurant's Street");
        val.ValidationEmpty(txt_restAddressCity, "Restaurant's City");
        val.ValidationEmpty(txt_restAddressState, "Restaurant's State");
        val.ValidationZipcode(txt_restAddressZip, "Restaurant's Zip");
        val.ValidationEmail(txt_restContactEmail, "Restaurant's Email");
        val.ValidationPhone(txt_restContactPhone, "Restaurant's Phone");
        val.ValidationEmpty(txt_restContactCountry, "Food's Country");
        val.ValidationNumber(txt_restContactTable, "Quantity of Table");
        val.ValidationEmpty(txt_ManagerFirstname, "Manager's Firstname");
        val.ValidationEmpty(txt_ManagerLastname, "Manager's Lastname");
        val.ValidationEmail(txt_ManagerEmail, "Manager's Email");
        val.ValidationPhone(txt_ManagerPhone, "Manager's Phone");
        val.ValidationEmpty(txt_ManagerUsername, "Manager's Username");
        val.ValidationEmpty(txt_ManagerPassword, "Manager's Password");
        val.ValidationMatch(txt_ManagerPassword, txt_ManagerConfirmPassword, "Manager's Password");
        val.ValidationPin(txt_ManagerPin, "Manager's Pin Number");
        val.ValidationMatch(txt_ManagerPin, txt_ManagerConfirmPin, "Manager's Pin Number");
    }
    
    
    @FXML
    private void OnNextClicked(MouseEvent event) {
        //
        if(trans.PaneID < (trans.pane_list.size()-3)){
            trans.PanelTransitionNextSlideFade();
            trans.PanelTransitionPageUpdate(lbl_page);
            
            
        }else if(trans.PaneID < (trans.pane_list.size()-2)){
            trans.PanelTransitionNextSlideFade();
            trans.PanelTransitionPageUpdate(lbl_page);
            btn_next.setText("Review");
            
        }else if(trans.PaneID < (trans.pane_list.size()-1)){
            
            ValidationProcess();
            if(val.ValidationCheck(root) == true){
                btn_next.setText("Finish");
                trans.PanelTransitionNextSlideFade();
                trans.PanelTransitionPageUpdate(lbl_page);
                Review();
            }
        }else {
            database.AddNewRestaurant(txt_restName.getText(), txt_restSubName.getText(), txt_restAddressStreet.getText(), txt_restAddressCity.getText(), txt_restAddressState.getText(), txt_restAddressZip.getText(), txt_restContactEmail.getText(), txt_restContactPhone.getText(), txt_restContactTable.getText(), "1");
            database.AddManager(txt_ManagerUsername.getText(), txt_ManagerPassword.getText(), txt_ManagerFirstname.getText(), txt_ManagerLastname.getText(), txt_ManagerEmail.getText(), txt_ManagerPhone.getText(), txt_ManagerPin.getText());
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        trans.PanelTransitionBackSlideFade();
        trans.PanelTransitionPageUpdate(lbl_page);
        
        if(trans.PaneID < (trans.pane_list.size()-2)){
            btn_next.setText("Next");
        }else{
            btn_next.setText("Review");
        }
    }

    @FXML
    private void OnExitClicked(MouseEvent event) {
        trans.FadeOutExit(root,event);
    }

    @FXML
    private void OnNotFirstRestCbxClicked(MouseEvent event) {
        if(cbx_notFirstRestaurant.isSelected()){
            pane_notFirstRestaurant.setVisible(true);
            pane_button.setVisible(false);
        }else{
            pane_notFirstRestaurant.setVisible(false);
            pane_button.setVisible(true);
        }
    }
    
}
