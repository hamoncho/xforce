/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.view;

import com.xforce.App;
import static com.xforce.view.Views.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

/**
 *
 * @author Hamoncho
 */
public class ViewManager {
private static final StageBuilder SINGLE_STAGE = new StageBuilder();

    public static void go(Views view) {
        switch (view) {
            case SING_IN ->
                loadView(SING_IN).show();

            case LOGIN ->
                loadView(LOGIN)
                        .setResizable(false)
                        .initStyle(StageStyle.UNDECORATED)
                        .show();

            default ->
                loadView(view)
                        .setMaximized(true)
                        .show();
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    private static StageBuilder loadView(Views view) {
        try {
            Scene scene = new Scene(loadFXML(view.getUrl()));
            SINGLE_STAGE
                    .newStage()
                    .setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SINGLE_STAGE;
    }

}

