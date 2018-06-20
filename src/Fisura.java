
public class Fisura implements Magica {

    private final DestruirElDeMenorAtaque efecto;

    Campo campoOponente;

    Fisura(Campo campoOponente){

        this.campoOponente = campoOponente;
        this.efecto = new DestruirElDeMenorAtaque(campoOponente);

    }

    @Override
    public void activar() {

        this.campoOponente.aplicarEnMonstruos(this.efecto);

    }


}