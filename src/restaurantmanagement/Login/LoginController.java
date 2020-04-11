/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.Login;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import restaurantmanagement.mylibs.Transition;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class LoginController implements Initializable {
    Transition trans;
    
    @FXML
    private Button btn_EmployeeLoginLogout;
    @FXML
    private AnchorPane pane_serverlogin;
    @FXML
    private AnchorPane pane_managerLogin;

    ArrayList<AnchorPane> pane_list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        trans = new Transition();
        PaneListSetup();
            
    }   
    
    void PaneListSetup(){
        pane_list = new ArrayList<>();
        pane_list.add(pane_serverlogin);
        pane_list.add(pane_managerLogin);
        
        for(int i = 0; i < pane_list.size();i++){
            pane_list.get(i).setOpacity(0);
            pane_list.get(i).setVisible(false);
        }
        pane_list.get(0).setOpacity(1);
        pane_list.get(0).setVisible(true);
    }

    @FXML
    private void OnServerSigninClicked(MouseEvent event) {
        trans.FadeInOut(pane_serverlogin, pane_list);
    }

    @FXML
    private void OnManagerLoginClicked(MouseEvent event) {
        trans.FadeInOut(pane_managerLogin, pane_list);
    }

    @FXML
    private void OnExitClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
}
