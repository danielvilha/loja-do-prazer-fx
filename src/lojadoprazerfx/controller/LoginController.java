/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lojadoprazerfx.entity.User;
import lojadoprazerfx.entity.Users;
import lojadoprazerfx.util.MainUtil;
import lojadoprazerfx.util.Util;

/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class LoginController extends MainUtil {
    
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
    }
    
    @FXML
    private void handleLogin() {
        if (!loginTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty()) {
            Users list = Util.getUsers();
            User user = existLogin(list, loginTextField.getText(), passwordTextField.getText());
            
            if (user != null && user.getLogin() != null) {
                switch(user.getType()) {
                    case 1:
                        // Employee
                        getMain().showHomeEmployee();
                        break;
                    case 2:
                        // Client
                        
                        break;
                    case 3:
                        // Company
                        
                        break;
                }
            }
            
        } else {
            Alert(Alert.AlertType.ERROR, "Erro", "Login inválido!", "Favor preencher todos os campos.");
        }
    }
    
    private void Alert(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert alert = new Alert(type);
                      alert.setTitle(title);
                      alert.setHeaderText(headerText);
                      alert.setContentText(contentText);
                alert.showAndWait();
    }
    
    public User existLogin(Users uList, String login, String password) {
        
        for (User user : uList.getUsers()) {
            if (user.getLogin().contains(login)) {
                if (user.getPassword().contains(password)) {
                    return user;
                }
            }
        }
        
        return new User();
    }
}
