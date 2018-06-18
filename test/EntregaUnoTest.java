import junit.framework.TestCase;

public class EntregaUnoTest extends TestCase {

    public void testColocarUnMonstruoEnPosicionDeAtaque(){

        Monstruo ganador = new Monstruo(1001, 0, 0);
        ganador.colocarEnPosAtaque();
        Monstruo perdedor = new Monstruo(1000, 0, 0);
        perdedor.colocarEnPosAtaque();

        Botin b = ganador.atacar(perdedor);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        assertTrue(c.esta(perdedor));
        assertFalse(c.esta(ganador));

    }

    public void testColocarUnMonstruoEnPosicionDeDefensa(){

        Monstruo ganador = new Monstruo(0, 1001, 0);
        ganador.colocarEnPosDefensa();
        Monstruo perdedor = new Monstruo(1000, 0, 0);
        perdedor.colocarEnPosAtaque();

        Botin b = perdedor.atacar(ganador);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        assertFalse(c.esta(perdedor));
        assertFalse(c.esta(ganador));

    }

    public void testColocarMagicaBocaAbajoNoActivaNingunEfecto(){

        Campo campo = new Campo();
        Cementerio cementerio = new Cementerio();
        AgujeroOscuro agujero = new AgujeroOscuro(campo, cementerio);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo m = new Monstruo(100, 100, 4);
        CartaMonstruo aitsu = new CartaMonstruo(m);

        agujeroOscuro.colocarBocaAbajo();
        campo.colocarCarta(agujeroOscuro);
        campo.colocarCarta(aitsu);

        assertFalse(cementerio.esta(m));
    }

    public void testDestruirCartaMandaAlMonstruoAlCementerio(){

        Cementerio cementerio = new Cementerio();
        Monstruo m = new Monstruo(100, 100, 4);
        CartaMonstruo aitsu = new CartaMonstruo(m);

        aitsu.destruir(cementerio);

        assertTrue(cementerio.esta(m));

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnAtaqueDestruyoAAitsuYElJugadorSufreDanio(){

        Monstruo ai = new Monstruo(100, 100, 5);
        Monstruo ag = new Monstruo(1200, 1000, 4);
        CartaMonstruo aitsu = new CartaMonstruo(ai);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = agujaAsesina.atacar(aitsu);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(ai));
        assertEquals(jAitsu.verVida(), 10000 - 1100);

    }

    public void testAgujaAsesinaEnAtaqueContraAgujaAsesinaEnAtaqueDestruyoAAmbosNadieSufrioDanio(){

        Monstruo ag1 = new Monstruo(1200, 1000, 4);
        Monstruo ag2 = new Monstruo(1200, 1000, 4);
        CartaMonstruo agujaAsesina1 = new CartaMonstruo(ag1);
        CartaMonstruo agujaAsesina2 = new CartaMonstruo(ag2);
        agujaAsesina1.colocarEnPosAtaque();
        agujaAsesina2.colocarEnPosAtaque();
        Jugador j1 = new Jugador("", 10000);
        Jugador j2 = new Jugador("", 10000);

        Botin b = agujaAsesina1.atacar(agujaAsesina2);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        b.infligirDanios(j1, j2);

        assertTrue(c.esta(ag1));
        assertTrue(c.esta(ag2));
        assertEquals(j1.verVida(), 10000);
        assertEquals(j2.verVida(), 10000);

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnDefensaDestruyoAAitsuYElJugadorNoSufreDanio(){

        Monstruo ai = new Monstruo(100, 100, 5);
        Monstruo ag = new Monstruo(1200, 1000, 4);
        CartaMonstruo aitsu = new CartaMonstruo(ai);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag);
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = agujaAsesina.atacar(aitsu);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(ai));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testAitsuEnAtaqueContraAgujaAsesinaEnDefensaNoDestruyoAAitsuYElJugadorNoSufreDanio(){

        Monstruo ai = new Monstruo(100, 100, 5);
        Monstruo ag = new Monstruo(1200, 1000, 4);
        CartaMonstruo aitsu = new CartaMonstruo(ai);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();
        Jugador jAitsu = new Jugador("", 10000);
        Jugador jAgujero = new Jugador("", 10000);

        Botin b = aitsu.atacar(agujaAsesina);
        Cementerio c = new Cementerio();
        b.ejecutar(c);

        b.infligirDanios(jAgujero, jAitsu);

        assertFalse(c.esta(ai));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testColocarAgujeroOscuroBocaArribaMataATodosEnElCampo(){

        Campo campo = new Campo();
        Cementerio cementerio = new Cementerio();
        AgujeroOscuro agujero = new AgujeroOscuro(campo, cementerio);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo m = new Monstruo(100, 100, 4);
        CartaMonstruo aitsu = new CartaMonstruo(m);

        campo.colocarCarta(aitsu);
        campo.colocarCarta(agujeroOscuro);
        agujeroOscuro.colocarBocaArriba();

        assertFalse(cementerio.esta(m));
    }

}
