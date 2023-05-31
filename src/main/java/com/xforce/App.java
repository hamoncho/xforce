package com.xforce;

import com.xforce.view.ViewManager;
import com.xforce.view.Views;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        ViewManager.go(Views.PANEL_ADMIN);
    }

    public static void main(String[] args) {
        launch();
    }

}
