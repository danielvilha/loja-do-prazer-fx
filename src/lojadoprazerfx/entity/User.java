/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lojadoprazerfx.enums.TypeName;

/**
 *
 * @author danielvilha
 */
@XStreamAlias("user")
public class User {
    
    @XStreamAlias("id")
    @XStreamAsAttribute
    private int id;
    
    @XStreamAlias("type")
    @XStreamAsAttribute
    private int type;
    
    @XStreamAlias("cpf")
    @XStreamAsAttribute
    private String cpf;
    
    @XStreamAlias("login")
    @XStreamAsAttribute
    private String login;
    
    @XStreamAlias("password")
    @XStreamAsAttribute
    private String password;
    
    @XStreamAlias("userName")
    @XStreamAsAttribute
    private String userName;
    
    @XStreamAlias("typeName")
    @XStreamAsAttribute
    private TypeName typeName;

    public User() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }
}
