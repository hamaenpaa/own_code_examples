/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author harri
 */
@Stateful(name="ShoppingCart")
public class ShoppingCartBean implements ShoppingCartLocal, ShoppingCart {

    public ArrayList cartItems;
    
    @PostConstruct
    public void initialize() {
        cartItems = new ArrayList();
    }   
    
    @PreDestroy
    public void exit() {
        // items list into the database.
        System.out.println("Saved items list into database");
    }    
    
    @Remove
    public void stopSession() {
        // The method body can be empty.
        System.out.println("From stopSession method with @Remove annotation");
    }    
    
    public void addWineItem(String wine) {
       cartItems.add(wine);
    }

    public void removeWineItem(String wine) {
       cartItems.remove(wine);
    }

    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList getCartItems() {
        return cartItems;
    }
}
