/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class cargarLocalesNoEncontrado {

    @Test
    void testCargarLocalesArchivoNoEncontrado() {
        // Simula que el archivo no existe
        System.setProperty("locales.file.path", "noexiste.txt");

        // Act
        ArrayList<Local> locales = Local.cargarLocales();

        // Assert
        assertTrue(locales.isEmpty(), "La lista debería estar vacía en caso de error al leer el archivo");
    }

}
