package Controlador;

import Modelo.Campo.Campo;
import Modelo.Carta;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import Modelo.NoCarta;

import java.util.Random;

public class RandomizadorCartas {

    private ConstructorDeCartas constructor = new ConstructorDeCartas();
    private int contExodia = 1;
    private Campo campoEnemigo;
    private Campo campoAmigo;
    private Mano manoPropia;
    private Mazo mazo;

    public RandomizadorCartas(Campo campoEnemigo, Campo campoAmigo, Mano manoPropia, Mazo mazo) {

        this.campoEnemigo = campoEnemigo;
        this.campoAmigo = campoAmigo;
        this.manoPropia = manoPropia;
        this.mazo = mazo;

    }

    void llenarMazo(Mazo m){

        for(int i = 0; i < 40; i++){

            m.agregar(this.cartaRandom(18));

        }

        this.contExodia = 1;

    }

    private Carta cartaRandom(int rango){

        Random rn = new Random();
        int rand =  rn.nextInt(rango) + 1;

        Carta c;

        switch (rand) {

            case 1: c = this.constructor.aitsu();
                break;
            case 2: c = this.constructor.mokeyMokey();
                break;
            case 3: c = this.constructor.agresorOscuro();
                break;
            case 4: c = this.constructor.agujaAsesina();
                break;
            case 5: c = this.constructor.agujeroNegro(campoAmigo, campoEnemigo);
                break;
            case 6: c = this.constructor.alasDeLlamaPerversa();
                break;
            case 7: c = this.constructor.cilindroMagico();
                break;
            case 8: c = this.constructor.dragonDefinitivoDeOjosAzules();
                break;
            case 9: c = this.constructor.dragonDeOjosAzules();
                break;
            case 10: c = this.constructor.fisura(campoEnemigo);
                break;
            case 11: c = this.constructor.wasteland(campoAmigo, campoEnemigo);
                break;
            case 12: c = this.constructor.goblinFalso();
                break;
            case 13: c = this.constructor.jinzo7();
                break;
            case 14: c = this.constructor.ollaDeLaCodicia(manoPropia, mazo);
                break;
            case 15: c = this.constructor.sogen(campoAmigo, campoEnemigo);
                break;
            case 16: c = this.constructor.refuerzos();
                break;
            case 17: c = this.constructor.insectoComeHombres(campoEnemigo);
                break;
            case 18: c = this.parteDeExodia();
                break;
            default: c = new NoCarta();
        }

        return c;

    }

    private Carta parteDeExodia() {

        Carta c;

        switch (this.contExodia){

            case 1: c = this.constructor.brazoDerechoExodia();
                break;
            case 2: c = this.constructor.piernaizquierdaExodia();
                break;
            case 3: c =  this.constructor.brazoIzquierdoExodia();
                break;
            case 4: c = this.constructor.piernaDerechaExodia();
                break;
            case 5: c = this.constructor.cabezaDeExodia();
                break;
            default: c = this.cartaRandom(17);

        }

        this.contExodia++;
        return c;

    }

}
