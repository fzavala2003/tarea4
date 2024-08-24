/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronDecorator;

/**
 *
 * @author zaval
 */
public class PedidoConDescuentoDecorator extends PedidoDecorator {
    private double descuento;

    public PedidoConDescuentoDecorator(PedidoInterface pedidoDecorado, double descuento) {
        super(pedidoDecorado);
        this.descuento = descuento;
    }

    @Override
    public void guardarPedido() {
        super.guardarPedido();
        System.out.println("Aplicando descuento de " + descuento + "% al pedido");
        // Lógica para aplicar descuento
    }
}
