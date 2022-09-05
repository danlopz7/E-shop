package Market;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pedido implements IPedido {

    private final String referencia;
    //private final Set<IContenedor> contenedores;
    private final ArrayList<IContenedor> contenedores;

    public Pedido(String referencia) {
        this.referencia = referencia;
        //this.contenedores = new HashSet<IContenedor>();
        this.contenedores = new ArrayList<>();
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public void addContenedor(IContenedor contenedor) {
        contenedores.add(contenedor);
    }

    @Override
    public Set<IProducto> getProductos() {
        Set<IProducto> productos = null;
        for (IContenedor c : contenedores) {
            if (productos == null) {
                productos = c.getProductos();
            } else {
                productos.addAll(c.getProductos());
            }
        }
        return productos;
    }

    @Override
    public List<IContenedor> getContenedores() {
        return contenedores;
    }

    @Override
    public IContenedor addProducto(IProducto producto) {
        for (IContenedor contenedor : contenedores) {
                if (contenedor.meter(producto)) {
                    return contenedor;
                }
            }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido: " + referencia + "\n");
        for (IContenedor contenedor : contenedores) {
            sb.append("\t" + contenedor.toString() + "\n");
        }
        return sb.toString();
    }
}
