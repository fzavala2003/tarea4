package patronFactoryMethod;

import java.io.*;
import java.util.ArrayList;

class Topping {
    private String tipoTopping;
    private double precio;

    public Topping(String tipoTopping, double precio) {
        this.tipoTopping = tipoTopping;
        this.precio = precio;
    }

    public String getTipoTopping() {
        return tipoTopping;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTipoTopping(String tipoTopping) {
        this.tipoTopping = tipoTopping;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Topping{tipoTopping=" + tipoTopping + ", precio=" + precio + "}";
    }
}