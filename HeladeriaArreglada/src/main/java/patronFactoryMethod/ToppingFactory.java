package patronFactoryMethod;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



class ToppingFactory {
    public static Topping createTopping(String tipoTopping, double precio) {
        // Aquí podrías agregar lógica adicional de creación si fuera necesario
        return new Topping(tipoTopping, precio);
    }

    public static ArrayList<Topping> cargarSabores(String filename) {
        ArrayList<Topping> toppings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] lista = linea.split(",");
                String tipoTopping = lista[0];
                double precio = Double.parseDouble(lista[1]);
                Topping topping = createTopping(tipoTopping, precio);
                toppings.add(topping);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        } catch (IOException io) {
            System.out.println(io);
        }
        return toppings;
    }
}