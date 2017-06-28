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
import javafx.scene.control.Button;
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
    private Button buttonVisualizarSalario;
    @FXML
    private Button buttonSolicitarCompras;
    @FXML
    private Button buttonCadastrarCliente;
    @FXML
    private Button buttonSair;
    
    private Stage stage;

    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void handleSalary() {
        Employee emp = getEmployeeById(1);
        Util.Alert(Alert.AlertType.INFORMATION, "Informação", "Consulta de salário", "R$ ");
    }
    
    public void handleExit() {
        this.stage.close();
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
