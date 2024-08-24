/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyecto2_heladeria;

import Clases.Sabor;
import com.pooespol.proyecto2_heladeria.ArmaTuHelado4Controller;
import java.util.ArrayList;
import java.util.Locale;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

/**
 *
 * @author zaval
 */
class SaborItem extends ItemPedido {
    
    public SaborItem() {
        super("Sabor");
    }

    @Override
    public void eliminar(ObservableList<String> items, int selectedIndex, Label valorPagar, Label message) {
        String sabor = items.get(selectedIndex).split(":")[1].trim();
        ArrayList<Sabor> lstSb = Sabor.cargarSabores();
        for (Sabor s : lstSb) {
            if (sabor.equals(s.getTipoSabor())) {
                ArmaTuHelado4Controller.ValorPagar -= Double.parseDouble(s.getPrecio());
                String resta = String.format(Locale.US, "%.2f", ArmaTuHelado4Controller.ValorPagar);
                items.remove(selectedIndex);
                valorPagar.setText("Valor a pagar: " + resta);
                break;
            }
        }
    }
}