/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.mylibs.CustomControl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class PopupController implements Initializable {

    @FXML
    private Label lbl_title;
    @FXML
    private Button btn_close;
    @FXML
    private VBox Vbox_messageContainer;

    ArrayList<String> list;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list = new ArrayList<>();
    }    
    
    public void getMessege(ArrayList<String> list){
        this.list = list;
        MessageList();
    }
    
    void MessageList(){
        Vbox_messageContainer.getChildren().clear();
        for(int  i = 0; i < list.size();i++){
            Label _message = new Label();
            _message.getStyleClass().add("Popup_Message");
            _message.setText("* "+list.get(i));
            Vbox_messageContainer.getChildren().add(_message);
        }
    }
    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    public void Show(ArrayList<String> list){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Popup.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException ex) {
            Logger.getLogger(PopupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PopupController controller = loader.getController();
        controller.getMessege(list);
        
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
