/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronDecorator;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author zaval
 */
public class Pedido implements PedidoInterface, Serializable {
    private String idPedido;
    private String nombreCliente;
    private double precio;

    // Constructores, getters, setters y otros métodos aquí

    @Override
    public void guardarPedido() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt", true))) {
            bw.write(idPedido + "," + nombreCliente + "," + precio + "\n");
            System.out.println("Pedido guardado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void serealizarPedido() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("pedido" + idPedido + ".bin"))) {
            output.writeObject(this);
            System.out.println("Pedido serealizado con exito");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void generarTransacción(Pago p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pagos.txt", true))) {
            bw.write(p.getIdPago() + "," + p.getIdpedido() + "," + p.getNombreCLiente() + "," + p.getTotalPagar() + "," + p.getFecha() + "," + p.getTipo() + "\n");
            System.out.println("Transacción guardada con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
