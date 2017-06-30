/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import lojadoprazerfx.util.MainUtil;

/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class ClientController extends MainUtil {
    
    @FXML
    private MenuItem menuItemComprar;
    @FXML
    private MenuItem menuItemViewCompras;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private AnchorPane container;
    
    @FXML
    private void initialize() {
    }

    public void handleComprar() {
        getMain().showLoginView();
    }
    
    public void handleViewCompras() {
        getMain().showLoginView();
    }
    
    public void handleExit() {
        getMain().showLoginView();
    }
}
