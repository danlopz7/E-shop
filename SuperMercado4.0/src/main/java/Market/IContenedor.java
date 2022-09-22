package Market;

import Market.enums.TipoContenedor;

import java.util.Set;

public interface IContenedor {

    String getReferencia();

    TipoContenedor getTipo();

    float getSuperficie();

    float getVolumen();

    float getResistencia();

    float volumenDisponible();

    Set<IProducto> getProductos();

    boolean meter(IProducto producto);

    boolean resiste(IProducto producto);

    String imprimirContenedor();
}
