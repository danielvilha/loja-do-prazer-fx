/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.controller;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import lojadoprazerfx.entity.Employee;
import lojadoprazerfx.entity.ProductItem;
import lojadoprazerfx.entity.ProductsItens;
import lojadoprazerfx.entity.Purchase;
import lojadoprazerfx.entity.Purchases;
import lojadoprazerfx.entity.User;
import lojadoprazerfx.entity.Users;
import lojadoprazerfx.util.MainUtil;
import lojadoprazerfx.util.Util;

/**
 * FXML Controller class
 *
 * @author danielvilha
 */
public class CompanyController extends MainUtil {
    
    @FXML
    private MenuItem menuItemListProd;
    @FXML
    private MenuItem menuItemListCli;
    @FXML
    private MenuItem menuItemListFunc;
    @FXML
    private MenuItem menuItemListVendas;
    @FXML
    private MenuItem menuItemAprCompras;
    @FXML
    private MenuItem menuItemCadFunc;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private ListView listView;

    protected List<String> stringList = new ArrayList<>(20);
    private ObservableList observableList = FXCollections.observableArrayList();
    protected ListProperty<String> listProperty = new SimpleListProperty<>();

    public void setListView(List<String> list) {
        
        listView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(list));
    }
    
    @FXML
    private void initialize() {
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'CustomList.fxml'.";
    }

    @FXML
    public void handleListProd() {
        ProductsItens productItemData = Util.getProductsItens();
        stringList = new ArrayList<>(20);
        
        for (ProductItem item : productItemData.getProductsItens()) {
            stringList.add(String.format("%s - %s R$%s", item.getItemName(), item.getItemDescription(), String.valueOf(item.getValue())));
        }
        
        setListView(stringList);
    }
    
    @FXML
    public void handleListCli() {
        Users itens = Util.getUsers();
        stringList = new ArrayList<>(20);
        
        for (User item : itens.getUsers()) {
            if (item.getType() == 2) {
                stringList.add(item.getUserName());
            }
        }
        
        setListView(stringList);
    }
    
    @FXML
    public void handleListFunc() {
        Users userList = Util.getUsers();
        ArrayList<Employee> employeeList = new ArrayList<>();

        for (User user : userList.getUsers()) {
            if (user.getType() == 1 || user.getType() == 3) {
                employeeList.add(new EmployeeController().getEmployeeById(user.getId()));
            }
        }
        //Employees itensList = Util.getEmployees();
        stringList = new ArrayList<>(20);
        
        for (Employee item : employeeList) {
            stringList.add(String.format("%s - %s", String.valueOf(item.getMatricula()), item.getUser().getUserName()));
        }
        
        setListView(stringList);
    }
    
    @FXML
    public void handleListVendas() {
        Purchases itensList = Util.getPurchases();
        stringList = new ArrayList<>(20);
        
        for (Purchase item : itensList.getPurchases()) {
            stringList.add(String.format("%s - %s", item.getPurchaseDate(), item.getValue()));
        }
        
        setListView(stringList);
    }
    
    @FXML
    public void handleAprCompras() {
        getMain().showLoginView();
    }
    
    @FXML
    public void handleCadFunc() {
        Employee employee = new Employee();
        getMain().showEmployeeEditDialog(employee);
    }
    
    @FXML
    public void handleExit() {
        getMain().showLoginView();
    }
}
