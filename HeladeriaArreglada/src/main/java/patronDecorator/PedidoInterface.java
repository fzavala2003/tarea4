/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package patronDecorator;

/**
 *
 * @author zaval
 */
public interface PedidoInterface {
    void guardarPedido();
    void serealizarPedido();
    void generarTransacción(Pago p);
}