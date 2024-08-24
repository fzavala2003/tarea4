/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zaval
 */
public class cargarBaseNoEncontrado {
    @Test
    void testCargarBaseArchivoNoEncontrado() {
        // Simula que el archivo no existe
        System.setProperty("bases.file.path", "noexiste.txt");

        // Act
        ArrayList<Base> bases = Base.cargarBase();

        // Assert
        assertTrue(bases.isEmpty(), "La lista debería estar vacía en caso de error al leer el archivo");
    }
}
