import Controlador.ConstructorDeCartas;
import Controlador.Partida;
import Modelo.Campo.*;
import Modelo.Carta;
import Modelo.CartasMagiaTrampa.*;
import Modelo.CartasMonstruo.*;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import junit.framework.TestCase;

public class EntregaDosTest extends TestCase {

    public void testJinzo7PuedeAtacarDirectamenteAlJugador(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Jugador j1 = new Jugador("1",1000, new Partida());
        CartaMonstruoJinzo7 cartaJinzo7 = constructorDeCartas.jinzo7(); //daño: 500, defensa: 400
        CartaMonstruo cartaAgresorOscuro = constructorDeCartas.agresorOscuro(); //daño: 1200, defensa:1200
        Campo campoEnemigo = new Campo(new Cementerio());

        cartaAgresorOscuro.colocarse(campoEnemigo);
        cartaJinzo7.colocarBocaArriba();
        cartaJinzo7.colocarEnPosAtaque();
        cartaJinzo7.atacar(j1, campoEnemigo);

        assertEquals(1000-500,j1.verVida());
    }

    public void testActivarWasteLandAumenta200ElDanioDeMonstruosAmigosY300LaDefensaOponente(){
        Cementerio unCementerio = new Cementerio();
        Campo c1 = new Campo(unCementerio);
        Campo c2 = new Campo(unCementerio);
        Jugador j1 = new Jugador("a", 1000, new Partida());
        Jugador j2 = new Jugador("b", 1000, new Partida());
        Monstruo a1 = new Monstruo(200, 100);
        Monstruo a2 = new Monstruo(10, 10);
        Monstruo a3 = new Monstruo(100,100);
        Monstruo a4 = new Monstruo(100,101);
        CartaMonstruo aitsu1 = new CartaMonstruo("", a1, 4);
        CartaMonstruo aitsu2 = new CartaMonstruo("", a2, 4);
        CartaMonstruo aitsu3 = new CartaMonstruo("", a3, 4);
        CartaMonstruo aitsu4 = new CartaMonstruo("", a4, 4);
        EfectoWasteland w = new EfectoWasteland(c1, c2);
        CartaDeCampo waste = new CartaDeCampo("", w);
        aitsu1.colocarEnPosAtaque();
        aitsu2.colocarEnPosAtaque();
        aitsu3.colocarEnPosDefensa();
        aitsu4.colocarEnPosDefensa();
        aitsu1.colocarBocaArriba();
        aitsu2.colocarBocaArriba();
        aitsu3.colocarBocaArriba();
        aitsu4.colocarBocaArriba();
        waste.colocarBocaArriba();
        aitsu1.colocarse(c1);
        waste.colocarse(c1);
        aitsu2.colocarse(c2);
        aitsu3.colocarse(c2);
        aitsu4.colocarse(c2);

        Botin b = aitsu1.atacar(aitsu2, c2);
        b.infligirDanios(j1, j2);

        b = aitsu1.atacar(aitsu3,c2);
        b.ejecutar(c2);
        b = aitsu1.atacar(aitsu4,c2);
        b.ejecutar(c2);

        assertEquals(j2.verVida(), 1000 - 390);
        assertEquals(j1.verVida(), 1000);
        assertTrue(unCementerio.esta(aitsu3));
        assertFalse(unCementerio.esta(aitsu4));
    }

    public void testActivarSogenAumenta500LaDefensaDeMonstruosAmigosY200ElAtaqueOponente() throws MonstruoNoPuedeAtacarError {
        Cementerio unCementerio = new Cementerio();
        Campo c1 = new Campo(unCementerio);
        Campo c2 = new Campo(unCementerio);
        Jugador j1 = new Jugador("a", 1000, new Partida());
        Jugador j2 = new Jugador("b", 1000, new Partida());
        Monstruo g1 = new Monstruo(400, 400);
        Monstruo a2 = new Monstruo(10, 10);
        Monstruo a3 = new Monstruo(100,100);
        Monstruo a4 = new Monstruo(100,101);
        CartaMonstruo goblinFalso = new CartaMonstruo("", g1, 4);
        CartaMonstruo aitsu2 = new CartaMonstruo("", a2, 4);
        CartaMonstruo aitsu3 = new CartaMonstruo("", a3, 4);
        CartaMonstruo aitsu4 = new CartaMonstruo("", a4, 4);
        EfectoDeCampo efectoSogen = new EfectoSogen(c2, c1);
        CartaDeCampo sogen = new CartaDeCampo("", efectoSogen);
        goblinFalso.colocarEnPosAtaque();
        aitsu2.colocarEnPosAtaque();
        aitsu3.colocarEnPosDefensa();
        aitsu4.colocarEnPosDefensa();
        goblinFalso.colocarBocaArriba();
        aitsu2.colocarBocaArriba();
        aitsu3.colocarBocaArriba();
        aitsu4.colocarBocaArriba();
        sogen.colocarBocaArriba();
        goblinFalso.colocarse(c1);
        sogen.colocarse(c2);
        aitsu2.colocarse(c2);
        aitsu3.colocarse(c2);
        aitsu4.colocarse(c2);

        Botin b = goblinFalso.atacar(aitsu2, c2);
        b.infligirDanios(j1, j2);

        b = goblinFalso.atacar(aitsu3,c2);
        b.ejecutar(c2);
        b = goblinFalso.atacar(aitsu4,c2);
        b.ejecutar(c2);

        assertEquals(j2.verVida(), 1000 - 590);
        assertEquals(j1.verVida(), 1000);
        assertTrue(unCementerio.esta(aitsu3));
        assertFalse(unCementerio.esta(aitsu4));
    }

    public void testOllaDeLaCodiciaActivarSacaDosCartasDelMazoYlasColocaEnLaMano(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Campo unCampo = new Campo(new Cementerio());
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mazo unMazo = new Mazo(unJugador);
        unMazo.agregar(constructorDeCartas.agujaAsesina());
        unMazo.agregar(constructorDeCartas.aitsu());
        Mano unaMano = new Mano(unJugador);
        CartaMagica cartaOlla = constructorDeCartas.ollaDeLaCodicia(unaMano, unMazo);
        cartaOlla.colocarBocaAbajo();
        cartaOlla.colocarse(unCampo);
        cartaOlla.colocarBocaArriba();

        assertEquals(2,unaMano.contarCartas(Carta.class));
        assertEquals(0, unMazo.cantidad());

    }

    public void testActivarCartaFisuraDestruyeMonstruoDeMenorAtaqueEnemigoBocaArriba() {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio cementerio = new Cementerio();
        Campo unCampo = new Campo(new Cementerio());
        Campo otroCampo = new Campo(cementerio);
        CartaMagica cartaFisura = constructorDeCartas.fisura(otroCampo);

        Monstruo muchoAtaque = new Monstruo(400, 0);
        Monstruo pocoAtaque = new Monstruo(30, 12);
        Monstruo poquisimoAtaque = new Monstruo(5, 0);
        CartaMonstruo cartaMonstruoUno = new CartaMonstruo("", muchoAtaque, 1);
        CartaMonstruo cartaMonstruoDos = new CartaMonstruo("", pocoAtaque, 2);
        CartaMonstruo cartaMonstruoTres = new CartaMonstruo("", poquisimoAtaque, 2);

        cartaMonstruoUno.colocarse(otroCampo);
        cartaMonstruoDos.colocarse(otroCampo);
        cartaMonstruoTres.colocarse(otroCampo);
        cartaMonstruoUno.colocarBocaArriba();
        cartaMonstruoDos.colocarBocaArriba();
        cartaMonstruoTres.colocarBocaAbajo(); //Fisura no la tiene que contar. Solo mira las boca Arriba

        cartaFisura.colocarse(unCampo);
        cartaFisura.colocarBocaArriba();

        assertFalse(cementerio.esta(cartaMonstruoUno));
        assertTrue(cementerio.esta(cartaMonstruoDos));
        assertFalse(cementerio.esta(cartaMonstruoTres));

    }

    public  void testInvocar3DragonesBlancosDeOjosAzulesYAlDragonDefinitivoSacrificaLosTresDragones()  {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado1 = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada1 = new CartaMonstruo("", monstruoSacrificado1, 4);
        Monstruo monstruoSacrificado2 = new Monstruo(100, 50);
        CartaMonstruo cartaSacrificada2 = new CartaMonstruo("", monstruoSacrificado2, 3);
        Monstruo monstruoSacrificado3 = new Monstruo(100, 8);
        CartaMonstruo cartaSacrificada3 = new CartaMonstruo("", monstruoSacrificado3, 4);
        Monstruo monstruoSacrificado4 = new Monstruo(100, 6);
        CartaMonstruo cartaSacrificada4 = new CartaMonstruo("", monstruoSacrificado4, 1);
        Monstruo monstruoSacrificado5 = new Monstruo(100, 77);
        CartaMonstruo cartaSacrificada5 = new CartaMonstruo("", monstruoSacrificado5, 2);
        Monstruo monstruoSacrificado6 = new Monstruo(100, 33);
        CartaMonstruo cartaSacrificada6 = new CartaMonstruo("", monstruoSacrificado6, 1);
        
        CartaMonstruo cartaDragon1 = constructorDeCartas.dragonDeOjosAzules();
        CartaMonstruo cartaDragon2 = constructorDeCartas.dragonDeOjosAzules();
        CartaMonstruo cartaDragon3 = constructorDeCartas.dragonDeOjosAzules();
        CartaMonstruoDragonDefinitivo cartaDragonDefinitivo = constructorDeCartas.dragonDefinitivoDeOjosAzules();
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo("", monstruoAtacado ,1);
        
        unCampo.colocarCarta(cartaSacrificada1);
        unCampo.colocarCarta(cartaSacrificada2);
        unCampo.colocarCarta(cartaSacrificada3);
        unCampo.colocarCarta(cartaSacrificada4);
        unCampo.colocarCarta(cartaSacrificada5);
        unCampo.colocarCarta(cartaSacrificada6);
        unCampo.colocarCarta(cartaDragon1);
        unCampo.colocarCarta(cartaDragon2);
        unCampo.colocarCarta(cartaDragon3);
        unCampo.colocarCarta(cartaDragonDefinitivo);
        
        cartaDragonDefinitivo.colocarBocaArriba();
        cartaDragonDefinitivo.colocarEnPosAtaque();
        otroCampo.colocarCarta(cartaAtacada);
        cartaAtacada.colocarBocaArriba();
        cartaAtacada.colocarEnPosAtaque();
        Botin b = cartaDragonDefinitivo.atacar(cartaAtacada, otroCampo);
        b.ejecutar(otroCampo);
    	
    	assertTrue(unCementerio.esta(cartaSacrificada1));
    	assertTrue(unCementerio.esta(cartaSacrificada2));
    	assertTrue(unCementerio.esta(cartaSacrificada3));
    	assertTrue(unCementerio.esta(cartaSacrificada4));
    	assertTrue(unCementerio.esta(cartaSacrificada5));
    	assertTrue(unCementerio.esta(cartaSacrificada6));
    	assertTrue(unCementerio.esta(cartaDragon1));
    	assertTrue(unCementerio.esta(cartaDragon2));
    	assertTrue(unCementerio.esta(cartaDragon3));
    	assertTrue(otroCementerio.esta(cartaAtacada));
    }
    
    public void testInsectoComeHombreEsAtacadoBocaAbajoPorOtroMonstruoElPrimeroSeVolteaDestruyendoAlSegundo() {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);

        CartaMonstruo cartaAlasDeLLama = constructorDeCartas.alasDeLlamaPerversa();
        CartaMonstruoComeHombres cartaComeHombres = constructorDeCartas.insectoComeHombres(campoUno);

        cartaAlasDeLLama.colocarBocaArriba();
        cartaAlasDeLLama.colocarEnPosAtaque();
        cartaComeHombres.colocarBocaAbajo();
        cartaComeHombres.colocarEnPosDefensa();

        campoUno.colocarCarta(cartaAlasDeLLama);
        campoDos.colocarCarta(cartaComeHombres);

        Botin unBotin = cartaAlasDeLLama.atacar(cartaComeHombres, campoDos);

        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);

        assertFalse(unCementerio.esta(cartaComeHombres));
        assertTrue(unCementerio.esta(cartaAlasDeLLama));
    }

    public void testCartaTrampaCilindroMagicoNiegaElAtaqueDelOponenteYLoReflejaTotalmenteSobreElJugadorEnemigo() {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000, new Partida());
        Jugador jugadorDos = new Jugador("2",1000, new Partida());
        Monstruo mokeyMokey = new Monstruo(300,100);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo("", mokeyMokey,3);
        CartaMonstruo cartaAitsu = new CartaMonstruo("", aitsu,4);
        CartaTrampa cartaCilindroMagico = constructorDeCartas.cilindroMagico();
        cartaMokeyMokey.colocarEnPosAtaque();
        cartaMokeyMokey.colocarBocaArriba();
        cartaMokeyMokey.colocarse(campoUno);
        cartaAitsu.colocarEnPosAtaque();
        cartaAitsu.colocarBocaArriba();
        cartaAitsu.colocarse(campoDos);

        cartaCilindroMagico.colocarse(campoDos);
        Botin unBotin = cartaMokeyMokey.atacar(cartaAitsu, campoDos);
        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);
        unBotin.infligirDanios(jugadorUno,jugadorDos);

        assertEquals(1000-300, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
        assertTrue(unCementerio.esta(cartaCilindroMagico));
        assertFalse(unCementerio.esta(cartaMokeyMokey));
        assertFalse(unCementerio.esta(cartaAitsu));

    }

    public void testCartaTrampaRefuerzosAumentaElAtaqueDelMonstruoAtacadoEn100HastaElFinalDelTurno() {
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000, new Partida());
        Jugador jugadorDos = new Jugador("2",1000, new Partida());

        Monstruo alasDeLlamaPerversa = new Monstruo(700,600);
        CartaMonstruo cartaAlasDeLlamaPerversa = new CartaMonstruo("", alasDeLlamaPerversa,4);
        cartaAlasDeLlamaPerversa.colocarEnPosAtaque();
        cartaAlasDeLlamaPerversa.colocarBocaArriba();
        cartaAlasDeLlamaPerversa.colocarse(campoDos);

        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo("", mokeyMokey,3);
        cartaMokeyMokey.colocarEnPosAtaque();
        cartaMokeyMokey.colocarBocaArriba();
        cartaMokeyMokey.colocarse(campoUno);

        Trampa refuerzos = new Refuerzos();
        CartaTrampa cartaRefuerzos = new CartaTrampa("", refuerzos);
        cartaRefuerzos.colocarse(campoDos);

        Botin unBotin = cartaAlasDeLlamaPerversa.atacar(cartaMokeyMokey, campoDos);
        unBotin.ejecutar(campoUno);
        unBotin.ejecutar(campoDos);
        unBotin.infligirDanios(jugadorUno,jugadorDos);

        assertEquals(1000-100, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
        assertTrue(unCementerio.esta(cartaRefuerzos));
        assertFalse(unCementerio.esta(cartaMokeyMokey));
        assertTrue(unCementerio.esta(cartaAlasDeLlamaPerversa));
    }

    public void testManoAgregarLas5PartesDeExodiaSeteaEnPartidaAlGanador(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);
        CartaMonstruoExodia cartaCabeza = constructorDeCartas.cabezaDeExodia();
        CartaMonstruoExodia cartaBrazoDerecho = constructorDeCartas.brazoDerechoExodia();
        CartaMonstruoExodia cartaBrazoIzquierdo = constructorDeCartas.brazoIzquierdoExodia();
        CartaMonstruoExodia cartaPiernaDerecha = constructorDeCartas.piernaDerechaExodia();
        CartaMonstruoExodia cartaPiernaIzquierda = constructorDeCartas.piernaIzquierdaExodia();
        cartaCabeza.colocarse(unaMano);
        cartaBrazoDerecho.colocarse(unaMano);
        cartaBrazoIzquierdo.colocarse(unaMano);
        cartaPiernaDerecha.colocarse(unaMano);
        cartaPiernaIzquierda.colocarse(unaMano);

        assertEquals("Jugador 1",unaPartida.verGanador());

    }

    public void testMazoSacarUltimaCartaSeteaEnPartidaAlPerdedor(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mano unaMano = new Mano(unJugador);
        Mazo unMazo = new Mazo(unJugador);
        CartaMonstruo cartaAitsu = constructorDeCartas.aitsu();
        unMazo.agregar(cartaAitsu);
        unMazo.sacar(unaMano);

        assertEquals(nombreJugador, unaPartida.verPerdedor());

    }
}
