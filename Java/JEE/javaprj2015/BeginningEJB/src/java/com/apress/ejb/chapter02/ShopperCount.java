/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import javax.ejb.Remote;

/**
 *
 * @author harri
 */
@Remote
public interface ShopperCount {
    public void incrementShopperCount();
    public int getShopperCount();
    public void resetCounter();
}

