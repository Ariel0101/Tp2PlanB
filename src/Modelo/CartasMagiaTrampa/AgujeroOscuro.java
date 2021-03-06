package Modelo.CartasMagiaTrampa;

import Modelo.Campo.Campo;

public class AgujeroOscuro implements Magia {

    private final Campo campoAmigo;
    private final Campo campoEnemigo;

    public AgujeroOscuro(Campo campoAmigo, Campo campoEnemigo) {

        this.campoAmigo = campoAmigo;
        this.campoEnemigo = campoEnemigo;

    }


    public void activar() {
        this.campoAmigo.aplicarEnMonstruos(new EfectoDestruirMonstruo(this.campoAmigo));
        this.campoEnemigo.aplicarEnMonstruos(new EfectoDestruirMonstruo(this.campoEnemigo));
    }

}
