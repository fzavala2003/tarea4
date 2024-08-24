import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.EstadoCivil;
import modelo.Persona;
import applyStyles.AdminPersonas;

import repository.PersonaRepository;


/**
 * @author Gabriela
 */
public class ListadoPersonas {
    private PersonasUI ui;
    private PersonaRepository repository;
    private ArrayList<Persona> personas;

    public ListadoPersonas() {
        repository = new PersonaRepository();
        personas = repository.cargarPersonas();
        BorderPane root = new BorderPane();
        TableView<Persona> tableView = new TableView<>();
        ui = new PersonasUI(root, tableView);
        ui.createContent(personas);

        setupEventHandlers();
    }

    public Pane getRoot() {
        return ui.getRoot();
    }

    private void setupEventHandlers() {
        // Configurar eventos para agregar, editar y eliminar personas
    }

    private void actualizarTableView() {
        personas.sort(Comparator.comparing(Persona::getApellidos));
        tableView.getItems().setAll(personas);
    }

    private void validateAndSave(Persona persona, String nombres, String apellidos, EstadoCivil estado) {
        if (nombres.trim().length() > 0 && apellidos.trim().length() > 0) {
            persona.setNombres(nombres);
            persona.setApellidos(apellidos);
            persona.setEstadocivil(estado);
            actualizarArchivoPersonas();
            actualizarTableView();
        } else {
            ui.showValidationAlert("Todos los campos son obligatorios");
        }
    }

    private void actualizarArchivoPersonas() {
        repository.actualizarArchivoPersonas(personas);
    }

    private void eliminarPersona(Persona persona) {
        personas.remove(persona);
        actualizarArchivoPersonas();
        actualizarTableView();
    }
}
