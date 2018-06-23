public class Combate {

    private final Jugador jugadorAtacante;
    private final Campo campoAtacante;

    private final Jugador jugadorAtacado;
    private final Campo campoAtacado;

    public Combate(Jugador jugadorAtacante, Campo campoAtacante, Jugador jugadorAtacado, Campo campoAtacado) {
        this.jugadorAtacante = jugadorAtacante;
        this.campoAtacante = campoAtacante;
        this.jugadorAtacado = jugadorAtacado;
        this.campoAtacado = campoAtacado;
    }

    public void combatir(CartaMonstruo atacante, CartaMonstruo atacado) {
        if(!(this.campoAtacante.esta(atacante))){
            throw new MonstruoAtacanteNoPertenceACampoAtacanteError();
        }
        if(!(this.campoAtacado.esta(atacado))){ //La otra es hacer metodo siEstaLevantaEsteError...
            throw new MonstruoAtacanteNoPertenceACampoAtacadoError();
        }
        Botin botin = atacante.atacar(atacado, this.campoAtacado);
        botin.infligirDanios(this.jugadorAtacante,this.jugadorAtacado);
        botin.ejecutar(this.campoAtacante);
        botin.ejecutar(this.campoAtacado);
    }
}
