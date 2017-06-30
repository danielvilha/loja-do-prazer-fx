/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.util;

import lojadoprazerfx.Main;
import lojadoprazerfx.entity.User;

/**
 *
 * @author danielvilha
 */
public class MainUtil {
    
    Main main;
    User user;
    
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }
    
    public Main getMain() {
        return this.main;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
