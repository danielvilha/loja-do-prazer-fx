/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import lojadoprazerfx.entity.ApproveForPurchase;
import lojadoprazerfx.entity.ApproveForPurchases;
import lojadoprazerfx.entity.Employee;
import lojadoprazerfx.entity.Employees;
import lojadoprazerfx.entity.ProductItem;
import lojadoprazerfx.entity.ProductsItens;
import lojadoprazerfx.entity.Purchase;
import lojadoprazerfx.entity.Purchases;
import lojadoprazerfx.entity.User;
import lojadoprazerfx.entity.Users;

/**
 *
 * @author danielvilha
 */
public class Util {
    public final static Users getUsers() {
        // /Users/danielvilha/Developer/workspace/Loja/LojaDoPrazerFX/src/lojadoprazerfx/xml/user.xml
        File xmlFile = new File("./src/lojadoprazerfx/xml/user.xml");
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("users", Users.class);      
        xstream.addImplicitCollection(Users.class, "users");
        xstream.alias("user", User.class);

        Users list = xstream.fromXML(xmlFile) != null ? (Users) xstream.fromXML(xmlFile) : new Users();
        
        return list;
    }
    
    public final static ProductsItens getProductsItens() {
        File xmlFile = new File("./src/lojadoprazerfx/xml/product.xml");
        XStream xstream = new XStream();
        xstream.alias("productsItens", ProductsItens.class);      
        xstream.addImplicitCollection(ProductsItens.class, "productsItens");
        xstream.alias("productItem", ProductItem.class);
        
        ProductsItens list = xstream.fromXML(xmlFile) != null ? (ProductsItens) xstream.fromXML(xmlFile) : new ProductsItens();
        
        return list;
    }
    
    public final static Employees getEmployees() {
        File xmlFile = new File("./src/lojadoprazerfx/xml/employee.xml");
        XStream xstream = new XStream();
        xstream.alias("employees", Employees.class);      
        xstream.addImplicitCollection(Employees.class, "employees");
        xstream.alias("employee", Employee.class);
        
        Employees list = xstream.fromXML(xmlFile) != null ? (Employees) xstream.fromXML(xmlFile) : new Employees();
        
        return list;
    }
    
    public final static Purchases getPurchases() {
        File xmlFile = new File("./src/lojadoprazerfx/xml/purchase.xml");
        XStream xstream = new XStream();
        xstream.alias("purchases", Purchases.class);      
        xstream.addImplicitCollection(Purchases.class, "purchases");
        xstream.alias("purchase", Purchase.class);
        
        Purchases list = xstream.fromXML(xmlFile) != null ? (Purchases) xstream.fromXML(xmlFile) : new Purchases();
        
        return list;
    }
    
    public final static ApproveForPurchases getApproveForPurchases() {
        File xmlFile = new File("./src/lojadoprazerfx/xml/approveForPurchases.xml");
        XStream xstream = new XStream();
        xstream.alias("approveForPurchases", ApproveForPurchases.class);      
        xstream.addImplicitCollection(ApproveForPurchases.class, "approveForPurchases");
        xstream.alias("approveForPurchase", ApproveForPurchase.class);
        
        ApproveForPurchases list = xstream.fromXML(xmlFile) != null ? (ApproveForPurchases) xstream.fromXML(xmlFile) : new ApproveForPurchases(); 
        
        return list;
    }
    
    public final static void Alert(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert alert = new Alert(type);
                      alert.setTitle(title);
                      alert.setHeaderText(headerText);
                      alert.setContentText(contentText);
                alert.showAndWait();
    }
    
    public static User getUserById(int id) {
        try {
            User user = new User();
            Users userList = Util.getUsers();
            
            for (User u : userList.getUsers()) {
                if (u.getId() == id) {
                    user = u;
                }
            }
            
            return user;
        } catch (Exception ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
