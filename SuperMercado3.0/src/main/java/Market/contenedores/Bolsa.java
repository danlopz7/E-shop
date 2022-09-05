package Market.contenedores;

import Market.enums.TipoContenedor;

public class Bolsa extends Contenedor{

    private final int ancho;

    public Bolsa(String referencia, int alto, float resistencia, int ancho) {
        super(referencia, alto, resistencia);
        this.ancho = ancho;
    }

    @Override
    public float getSuperficie() {
        float radio = getDiametro()/2;
        return (float) (Math.PI * radio * radio);
    }

    public float getDiametro(){
        return (float)((Math.sqrt(Math.pow(ancho, 2)+Math.pow(ancho, 2))));
    }

    @Override
    public TipoContenedor getTipo() {
        return TipoContenedor.BOLSA;
    }
}
