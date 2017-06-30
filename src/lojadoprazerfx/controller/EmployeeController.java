/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lojadoprazerfx.entity.Employee;
import lojadoprazerfx.entity.Employees;
import lojadoprazerfx.util.MainUtil;
import lojadoprazerfx.util.Util;

/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class EmployeeController extends MainUtil {
    
    @FXML
    private MenuItem menuItem;
    @FXML
    private MenuItem menuItemViewSalario;
    @FXML
    private MenuItem menuItemSolCompras;
    @FXML
    private MenuItem menuItemCadCliente;
    @FXML
    private AnchorPane containerEmployee;
    
    
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
    
    @FXML
    public void handleSalary() {
        Employee emp = getEmployeeById(getUser().getId());
        Util.Alert(Alert.AlertType.INFORMATION, "Informação", "Consulta de salário", "R$ ");
    }
    
    @FXML
    public void handleSolCompras() {
        Employee emp = getEmployeeById(getUser().getId());
        Util.Alert(Alert.AlertType.INFORMATION, "Informação", "Consulta de salário", "R$ ");
    }
    
    @FXML
    public void handleCadCliente() {
        getMain().showUserEditDialog();
    }
    
    @FXML
    public void handleExit() {
        getMain().showLoginView();
    }
    
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        
        try {
            Employees employeeList = (Employees) Util.getEmployees();
            
            for (Employee emp : employeeList.getEmployees()) {
                if (emp.getId() == id) {
                    employee = emp;
                    employee.setUser(Util.getUserById(employee.getId()));
                }
            }
            
            return employee;
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
