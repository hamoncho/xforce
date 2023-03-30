/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hamoncho
 */
public class StageBuilder {
    private  Stage stage = new Stage();

    public StageBuilder setStage(Stage stage) {
        if (this.stage != null) {
            this.stage.close();
        }
        this.stage = stage;
        return this;
    }
    
    public StageBuilder newStage(){       
        this.setStage(new Stage());
        return this;
    }
    
    public StageBuilder setScene(Scene scene) {
        stage.setScene(scene);
        return this;
    }

    public void show() {
        stage.show();
        
    }

    public StageBuilder setResizable(boolean bln) {
        stage.setResizable(bln);
        return this;
    }

    public StageBuilder initStyle(StageStyle ss) {
        stage.initStyle(ss);
        return this;
    }
    
    public StageBuilder setMaximized(boolean bln){
        stage.setMaximized(bln);
        return this;
    }
}
