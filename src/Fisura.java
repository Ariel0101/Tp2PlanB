
public class Fisura implements Magica {

    private final EfectoDestruirElDeMenorAtaque efecto;

    Campo campoOponente;

    Fisura(Campo campoOponente){

        this.campoOponente = campoOponente;
        this.efecto = new EfectoDestruirElDeMenorAtaque(campoOponente);

    }

    @Override
    public void activar() {

        this.campoOponente.aplicarEnMonstruos(this.efecto);

    }


}