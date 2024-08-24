import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanas.ListadoPersonas;

/**
 *
 * @author Gabriela
 */
public class AdminPersonas extends Application {

    private void applyStyles(Scene scene) {
        File f = new File("src/css/estilos.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///"+f.getAbsolutePath().replace("\\", "/"));
    }

    @Override
    public void start(Stage primaryStage) {
        ListadoPersonas ventanaLista= new ListadoPersonas();
        Scene scene= new Scene(ventanaLista.getRoot(),850,460);
        applyStyles(scene);
        primaryStage.setTitle("Listado Personas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
