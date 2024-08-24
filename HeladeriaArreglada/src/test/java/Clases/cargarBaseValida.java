/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class cargarBaseValida {

    @TempDir
    Path tempDir;

    @Test
    void testCargarBaseArchivoValido() throws IOException {
        // Setup
        File testFile = tempDir.resolve("bases.txt").toFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("yogurt,1.50\n");
            writer.write("helado,2.00\n");
            writer.write("vegano,2.50\n");
        }

        // Act
        ArrayList<Base> bases = Base.cargarBase();

        // Assert
        assertEquals(3, bases.size(), "La lista debería contener 3 elementos");
        
    }
    

}