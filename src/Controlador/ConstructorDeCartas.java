package Controlador;

import Modelo.Campo.Campo;
import Modelo.Campo.CartaDeCampo;
import Modelo.Campo.EfectoSogen;
import Modelo.Campo.EfectoWasteland;
import Modelo.CartasMagiaTrampa.*;
import Modelo.CartasMonstruo.*;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;

public class ConstructorDeCartas {

    //Cartas Monstruo
    public CartaMonstruo aitsu(){
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu =  new CartaMonstruo("Aitsu", aitsu, 5);
        return cartaAitsu;
    }

    public CartaMonstruo mokeyMokey(){
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo("Mokey Mokey", mokeyMokey,3);
        return cartaMokeyMokey;

    }

    public CartaMonstruo goblinFalso(){
        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblinFalso = new CartaMonstruo("Goblin Falso", goblinFalso, 1);
        return cartaGoblinFalso;
    }

    public CartaMonstruo agujaAsesina(){
        Monstruo agujaAsesina = new Monstruo(1200,1000);
        CartaMonstruo cartaAgugaAsesina = new CartaMonstruo("Aguja Asesina", agujaAsesina,4);
        return cartaAgugaAsesina;
    }

    public CartaMonstruo agresorOscuro(){
        Monstruo agresorOscuro = new Monstruo(1200,1200);
        CartaMonstruo carta = new CartaMonstruo("Agresor Oscuro", agresorOscuro,4);
        return carta;
    }

    public CartaMonstruo alasDeLlamaPerversa(){
        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600);
        CartaMonstruo carta = new CartaMonstruo("Alas De La Llama Perversa", alasDeLlamaPerversa, 2);
        return carta;
    }

    public CartaMonstruoJinzo7 jinzo7(){
        Monstruo jinzo7 = new Monstruo(500,400);
        CartaMonstruoJinzo7 carta = new CartaMonstruoJinzo7("Jinzo 7", jinzo7,2);
        return carta;
    }

    public CartaMonstruoComeHombres insectoComeHombres(Campo campoEnemigo){
        Monstruo insectoComeHombres = new Monstruo(450, 600);
        CartaMonstruoComeHombres carta = new CartaMonstruoComeHombres("Insecto Come Hombres", insectoComeHombres,2, campoEnemigo);
        return carta;
    }

    public CartaMonstruoExodia cabezaDeExodia(){
        Monstruo cabezaExodia = new Monstruo(1000,1000);
        CartaMonstruoExodia carta = new CartaMonstruoExodia("Cabeza De Exodia", cabezaExodia,3);
        return carta;
    }

    public CartaMonstruoExodia brazoDerechoExodia(){
        Monstruo brazoDerechoExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia("Brazo Derecho De Exodia", brazoDerechoExodia,3);
        return carta;
    }

    public CartaMonstruoExodia brazoIzquierdoExodia(){
        Monstruo brazoIzquierdoExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia("Brazo Izquierdo De Exodia", brazoIzquierdoExodia,3);
        return carta;
    }

    public CartaMonstruoExodia piernaDerechaExodia(){
        Monstruo piernaDerechaExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia("Pierna Derecha De Exodia", piernaDerechaExodia,3);
        return carta;
    }

    public CartaMonstruoExodia piernaIzquierdaExodia(){
        Monstruo piernaIzquierdaExodia = new Monstruo(200,300);
        CartaMonstruoExodia carta = new CartaMonstruoExodia("Pierna Izquiera De Exodia", piernaIzquierdaExodia,3);
        return carta;
    }

    public CartaMonstruoDragon dragonDeOjosAzules(){
        CartaMonstruoDragon carta = new CartaMonstruoDragon("Dragon De Ojos Azules");
        return carta;
    }

    public CartaMonstruoDragonDefinitivo dragonDefinitivoDeOjosAzules(){
        CartaMonstruoDragonDefinitivo carta = new CartaMonstruoDragonDefinitivo("Dragon Definitivo");
        return carta;
    }

    //Cartas Magicas
    public CartaMagica agujeroOscuro(Campo unLadoDelCampo, Campo otroLadoDelCampo){
        AgujeroOscuro agujeroOscuro= new AgujeroOscuro(unLadoDelCampo, otroLadoDelCampo);
        CartaMagica cartaAgujero = new CartaMagica("Agujero Oscuro", agujeroOscuro);
        return cartaAgujero;

    }

    public CartaMagica ollaDeLaCodicia(Mano miMano, Mazo miMazo){
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia(miMano, miMazo);
        CartaMagica carta = new CartaMagica("Olla De La Codicia", ollaDeLaCodicia);

        return carta;
    }

    public CartaMagica fisura(Campo campoEnemigo){
        Fisura fisura = new Fisura(campoEnemigo);
        CartaMagica carta = new CartaMagica("Fisura", fisura);
        return carta;
    }

    //Cartas Trampa

    public CartaTrampa refuerzos(){
        Refuerzos refuerzos = new Refuerzos();
        CartaTrampa carta = new CartaTrampa("Refuerzos", refuerzos);
        return carta;
    }

    public CartaTrampa cilindroMagico(){
        CilindroMagico cilindroMagico = new CilindroMagico();
        CartaTrampa carta = new CartaTrampa("Cilindro Magico", cilindroMagico);
        return carta;
    }

    // Cartas de Campo

    public CartaDeCampo wasteland(Campo campoAmigo, Campo campoEnemigo){
        EfectoWasteland efectoWasteland = new EfectoWasteland(campoAmigo, campoEnemigo);
        CartaDeCampo carta = new CartaDeCampo("Wasteland", efectoWasteland);

        return carta;
    }

    public CartaDeCampo sogen(Campo campoAmigo, Campo campoEnemigo){
        EfectoSogen efectoSogen = new EfectoSogen(campoAmigo,campoEnemigo);
        CartaDeCampo carta = new CartaDeCampo("Sogen", efectoSogen);
        return carta;
    }
}
