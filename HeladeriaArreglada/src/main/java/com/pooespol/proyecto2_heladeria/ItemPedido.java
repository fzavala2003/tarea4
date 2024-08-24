/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;

/**
 *
 * @author zaval
 */
public abstract class ItemPedido {
    protected String tipo;
    
    public ItemPedido(String tipo) {
        this.tipo = tipo;
    }
    
    public abstract void eliminar(ObservableList<String> items, int selectedIndex, Label valorPagar, Label message);
}

