/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Local {
    private double coordenadaX;
    private double coordenadaY;
    private String nombre;
    private String horario;

    public Local(double coordenadaX, double coordenadaY, String nombre, String horario) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.nombre = nombre;
        this.horario = horario;
    }

    public static ArrayList<Local> cargarLocales() {
        ArrayList<Local> locales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("locales.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lista = parseLine(linea);
                Local local = createLocalFromData(lista);
                locales.add(local);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io);
        }

        return locales;
    }

    // Método extraído para analizar la línea del archivo
    private static String[] parseLine(String linea) {
        return linea.split(",");
    }

    // Método extraído para crear el objeto Local a partir de los datos
    private static Local createLocalFromData(String[] lista) {
        double coordenadaX = Double.parseDouble(lista[0]);
        double coordenadaY = Double.parseDouble(lista[1]);
        String nombre = lista[2];
        String horario = lista[3];

        return new Local(coordenadaX, coordenadaY, nombre, horario);
    }

    public double getCoordenadaX() {
        return this.coordenadaX;
    }

    public double getCoordenadaY() {
        return this.coordenadaY;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString() {
        return "Local" + "{coordenadaX=" + this.coordenadaX + ", coordenadaY=" + this.coordenadaY + ", nombre=" + this.nombre + ", horario=" + this.horario + "}";
    }

    public static void main(String[] args) {
        System.out.println(cargarLocales());
    }
}