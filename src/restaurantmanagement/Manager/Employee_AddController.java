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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import restaurantmanagement.mylibs.Transition;
import restaurantmanagement.mylibs.Validation;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Employee_AddController implements Initializable {
    Validation val;
    Transition trans;
    @FXML
    private AnchorPane pane_ManagerInforamtion_5;
    @FXML
    private TextField txt_Firstname;
    @FXML
    private TextField txt_Lastname;
    @FXML
    private TextField txt_Email;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_AddressStreet;
    @FXML
    private TextField txt_AddressCity;
    @FXML
    private TextField txt_AddressState;
    @FXML
    private TextField txt_AddressZip;
    @FXML
    private PasswordField txt_Pin;
    @FXML
    private PasswordField txt_ConfirmPin;
    
    AnchorPane primaryStage;
    @FXML
    private AnchorPane Add_Emp_Parent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        val = new Validation();
        trans = new Transition();
        trans.FadeIn(Add_Emp_Parent);
    }    
    void GetInformation(AnchorPane _root){
        primaryStage = _root;
    }
    
    public void Show(AnchorPane _root){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Employee_Add.fxml"));
        
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(Employee_AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Employee_AddController controller = loader.getController();
        controller.GetInformation(_root);
        
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        
    }
    // Validate Textbox
    void Validate(){
        val.ValidationEmpty(txt_Firstname, "First name");
        val.ValidationEmpty(txt_Lastname, "Last name");
        val.ValidationEmail(txt_Email, "Email");
        val.ValidationPhone(txt_Phone, "Phone");
        val.ValidationEmpty(txt_AddressStreet, "Address");
        val.ValidationEmpty(txt_AddressCity, "City");
        val.ValidationEmpty(txt_AddressState, "State");
        val.ValidationZipcode(txt_AddressZip, "Zip");
        val.ValidationPin(txt_Pin, "Pin");
        val.ValidationMatch(txt_Pin, txt_ConfirmPin, "Pin");
        val.ValidationCheck(Add_Emp_Parent);
        
    }
    
    @FXML
    private void OnExitClicked(MouseEvent event) {
        trans.FadeOutExit(Add_Emp_Parent, event);
        primaryStage.setEffect(null);
        primaryStage.setDisable(false);
    }

    @FXML
    private void OnAddClicked(MouseEvent event) {
        Validate();
        
    }
    
}
