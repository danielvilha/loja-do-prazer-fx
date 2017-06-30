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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lojadoprazerfx.entity.Employee;
import lojadoprazerfx.entity.Employees;
import lojadoprazerfx.entity.User;
import lojadoprazerfx.enums.EmployeeType;
import lojadoprazerfx.enums.TypeName;
import lojadoprazerfx.util.MainUtil;
import lojadoprazerfx.util.Util;

/**
 * FXML Controller class
 *
 * @author scopus-dev
 */
public class ModelCreateFuncController extends MainUtil {

    @FXML
    public TextField textFieldNome;
    @FXML
    private TextField textFieldCpf;
    @FXML
    private TextField textFieldLogin;
    @FXML
    private TextField textFieldSenha;
    @FXML
    private TextField textFieldSalario;
    @FXML
    private TextField textFieldMatricula;
    @FXML
    private RadioButton rbFuncionario;
    @FXML
    private RadioButton rbGerente;
    @FXML
    private RadioButton rbDiretor;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    
    private Stage dialogStage;
    private Employee employee;
    private boolean okClicked = false;
    
    @FXML
    private void initialize() {
        Employees list = Util.getEmployees();
        
        textFieldMatricula.setText(String.valueOf(100001 + list.getEmployees().size()));
    }
    
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            Employee emp = new Employee();
            emp.setUser(new User());
            emp.getUser().setUserName(textFieldNome.getText());
            emp.getUser().setCpf(textFieldCpf.getText());
            emp.getUser().setLogin(textFieldLogin.getText());
            emp.getUser().setPassword(textFieldSenha.getText());
            emp.setSalario(Double.parseDouble(textFieldSalario.getText().toString()));
            emp.setMatricula(Integer.valueOf(textFieldMatricula.getText()));
            emp.getUser().setType(1);
            emp.getUser().setTypeName(TypeName.employee);
            
            if (rbFuncionario.isSelected()) {
                emp.setEmployeeType(EmployeeType.funcionario);
            }
            if (rbGerente.isSelected()) {
                emp.setEmployeeType(EmployeeType.gerente);
            }
            if (rbDiretor.isSelected()) {
                emp.setEmployeeType(EmployeeType.diretor);
            }

            createUser(emp);
            
            Alert alert = new Alert(AlertType.INFORMATION);
                      alert.setTitle("Inserir Funcionário");
                      alert.setHeaderText("Sucesso");
                      alert.setContentText("Funcionário inserido com sucesso");
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        
        if (textFieldSalario.getText() == null || textFieldSalario.getText().length() == 0) {
            errorMessage += "Salário inválido!\n";
        }
        
        if (!rbFuncionario.isSelected() && !rbGerente.isSelected() && !rbDiretor.isSelected()) {
            errorMessage += "Tipo de funcionário não selecionado!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostra a mensagem de erro.
            Alert alert = new Alert(AlertType.ERROR);
                      alert.setTitle("Campos Inválidos");
                      alert.setHeaderText("Por favor, corrija os campos inválidos");
                      alert.setContentText(errorMessage);
                alert.showAndWait();

            return false;
        }
    }
    
    public int createUser(Employee employee) {
        try {
            Employees employeeList = Util.getEmployees();
            employee.setId(new UserController().createUser(employee.getUser()));
            
            employeeList.getEmployees().add(employee);
            
            File xmlFile = new File("./src/lojadoprazerfx/xml/employee.xml");
            XStream xStream = new XStream();
            OutputStream outputStream = new FileOutputStream(xmlFile);
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            xStream.toXML(employeeList.getEmployees(), writer);
            
            return employee.getId();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
