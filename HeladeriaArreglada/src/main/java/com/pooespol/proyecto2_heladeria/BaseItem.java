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
class BaseItem extends ItemPedido {
    
    public BaseItem() {
        super("Base");
    }

    @Override
    public void eliminar(ObservableList<String> items, int selectedIndex, Label valorPagar, Label message) {
        message.setText("No puede eliminar una base");
    }
}

