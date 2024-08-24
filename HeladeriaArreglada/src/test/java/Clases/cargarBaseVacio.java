/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author zaval
 */
public class cargarBaseVacio {
    
    @TempDir
    Path tempDir;
    
    @Test
     void testCargarBaseArchivoVacio() throws IOException {
        // Setup
        File testFile = tempDir.resolve("bases.txt").toFile();
        testFile.createNewFile();

        // Act
        ArrayList<Base> bases = Base.cargarBase();

        // Assert
        assertTrue(bases.isEmpty(), "La lista debería estar vacía");
    }
    
}
