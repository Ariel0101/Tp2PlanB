import junit.framework.TestCase;

public class EntregaUnoTest extends TestCase {

    public void testColocarUnMonstruoEnPosicionDeAtaque(){

        Monstruo ganador = new Monstruo(1001, 0);
        ganador.colocarEnPosAtaque();
        Monstruo perdedor = new Monstruo(1000, 0);
        perdedor.colocarEnPosAtaque();
        CartaMonstruo cGanador = new CartaMonstruo(ganador, 0);
        CartaMonstruo cPerdedor = new CartaMonstruo(perdedor, 0);

        Botin b = ganador.atacar(perdedor);
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(cPerdedor));
        assertFalse(c.esta(cGanador));

    }

    public void testColocarUnMonstruoEnPosicionDeDefensa(){

        Monstruo ganador = new Monstruo(0, 1001);
        ganador.colocarEnPosDefensa();
        Monstruo perdedor = new Monstruo(1000, 0);
        perdedor.colocarEnPosAtaque();
        CartaMonstruo cGanador = new CartaMonstruo(ganador, 0);
        CartaMonstruo cPerdedor = new CartaMonstruo(perdedor, 0);

        Botin b = perdedor.atacar(ganador);
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        assertFalse(c.esta(cPerdedor));
        assertFalse(c.esta(cGanador));

    }

    public void testColocarMagicaBocaAbajoNoActivaNingunEfecto(){

        Cementerio cementerio = new Cementerio();
        Campo campo = new Campo(cementerio);
        AgujeroOscuro agujero = new AgujeroOscuro(campo);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo m = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m, 4);

        agujeroOscuro.colocarBocaAbajo();
        campo.colocarCarta(agujeroOscuro);
        campo.colocarCarta(aitsu);

        assertFalse(cementerio.esta(aitsu));
    }

    public void testDestruirCartaMandaAlMonstruoAlCementerio(){

        Cementerio cementerio = new Cementerio();
        Monstruo m = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m, 4);

        aitsu.destruir(cementerio);

        assertTrue(cementerio.esta(aitsu));

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnAtaqueDestruyoAAitsuYElJugadorSufreDanio(){

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaArriba();
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = agujaAsesina.atacar(aitsu, new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000 - 1100);

    }

    public void testAgujaAsesinaEnAtaqueContraAgujaAsesinaEnAtaqueDestruyoAAmbosNadieSufrioDanio(){

        Monstruo ag1 = new Monstruo(1200, 1000);
        Monstruo ag2 = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina1 = new CartaMonstruo(ag1, 4);
        CartaMonstruo agujaAsesina2 = new CartaMonstruo(ag2, 4);
        agujaAsesina1.colocarEnPosAtaque();
        agujaAsesina1.colocarBocaArriba();
        agujaAsesina2.colocarEnPosAtaque();
        agujaAsesina2.colocarBocaArriba();
        Jugador j1 = new Jugador("", 10000);
        Jugador j2 = new Jugador("", 10000);

        Botin b = agujaAsesina1.atacar(agujaAsesina2,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(j1, j2);

        assertTrue(c.esta(agujaAsesina1));
        assertTrue(c.esta(agujaAsesina2));
        assertEquals(j1.verVida(), 10000);
        assertEquals(j2.verVida(), 10000);

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnDefensaDestruyoAAitsuYElJugadorNoSufreDanio(){

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosDefensa();
        aitsu.colocarBocaArriba();
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = agujaAsesina.atacar(aitsu,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testAitsuEnAtaqueContraAgujaAsesinaEnDefensaNoDestruyoAAitsuYElJugadorNoSufreDanio(){

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = aitsu.atacar(agujaAsesina,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertFalse(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testColocarAgujeroOscuroBocaArribaMataATodosEnElCampo(){

        Cementerio cementerio = new Cementerio();
        Campo campo = new Campo(cementerio);
        AgujeroOscuro agujero = new AgujeroOscuro(campo);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo m = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m, 4);

        campo.colocarCarta(aitsu);
        campo.colocarCarta(agujeroOscuro);
        agujeroOscuro.colocarBocaArriba();

        assertTrue(cementerio.esta(aitsu));
    }
}
