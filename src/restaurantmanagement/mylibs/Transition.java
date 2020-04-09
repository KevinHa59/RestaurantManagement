/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantmanagement.mylibs;

import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author KevinHa
 */
public class Transition {
    ArrayList<AnchorPane> pane_list = new ArrayList<>();
    int PaneID = 0;
    double Width = 0;
    
    public void TransitionAddPane(AnchorPane pane){
        pane_list.add(pane);
    }
    
    public void TransitionSetup(){
        for(int i = 0; i < pane_list.size();i++){
            if(i == 0){
                pane_list.get(i).setOpacity(1);
                pane_list.get(i).setTranslateX(0);
            }else{
                pane_list.get(i).setOpacity(0);
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
    }
}
