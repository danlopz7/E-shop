package Market.contenedores;

import Market.enums.TipoContenedor;

public class Caja extends Contenedor{

    private final int largo;
    private final int ancho;

    public Caja(String referencia, int alto, int ancho, int largo){
        super(referencia, alto, 50000);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public float getSuperficie() {
        return ancho * largo;
    }

    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.CAJA;
    }

    /*@Override
    public boolean resiste(IProducto producto) {
        return true;
    }*/
}
