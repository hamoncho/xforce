package com.xforce;

import com.xforce.view.ViewManager;
import com.xforce.view.Views;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        IntStream.range(0, 10).reduce(0, Integer::sum);
        ViewManager.go(Views.LOGIN);
    }

    public static void main(String[] args) {
        launch();
    }

}