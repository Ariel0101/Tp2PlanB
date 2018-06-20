public class Fisura implements CartaCampo {

    private final DestruirElDeMenorAtaque efecto;
    Campo campoOponente;

    Fisura(Campo campoOponente){

        this.campoOponente = campoOponente;
        this.efecto = new DestruirElDeMenorAtaque();

    }


    @Override
    public void activar() {



    }
}
