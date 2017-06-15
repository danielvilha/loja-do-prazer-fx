/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class EmployeeSalaryController {
    
    @FXML
    private Label salaryField;
    
    private Stage stage;
    
    @FXML
    private void initialize() {
    }
    
    
    
    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void handlerOk() {
        this.stage.close();
    }
}
