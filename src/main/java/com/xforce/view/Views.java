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
    AREAS("/com/xforce/view/fxml/Areas.fxml");
    
    
    private final String url; 
    Views(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
}
