import junit.framework.TestCase;

public class RefuerzosTest extends TestCase {
    public void testCartaTrampaRefuerzosAumentaElAtaqueDelMonstruoAtacadoEn100HastaElFinalDelTurno() throws MonstruoNoPuedeAtacarError{
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

    public void testTrampaRefuerzosTrasActivarseSeMantieneActiva() throws MonstruoNoPuedeAtacarError{
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

        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        cartaAitsu.colocarEnPosAtaque();
        cartaAitsu.colocarBocaArriba();
        cartaAitsu.colocarse(campoUno);

        Trampa refuerzos = new Refuerzos();
        CartaTrampa cartaRefuerzos = new CartaTrampa(refuerzos);
        cartaRefuerzos.colocarse(campoDos);

        cartaAlasDeLlamaPerversa.atacar(cartaMokeyMokey, campoDos);

        Botin unBotin = cartaAitsu.atacar(cartaMokeyMokey,campoDos);
        unBotin.infligirDanios(jugadorUno, jugadorDos);

        assertEquals(1000-700, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
    }

    public void testTrampaRefuerzosEfectoSobreMonstruoSeDesactivaCuandoSeDesactivanTemporales() throws MonstruoNoPuedeAtacarError{
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

        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        cartaAitsu.colocarEnPosAtaque();
        cartaAitsu.colocarBocaArriba();
        cartaAitsu.colocarse(campoUno);

        Trampa refuerzos = new Refuerzos();
        CartaTrampa cartaRefuerzos = new CartaTrampa(refuerzos);
        cartaRefuerzos.colocarse(campoDos);

        cartaAlasDeLlamaPerversa.atacar(cartaMokeyMokey, campoDos);

        cartaMokeyMokey.desactivarTemporales();

        Botin unBotin = cartaAitsu.atacar(cartaMokeyMokey,campoDos);
        unBotin.infligirDanios(jugadorUno, jugadorDos);

        assertEquals(1000-200, jugadorUno.verVida());
        assertEquals(1000, jugadorDos.verVida());
    }
}
