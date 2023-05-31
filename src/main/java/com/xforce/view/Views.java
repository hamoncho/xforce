/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.xforce.view;

/**
 *
 * @author Hamoncho
 */
public enum Views {
    LOGIN("/com/xforce/view/fxml/Login.fxml"),
    CUSTOMER_DASHBOARD("/com/xforce/view/fxml/CustomerDashboard.fxml"),
    SING_IN("/com/xforce/view/fxml/SignIn.fxml"),
    CARDIOVASCULAR_AREA("/com/xforce/view/fxml/CardiovascularArea.fxml"),
    FREE_WEIGHTS_AREA("/com/xforce/view/fxml/FreeWeightsArea.fxml"),
    FUNCTIONAL_FITNESS_AAREA("/com/xforce/view/fxml/FunctionalFitnessArea.fxml"),
    PERSONAL_TRAINING_CORNERS_AREA("/com/xforce/view/fxml/PersonalTrainingCornersArea.fxml"),
    STRETCHING_AND_MOBILITY_AREA("/com/xforce/view/fxml/StretchingAndMobilityArea.fxml"),
    PANEL_ADMIN("/com/xforce/view/fxml/AdminPanel.fxml"),
    INSCRIPTION("/com/xforce/view/fxml/Inscription.fxml"),
    AREAS("/com/xforce/view/fxml/Areas.fxml");

    private final String url;

    Views(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
