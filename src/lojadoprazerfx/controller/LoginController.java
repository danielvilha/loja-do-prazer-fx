/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lojadoprazerfx.util.MainUtil;

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
            
            //Alert(Alert.AlertType.ERROR, "Erro", "Login ou senha inválido!", "Não foi possível realizar o seu login.");
            
            getMain().showHomeEmployee();
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
}
