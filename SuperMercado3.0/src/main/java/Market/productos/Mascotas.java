package Market.productos;

import Market.IProducto;
import Market.enums.Categoria;

public class Mascotas extends Producto {

    public Mascotas(String referencia, int peso, int volumen, double precio) {
        super(referencia, peso, volumen, precio);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.MASCOTAS;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.DROGUERIA.equals(p.getCategoria());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Referencia='" + getReferencia() + "'[" + getCategoria() + "] peso=" + getPeso() + "g" + ", volumen=" + getVolumen() + "cm3" + ", precio= $" + getPrecio() + ", contenedor=" + Container());
        return sb.toString();
    }
}
