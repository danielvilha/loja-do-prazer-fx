/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import lojadoprazerfx.util.MainUtil;

/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class EmployeeController extends MainUtil {
    
    @FXML
    private MenuItem menuItemSair;
    
    private Stage stage;

    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void handleSalary() {
        this.getMain().showSalaryEmployee();
    }
    
    public void handleExit() {
        this.stage.close();
    }
}
