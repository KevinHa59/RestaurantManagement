/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.mylibs;

import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author KevinHa
 */
public class Transition {
    public ArrayList<AnchorPane> pane_list = new ArrayList<>();
    ArrayList<Label> title_list = new ArrayList<>();
    public int PaneID = 0;
    double Width = 0;
    
    public void TransitionAddPane(AnchorPane pane){
        pane_list.add(pane);
    }
    public void TransitionAddTitlePage(String pageTitle){
        Label _title = new Label();
        //_title.getStyleClass().add("SetupWizard_Left_Menu_Label");
        _title.setText((title_list.size() + 1)+". "+pageTitle);
        title_list.add(_title);
    }
    public void TransitionAddTitlePageComplete(VBox vbox){
        for(int i = 0; i < title_list.size();i++){
            vbox.getChildren().add(title_list.get(i));
        }
        TransitionAddTitlePageHighlight(PaneID);
    }
    public void TransitionAddTitlePageHighlight(int PageID){
        for(int i = 0; i < pane_list.size();i++){
            title_list.get(i).getStyleClass().clear();
            title_list.get(i).getStyleClass().add("SetupWizard_Left_Menu_Label");
        }
        title_list.get(PageID).getStyleClass().add("SetupWizard_Left_Menu_Label_Highlight");
    }
    
    public void TransitionSetup(){
        for(int i = 0; i < pane_list.size();i++){
            if(i == 0){
                pane_list.get(i).setOpacity(1);
                pane_list.get(i).setTranslateX(0);
            }else{
                //pane_list.get(i).setOpacity(0);
                pane_list.get(i).setTranslateX(600);
            }
        }
    }

    public void TransitionSetWidth(double width){
        Width = width;
    }
    // Page Update
    public void PanelTransitionPageUpdate(Label page){
        page.setText((PaneID+1)+"/"+ pane_list.size());
    }
    // Transition Slide & Fade --------------->>>>>>>>>>>>>>>>>>>>>>>>>
    public void PanelTransitionNextSlideFade(){
        if(PaneID < pane_list.size()-1){
            PaneID+=1;
            TranslateTransition nextp = new TranslateTransition();
            nextp.setDuration(Duration.seconds(0.5));
            nextp.setNode(pane_list.get(PaneID));
            pane_list.get(PaneID).setTranslateX(Width); // set transition
            nextp.setToX(0);
            nextp.play();
            if(PaneID-1 >= 0){
                TranslateTransition currentp = new TranslateTransition();
                currentp.setDuration(Duration.seconds(0.5));
                currentp.setNode(pane_list.get(PaneID-1));
                currentp.setToX(-Width);
                currentp.play();
            }

            FadeTransition nextft = new FadeTransition(); // set Fade
            nextft.setDuration(Duration.seconds(0.5));
            nextft.setNode(pane_list.get(PaneID));
            pane_list.get(PaneID).setOpacity(0);
            nextft.setToValue(1);
            nextft.play();

            if(PaneID-1 >= 0){
                FadeTransition currentft = new FadeTransition(); // set Fade
                currentft.setDuration(Duration.seconds(0.5));
                currentft.setNode(pane_list.get(PaneID-1));
                currentft.setToValue(0);
                currentft.play();
            }
        }
        
        // Hight Light
        TransitionAddTitlePageHighlight(PaneID);
    }
    public void PanelTransitionBackSlideFade(){
        if(PaneID > 0){
            PaneID-=1;
            TranslateTransition nextp = new TranslateTransition();
            nextp.setDuration(Duration.seconds(0.5));
            nextp.setNode(pane_list.get(PaneID));
            nextp.setToX(0);
            nextp.play();
            if(PaneID+1 < pane_list.size()){
                TranslateTransition currentp = new TranslateTransition();
                currentp.setDuration(Duration.seconds(0.5));
                currentp.setNode(pane_list.get(PaneID+1));
                currentp.setToX(Width);
                currentp.play();
            }

            FadeTransition nextft = new FadeTransition(); // set Fade
            nextft.setDuration(Duration.seconds(0.5));
            nextft.setNode(pane_list.get(PaneID));
            pane_list.get(PaneID).setOpacity(0);
            nextft.setToValue(1);
            nextft.play();

            if(PaneID+1 >= 0){
                FadeTransition currentft = new FadeTransition(); // set Fade
                currentft.setDuration(Duration.seconds(0.5));
                currentft.setNode(pane_list.get(PaneID+1));
                currentft.setToValue(0);
                currentft.play();
            }
        }
        // Hight Light
        TransitionAddTitlePageHighlight(PaneID);
    }
    // Transition Slide & Fade --------------->>>>>>>>>>>>>>>>>>>>>>>>>
    public void PanelTransitionNextSlide(){
        if(PaneID < pane_list.size()-1){
            PaneID+=1;
            TranslateTransition nextp = new TranslateTransition();
            nextp.setDuration(Duration.seconds(0.5));
            nextp.setNode(pane_list.get(PaneID));
            pane_list.get(PaneID).setTranslateX(Width); // set transition
            nextp.setToX(0);
            nextp.play();
            if(PaneID-1 >= 0){
                TranslateTransition currentp = new TranslateTransition();
                currentp.setDuration(Duration.seconds(0.5));
                currentp.setNode(pane_list.get(PaneID-1));
                currentp.setToX(-Width);
                currentp.play();
            }
        }
        // Hight Light
        TransitionAddTitlePageHighlight(PaneID);
    }
    public void PanelTransitionBackSlide(){
        if(PaneID > 0){
            PaneID-=1;
            TranslateTransition nextp = new TranslateTransition();
            nextp.setDuration(Duration.seconds(0.5));
            nextp.setNode(pane_list.get(PaneID));
            nextp.setToX(0);
            nextp.play();
            if(PaneID+1 < pane_list.size()){
                TranslateTransition currentp = new TranslateTransition();
                currentp.setDuration(Duration.seconds(0.5));
                currentp.setNode(pane_list.get(PaneID+1));
                currentp.setToX(Width);
                currentp.play();
            }

        }
        // Hight Light
        TransitionAddTitlePageHighlight(PaneID);
    }
    
    // Fade In & Out
    public void FadeInOut(AnchorPane in, ArrayList<AnchorPane> out){
        //Fade out
        for(int i = 0; i < out.size();i++){
            out.get(i).setVisible(false);
        }
        //Fade in
        FadeTransition ftin = new FadeTransition();
        ftin.setDuration(Duration.seconds(0.5));
        in.setOpacity(0);
        in.setVisible(true);
        ftin.setNode(in);
        ftin.setToValue(1);
        ftin.play();
        
    }
    
    public void FadeIn(AnchorPane in){
        //Fade in
        FadeTransition ftin = new FadeTransition();
        ftin.setDuration(Duration.seconds(0.5));
        in.setOpacity(0);
        in.setVisible(true);
        ftin.setNode(in);
        ftin.setToValue(1);
        ftin.play();
        
    }
    
    public void FadeOutExit(AnchorPane in, MouseEvent event){
        //Fade in
        FadeTransition ftin = new FadeTransition();
        ftin.setDuration(Duration.seconds(0.3));
        
        in.setOpacity(1);
        in.setVisible(true);
        ftin.setNode(in);
        ftin.setToValue(0);
        ftin.play();
        
        ftin.setOnFinished(e -> ZoomFinish(event));
        
    }
    // Zoom In & Out
    public void ZoomIn(AnchorPane in){
        ScaleTransition zin = new ScaleTransition();
        zin.setDuration(Duration.seconds(0.2));
        in.setScaleX(0);
        in.setScaleY(0);
        zin.setNode(in);
        zin.setToX(1);
        zin.setToY(1);
        zin.play();

    }
    public void ZoomoutExit(AnchorPane out, MouseEvent event){
        boolean finish = false;
        ScaleTransition zout = new ScaleTransition();
        zout.setDuration(Duration.seconds(0.2));
        zout.setOnFinished(e -> ZoomFinish(event));
        out.setScaleX(1);
        out.setScaleY(1);
        zout.setNode(out);
        zout.setToX(0);
        zout.setToY(0);
        zout.play();
 
    }
    void ZoomFinish(MouseEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

}
