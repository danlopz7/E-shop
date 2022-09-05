package Market.productos;

import Market.IContenedor;
import Market.IProducto;
import Market.contenedores.Contenedor;

public abstract class Producto implements IProducto {

    private final String referencia;
    private final float peso;
    private final int volumen;
    private IContenedor contenedor;
    private final double precio;

    public Producto(String referencia, float peso, int volumen, double precio){
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
        this.precio = precio;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public float getPeso() {
        return peso;
    }

    @Override
    public boolean tengoEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > volumen;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void meter(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    public String Container() {
        if (contenedor != null){
            return contenedor.getTipo().toString();
        } else
            return null;
    }

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Referencia='" + referencia + "' [" + getCategoria() +
                "]" + " peso=" + getPeso() + "g" + ", volumen=" + volumen + "cm3"+ ", precio= $" + precio + ", contenedor=" + Container());
        return sb.toString();
    }
}
