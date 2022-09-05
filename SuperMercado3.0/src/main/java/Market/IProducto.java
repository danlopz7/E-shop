package Market;

import Market.contenedores.Contenedor;
import Market.enums.Categoria;

public interface IProducto {

    String getReferencia();

    double getPrecio();

    float getPeso();

    boolean tengoEspacio(IContenedor contenedor);

    int getVolumen();

    Categoria getCategoria();

    boolean esCompatible(IProducto p);

    void meter(Contenedor contenedor);
}
