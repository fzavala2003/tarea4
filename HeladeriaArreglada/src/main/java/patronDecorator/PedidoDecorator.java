/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronDecorator;

/**
 *
 * @author zaval
 */
public abstract class PedidoDecorator implements PedidoInterface {
    protected PedidoInterface pedidoDecorado;

    public PedidoDecorator(PedidoInterface pedidoDecorado) {
        this.pedidoDecorado = pedidoDecorado;
    }

    @Override
    public void guardarPedido() {
        pedidoDecorado.guardarPedido();
    }

    @Override
    public void serealizarPedido() {
        pedidoDecorado.serealizarPedido();
    }

    @Override
    public void generarTransacción(Pago p) {
        pedidoDecorado.generarTransacción(p);
    }
}