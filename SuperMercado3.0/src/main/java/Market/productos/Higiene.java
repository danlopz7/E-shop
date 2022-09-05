package Market.productos;

import Market.IProducto;
import Market.enums.Categoria;

public class Higiene extends Producto{

    public Higiene(String referencia, int peso, int volumen, double precio) {
        super(referencia, peso, volumen, precio);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.HIGIENE;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.ALIMENTACION.equals(p.getCategoria());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Referencia='" + getReferencia() + "'[" + getCategoria() + "] peso=" + getPeso() + "g" + ", volumen=" + getVolumen() + "cm3" + ", precio= $" + getPrecio() + ", contenedor=" + Container());
        return sb.toString();
    }
}
