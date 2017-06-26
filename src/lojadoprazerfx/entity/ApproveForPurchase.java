/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadoprazerfx.entity;

import java.util.List;

/**
 *
 * @author danielvilha
 */
public class ApproveForPurchase {
    
    private int id;
    private List<ProductItem> productItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void setProductItemList(List<ProductItem> productItemList) {
        this.productItemList = productItemList;
    }
}
