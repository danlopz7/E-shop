package Market.productos;

public class NoPerecedero extends Alimentacion{

    public NoPerecedero(String referencia, int peso, int volumen, double precio) {
        super(referencia, peso, volumen, precio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Referencia='" + getReferencia() + "'[" + getCategoria() +
                "][NO PERECEDERO] peso=" + getPeso() + "g" + ", volumen=" + getVolumen() + "cm3" + ", precio= $" + getPrecio() + ", contenedor=" + Container());
        return sb.toString();
    }
}
