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

public class cargaLocalesValido {

    @TempDir
    Path tempDir;

    @Test
    void testCargarLocalesArchivoValido() throws IOException {
        // Setup
        File testFile = tempDir.resolve("locales.txt").toFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("83.66666666666667,172.66666666666666,San Felipe,10:00 - 17:00\n");
            writer.write("88.66666666666667,250.66666666666666,Martha de Roldos,10:00 - 16:00\n");
            writer.write("184.66666666666666,391.3333333333333,Urdesa,10:00 - 17:00\n");
        }

        // Act
        ArrayList<Local> locales = Local.cargarLocales();

        // Assert
        assertEquals(3, locales.size(), "La lista debería contener 2 elementos");
    }
    
}