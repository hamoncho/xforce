/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.Calendar.Style;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.model.Interval;
import com.calendarfx.view.CalendarView;
import com.xforce.view.ViewManager;
import com.xforce.view.Views;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hamoncho
 */
public class CustomerDashboardController implements Initializable {

    @FXML
    private VBox nav;
    @FXML
    private ImageView imageViewUser;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ImageView imageViewCover;
    @FXML
    private Hyperlink hyperlinkUserName;
    @FXML
    private VBox container;
    @FXML
    private HBox logOut;
    @FXML
    private VBox footNav;

    CalendarView calendarView = new CalendarView(); // (1)

    private static CustomerDashboardController SIGLETON;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SIGLETON = this;
        addContenido();
        animacionNav();
        Rectangle rectangle = new Rectangle(imageViewCover.getFitWidth(), imageViewCover.getFitHeight());
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        imageViewCover.setClip(rectangle);

        Circle circle = new Circle(imageViewUser.getFitWidth() / 2);
        circle.setCenterX(50);
        circle.setCenterY(50);

        circle.setEffect(new DropShadow(20, 30, 30, Color.rgb(0, 0, 0, 1)));

        imageViewUser.setClip(circle);

    }

    private void animacionNav() {

        Timeline timeline = new Timeline();

        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, // set start position at 0
                        new KeyValue(nav.translateXProperty(), -250),
                        new KeyValue(nav.translateYProperty(), 0)),
                new KeyFrame(new Duration(2000), // set end position at 40s
                        new KeyValue(nav.translateXProperty(), 0),
                        new KeyValue(nav.translateYProperty(), 0)));

        timeline.play();
    }

    private void addContenido() {

        var cardio = new Calendar<>("Cardio"); // (2)
        var pierna = new Calendar<>("Pierna");
        Interval i = new Interval(
                LocalDateTime.of(2023, Month.MARCH, 11, 20, 25, 50),
                LocalDateTime.of(2023, Month.MARCH, 11, 21, 25, 50),
                ZoneId.systemDefault());

        pierna.addEntries(new Entry<>("Sentadilla", i));

        cardio.setStyle(Style.STYLE1); // (3)
        pierna.setStyle(Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("My Calendars"); // (4)
        myCalendarSource.getCalendars().addAll(cardio, pierna);

        calendarView.getCalendarSources().addAll(myCalendarSource); // (5)

        calendarView.setRequestedTime(LocalTime.now());

        Thread updateTimeThread;
        updateTimeThread = new Thread("Calendar: Update Time Thread") {
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendarView.setToday(LocalDate.now());
                        calendarView.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                    }

                }
            }
        };

        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();

        borderPane.setCenter(calendarView);
    }

    @FXML
    private void onMousePressedSchedule(MouseEvent event) {
        borderPane.setCenter(calendarView);
    }

    @FXML
    private void onActionUserName(ActionEvent event) {

    }

    @FXML
    private void onMousePressedLogout(MouseEvent event) {

        ViewManager.go(Views.LOGIN);
    }

    @FXML
    private void onMousePressedAreas(MouseEvent event) {
        try {
            borderPane.setCenter(ViewManager.loadFXML(Views.AREAS.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(CustomerDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setAreasView() {

        SIGLETON.onMousePressedAreas(null);

    }

    public static CustomerDashboardController getSIGLETON() {
        return SIGLETON;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

}
