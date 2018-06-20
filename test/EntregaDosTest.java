import junit.framework.TestCase;

public class EntregaDosTest extends TestCase {
    public void testJinzo7PuedeAtacarDirectamenteAlJugador(){
        Jugador j1 = new Jugador("1",1000);
        Monstruo jinzo7 = new Monstruo(500,400);
        CartaMonstruoJinzo7 cartaJinzo7 = new CartaMonstruoJinzo7(jinzo7, 2);
        cartaJinzo7.colocarEnPosAtaque();
        cartaJinzo7.atacar(j1);

        assertEquals(1000-500,j1.verVida());
    }
    public void testActivarWasteLandAumenta200ElDanioDeMonstruosAmigosY300LaDefensaOponente(){
        Cementerio unCementerio = new Cementerio();
        Campo c1 = new Campo(unCementerio);
        Campo c2 = new Campo(unCementerio);
        Jugador j1 = new Jugador("a", 1000);
        Jugador j2 = new Jugador("b", 1000);
        Monstruo a1 = new Monstruo(200, 100);
        Monstruo a2 = new Monstruo(10, 10);
        Monstruo a3 = new Monstruo(100,100);
        Monstruo a4 = new Monstruo(100,101);
        CartaMonstruo aitsu1 = new CartaMonstruo(a1, 4);
        CartaMonstruo aitsu2 = new CartaMonstruo(a2, 4);
        CartaMonstruo aitsu3 = new CartaMonstruo(a3, 4);
        CartaMonstruo aitsu4 = new CartaMonstruo(a4, 4);
        EfectoWasteland w = new EfectoWasteland(c1, c2);
        CartaDeCampo waste = new CartaDeCampo(w);
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

    public void testActivarSogenAumenta500LaDefensaDeMonstruosAmigosY200ElAtaqueOponente(){
        Cementerio unCementerio = new Cementerio();
        Campo c1 = new Campo(unCementerio);
        Campo c2 = new Campo(unCementerio);
        Jugador j1 = new Jugador("a", 1000);
        Jugador j2 = new Jugador("b", 1000);
        Monstruo g1 = new Monstruo(400, 400);
        Monstruo a2 = new Monstruo(10, 10);
        Monstruo a3 = new Monstruo(100,100);
        Monstruo a4 = new Monstruo(100,101);
        CartaMonstruo goblinFalso = new CartaMonstruo(g1, 4);
        CartaMonstruo aitsu2 = new CartaMonstruo(a2, 4);
        CartaMonstruo aitsu3 = new CartaMonstruo(a3, 4);
        CartaMonstruo aitsu4 = new CartaMonstruo(a4, 4);
        EfectoDeCampo efectoSogen = new EfectoSogen(c2, c1);
        CartaDeCampo sogen = new CartaDeCampo(efectoSogen);
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
        Campo unCampo = new Campo(new Cementerio());
        Mazo unMazo = new Mazo("", new Partida());
        unMazo.agregar(new CartaMonstruo(new Monstruo(1,1),1));
        unMazo.agregar(new CartaMagica(new AgujeroOscuro(unCampo)));
        Mano unaMano = new Mano("", new Partida());
        OllaDeLaCodicia unaOlla = new OllaDeLaCodicia(unaMano, unMazo);
        CartaMagica cartaOlla = new CartaMagica(unaOlla);
        cartaOlla.colocarBocaAbajo();
        cartaOlla.colocarse(unCampo);
        cartaOlla.colocarBocaArriba();

        assertEquals(2,unaMano.cantidad());
        assertEquals(0, unMazo.cantidad());

    }

    public void testActivarCartaFisuraDestruyeMonstruoDeMenorAtaqueEnemigoBocaArriba() {

        Cementerio cementerio = new Cementerio();
        Campo unCampo = new Campo(new Cementerio());
        Campo otroCampo = new Campo(cementerio);
        Fisura fisura = new Fisura(otroCampo);
        CartaMagica cartaFisura = new CartaMagica(fisura);

        Monstruo muchoAtaque = new Monstruo(400, 0);
        Monstruo pocoAtaque = new Monstruo(30, 12);
        Monstruo poquisimoAtaque = new Monstruo(5, 0);
        CartaMonstruo cartaMonstruoUno = new CartaMonstruo(muchoAtaque, 1);
        CartaMonstruo cartaMonstruoDos = new CartaMonstruo(pocoAtaque, 2);
        CartaMonstruo cartaMonstruoTres = new CartaMonstruo(poquisimoAtaque, 2);

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

    public void testInsectoComeHombreEsAtacadoBocaAbajoPorOtroMonstruoElPrimeroSeVolteaDestruyendoAlSegundo(){
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);

        Monstruo alasDeLlamaPerversa = new Monstruo(700, 1000);

        Efecto efectoDestruirMonstruo = new EfectoDestruirMonstruo(campoUno);
        Monstruo insectoComeHombres = new Monstruo(450,600, efectoDestruirMonstruo);

        CartaMonstruo cartaAlasDeLLama = new CartaMonstruo(alasDeLlamaPerversa,1);
        CartaMonstruoComeHombres cartaComeHombres = new CartaMonstruoComeHombres(insectoComeHombres,2);

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

    public void testCartaTrampaCilindroMagicoNiegaElAtaqueDelOponenteYLoReflejaTotalmenteSobreElJugadorEnemigo(){
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000);
        Jugador jugadorDos = new Jugador("2",1000);
        Monstruo mokeyMokey = new Monstruo(300,100);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo(mokeyMokey,3);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        Trampa cilindroMagico = new CilindroMagico();
        CartaTrampa cartaCilindroMagico = new CartaTrampa(cilindroMagico);
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

    public void testCartaTrampaRefuerzosAumentaElAtaqueDelMonstruoAtacadoEn100HastaElFinalDelTurno(){
        Cementerio unCementerio = new Cementerio();
        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Jugador jugadorUno = new Jugador("1",1000);
        Jugador jugadorDos = new Jugador("2",1000);

        Monstruo alasDeLlamaPerversa = new Monstruo(700,600);
        CartaMonstruo cartaAlasDeLlamaPerversa = new CartaMonstruo(alasDeLlamaPerversa,4);
        cartaAlasDeLlamaPerversa.colocarEnPosAtaque();
        cartaAlasDeLlamaPerversa.colocarBocaArriba();
        cartaAlasDeLlamaPerversa.colocarse(campoDos);

        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokeyMokey = new CartaMonstruo(mokeyMokey,3);
        cartaMokeyMokey.colocarEnPosAtaque();
        cartaMokeyMokey.colocarBocaArriba();
        cartaMokeyMokey.colocarse(campoUno);

        Trampa refuerzos = new Refuerzos();
        CartaTrampa cartaRefuerzos = new CartaTrampa(refuerzos);
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
        Partida unaPartida = new Partida();
        Mano unaMano = new Mano("Jugador 1", unaPartida);
        Efecto efectoArmarExodia = new EfectoArmarExodia();
        Monstruo cabezaExodia = new Monstruo(1000,1000, efectoArmarExodia);
        Monstruo brazoDerechoExodia = new Monstruo(1000,1000, efectoArmarExodia);
        Monstruo brazoIzquierdoExodia = new Monstruo(1000,1000, efectoArmarExodia);
        Monstruo piernaDerechaExodia = new Monstruo(1000,1000, efectoArmarExodia);
        Monstruo piernaIzquierdaExodia = new Monstruo(1000,1000, efectoArmarExodia);
        CartaExodia cartaCabeza = new CartaExodia(cabezaExodia,3);
        CartaExodia cartaBrazoDerecho = new CartaExodia(brazoDerechoExodia,3);
        CartaExodia cartaBrazoIzquierdo = new CartaExodia(brazoIzquierdoExodia,3);
        CartaExodia cartaPiernaDerecha = new CartaExodia(piernaDerechaExodia,3);
        CartaExodia cartaPiernaIzquierda = new CartaExodia(piernaIzquierdaExodia,3);
        cartaCabeza.colocarse(unaMano);
        cartaBrazoDerecho.colocarse(unaMano);
        cartaBrazoIzquierdo.colocarse(unaMano);
        cartaPiernaDerecha.colocarse(unaMano);
        cartaPiernaIzquierda.colocarse(unaMano);

        assertEquals("Jugador 1",unaPartida.verGanador());

    }

    public void testMazoSacarUltimaCartaSeteaEnPartidaAlPerdedor(){
        Partida unaPartida = new Partida();
        Mazo unMazo = new Mazo("Jugador 1", unaPartida);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        unMazo.agregar(cartaAitsu);
        unMazo.sacar();

        assertEquals("Jugador 1", unaPartida.verPerdedor());

    }
}
