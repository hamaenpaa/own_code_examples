/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;

import model.ProductsFacadeLocal;
import entities.*;
import java.util.*;

/**
 *
 * @author harri
 */
@ManagedBean
@SessionScoped
public class ProductController {
    
    @EJB
    private ProductsFacadeLocal productsFacade;
    
    /**
     * Creates a new instance of ProductController
     */
    public ProductController() {
    }
 
    public List<Products> findAll() {
        return this.productsFacade.findAll();
    }
}
