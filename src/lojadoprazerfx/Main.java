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
import javafx.stage.StageStyle;
import lojadoprazerfx.controller.EmployeeController;
import lojadoprazerfx.controller.LoginController;

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
            
            EmployeeController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
        }
    }
    
    public void showHomeCompany() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeEmployee.fxml"));
            BorderPane page = (BorderPane) loader.load();
            rootLayout.setCenter(page);
            
            EmployeeController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
        }
    }
    
    public void showHomeClient() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/HomeEmployee.fxml"));
            BorderPane page = (BorderPane) loader.load();
            rootLayout.setCenter(page);
            
            EmployeeController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            
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
