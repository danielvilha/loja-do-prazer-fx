/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lojadoprazerfx.controller.ClientController;
import lojadoprazerfx.controller.CompanyController;
import lojadoprazerfx.controller.EmployeeController;
import lojadoprazerfx.controller.LoginController;
import lojadoprazerfx.controller.ModelCreateClientController;
import lojadoprazerfx.controller.ModelCreateFuncController;
import lojadoprazerfx.entity.Employee;

/**
 *
 * @author danielvilha
 */
public class Main extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Loja do Prazer");

        initRootLayout();
        showLoginView();
    }
    
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Login.fxml"));
            AnchorPane loginView = (AnchorPane) loader.load();
            rootLayout.setCenter(loginView);
            
            this.primaryStage.setTitle("Loja do Prazer");
            LoginController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showHomeEmployee() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeEmployee.fxml"));
            BorderPane page = (BorderPane) loader.load();
            rootLayout.setCenter(page);
            
            this.primaryStage.setTitle("Loja do Prazer - Empregado");
            EmployeeController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
        }
    }
    
    public void showHomeCompany() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeCompany.fxml"));
            BorderPane page = (BorderPane) loader.load();
            rootLayout.setCenter(page);
            
            this.primaryStage.setTitle("Loja do Prazer - Admin");
            CompanyController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
        }
    }
    
    public void showHomeClient() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeClient.fxml"));
            BorderPane page = (BorderPane) loader.load();
            rootLayout.setCenter(page);
            
            this.primaryStage.setTitle("Loja do Prazer - Cliente");
            ClientController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
        }
    }
    
    public boolean showEmployeeEditDialog(Employee employee) {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ModelCreateFunc.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Adicionar Empregado");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define a pessoa no controller.
            ModelCreateFuncController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEmployee(employee);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showUserEditDialog() {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ModelCreateClient.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Adicionar Cliente");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define a pessoa no controller.
            ModelCreateClientController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
