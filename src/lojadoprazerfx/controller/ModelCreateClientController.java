/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lojadoprazerfx.entity.User;
import lojadoprazerfx.entity.Users;
import lojadoprazerfx.enums.TypeName;
import lojadoprazerfx.util.MainUtil;
import lojadoprazerfx.util.Util;

/**
 * FXML Controller class
 *
 * @author scopus-dev
 */
public class ModelCreateClientController extends MainUtil {

    @FXML
    public TextField textFieldNome;
    @FXML
    private TextField textFieldCpf;
    @FXML
    private TextField textFieldLogin;
    @FXML
    private TextField textFieldSenha;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    
    private Stage dialogStage;
    private boolean okClicked = false;
    
    @FXML
    private void initialize() {
    }
    
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            User usr = new User();
            usr.setUserName(textFieldNome.getText());
            usr.setCpf(textFieldCpf.getText());
            usr.setLogin(textFieldLogin.getText());
            usr.setPassword(textFieldSenha.getText());
            usr.setType(2);
            usr.setTypeName(TypeName.client);
            
            createUser(usr);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Inserir Cliente");
                      alert.setHeaderText("Sucesso");
                      alert.setContentText("Cliente inserido com sucesso");
                alert.showAndWait();
            
            okClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void setOkClicked(boolean okClicked) {
        this.okClicked = okClicked;
    }
    
    /**
     * Valida a entrada do usuário nos campos de texto.
     * 
     * @return true se a entrada é válida
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (textFieldNome.getText() == null || textFieldNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldCpf.getText() == null || textFieldCpf.getText().length() == 0) {
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldLogin.getText() == null || textFieldLogin.getText().length() == 0) {
            errorMessage += "Login inválida!\n";
        }

        if (textFieldSenha.getText() == null || textFieldSenha.getText().length() == 0) {
            errorMessage += "Senha inválida!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostra a mensagem de erro.
            Alert alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Campos Inválidos");
                      alert.setHeaderText("Por favor, corrija os campos inválidos");
                      alert.setContentText(errorMessage);
                alert.showAndWait();

            return false;
        }
    }
    
    public int createUser(User user) {
        try {
            Users userList = Util.getUsers();
            user.setId(userList.getUsers().size() + 1);
            
            userList.getUsers().add(user);
            
            File xmlFile = new File("./src/lojadoprazerfx/xml/user.xml");
            XStream xStream = new XStream();
            OutputStream outputStream = new FileOutputStream(xmlFile);
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            xStream.toXML(userList.getUsers(), writer);
            
            return user.getId();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
