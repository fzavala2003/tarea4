public class Cedula {
    private String valor;

    public Cedula(String valor) {
        if (!esValida(valor)) {
            throw new IllegalArgumentException("Cédula inválida");
        }
        this.valor = valor;
    }

    private boolean esValida(String valor) {
        // Implementar la validación específica de la cédula
        return valor != null && valor.matches("\\d{10}");
    }

    public String getValor() {
        return valor;
    }
}
