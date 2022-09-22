package Market;

import java.util.List;
import java.util.Set;

public interface IPedido {

    String getReferencia();

    void addContenedor(IContenedor contenedor);

    IContenedor addProducto(IProducto producto);

    Set<IProducto> getProductos();

    List<IContenedor> getContenedores();
}
