package Entidades;
import java.io.Serializable;
/**
 *
 * @author Gabriela
 */
public class Estudiante implements Serializable{
    private String matricula;
    private String nombre;
    private String email;

    //Constructor
    public Estudiante(String matricula, String nombre, String email) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.email = email;
    }

    //Setters y getters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    //To String
    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + ", email=" + email + '}';
    }

}