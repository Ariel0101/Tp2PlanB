public class Fisura implements CartaDeCampo {

    private final DestruirElDeMenorAtaque efecto;
    Campo campoOponente;

    Fisura(Campo campoOponente){

        this.campoOponente = campoOponente;
        this.efecto = new DestruirElDeMenorAtaque(campoOponente);

    }

    @Override
    public void activar() {

        this.campoOponente.aplicarEnTodosLosMonstruos(this.efecto);

    }

}