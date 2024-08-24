/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Topping;
import com.pooespol.proyecto2_heladeria.ArmaTuHelado4Controller;
import java.util.ArrayList;
import java.util.Locale;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

/**
 *
 * @author zaval
 */
class ToppingItem extends ItemPedido {
    
    public ToppingItem() {
        super("Topping");
    }

    @Override
    public void eliminar(ObservableList<String> items, int selectedIndex, Label valorPagar, Label message) {
        ArrayList<Topping> lstTp = Topping.cargarSabores();
        String tp = items.get(selectedIndex).split(":")[1].trim();
        for (Topping t : lstTp) {
            if (tp.equals(t.getTipoTopping())) {
                ArmaTuHelado4Controller.ValorPagar -= t.getPrecio();
                String resta = String.format(Locale.US, "%.2f", ArmaTuHelado4Controller.ValorPagar);
                items.remove(selectedIndex);
                valorPagar.setText("Valor a pagar: " + resta);
                break;
            }
        }
    }
}
