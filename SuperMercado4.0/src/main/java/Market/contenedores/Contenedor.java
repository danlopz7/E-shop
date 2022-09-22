package Market.contenedores;

import Market.IContenedor;
import Market.IProducto;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Contenedor implements IContenedor {

    private static final Logger logger = LogManager.getLogger(Contenedor.class);
    private String referencia;
    private final int alto;
    private final float resistencia;
    private final Set<IProducto> productos;

    public Contenedor(String referencia, int alto, float resistencia) {
        this.referencia = referencia;
        this.alto = alto;
        this.resistencia = resistencia;
        productos = new HashSet<>();
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public float getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public float getResistencia() {
        return resistencia;
    }

    @Override
    public float volumenDisponible() {
        return getVolumen() - volumenOcupado();
    }

    private float volumenOcupado() {
        int res = 0;
        for (IProducto p : productos) {
            res += p.getVolumen();
        }
        return res;
    }

    @Override
    public Set<IProducto> getProductos() {
        return productos;
    }

    @Override
    public boolean meter(IProducto producto) {
        logger.info("Se introdujo un producto al contenedor");
        boolean resistenciaOk = resiste(producto);
        boolean volumenOk = volumenDisponible() > producto.getVolumen();
        boolean compatibilidadOk = true;

        for (IProducto p : productos) {
            boolean compatibleOk = producto.esCompatible(p);
            compatibilidadOk &= compatibleOk;
        }

        boolean acepta = resistenciaOk && volumenOk && compatibilidadOk;
        if (acepta) {
            productos.add(producto);
            producto.meter(this);
        }
        return acepta;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return resistencia > producto.getPeso();
    }

    @Override
    public String imprimirContenedor() {
        StringBuilder sb = new StringBuilder("Contenedor " + referencia + " [" + getTipo() +
                "] (superficie: " + getSuperficie() + "cm2 - vol " + getVolumen() + "cm3 - resistencia " + getResistencia() + "g)");

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenedor " + referencia + " [" + getTipo() +
                "] (superficie: " + getSuperficie() + "cm2 - vol " + getVolumen() + "cm3 - resistencia " + getResistencia() + "g)");
        if (getProductos().isEmpty()) {
            sb.append("\n\t\tvacio");
        }
        for (IProducto p : productos) {
            sb.append("\n\t\t" + p);
        }
        sb.append("\n\t\t>> Disponible: (vol/peso) -- " + volumenDisponible() + "cm3 / " + resistencia + "g");
        return sb.toString();
    }
}
