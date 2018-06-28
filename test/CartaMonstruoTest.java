import junit.framework.TestCase;

public class CartaMonstruoTest extends TestCase {

    public void testCartaConMosntruoAitsuNoAtacaSiEstaBocaAbajo() throws MonstruoNoPuedeAtacarError{

        Monstruo ai = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaAbajo();

        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();

        Botin b = aitsu.atacar(agujaAsesina, new Campo(new Cementerio()));
        Cementerio c = new Cementerio();

        b.ejecutar(new Campo(c));

        assertFalse(c.esta(aitsu));

    }

    public void testCartaConMosntruoAitsuAtacaSiEstaBocaArriba() throws MonstruoNoPuedeAtacarError{

        Monstruo ai = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaArriba();

        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();

        Botin b = aitsu.atacar(agujaAsesina, new Campo(new Cementerio()));
        Cementerio c = new Cementerio();

        b.ejecutar(new Campo(c));

        assertTrue(c.esta(aitsu));

    }

    public void testMonstruoPuedeAtacarAJugadorSiNoHayMonstruosEnElCampoEnemigo() {

        Monstruo m1 = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m1, 1);
        Jugador yuGi = new Jugador("YuGi", 8000);
        Campo campoYugi = new Campo(new Cementerio());

        aitsu.colocarBocaArriba();
        aitsu.colocarEnPosAtaque();
        aitsu.atacar(yuGi, campoYugi);

        assertTrue(yuGi.verVida() == (8000-100));
    }

    public void testMonstruoNoPuedeAtacarAJugadorSiHayMonstruoBocaArribaEnElCampoEnemigo() {

        Monstruo m1 = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m1, 1);
        Monstruo m2 = new Monstruo(100, 100);
        CartaMonstruo aitsuEnemigo = new CartaMonstruo(m2, 1);
        Jugador yuGi = new Jugador("YuGi", 8000);
        Campo campoYugi = new Campo(new Cementerio());

        aitsuEnemigo.colocarse(campoYugi);
        aitsuEnemigo.colocarBocaArriba();
        aitsu.colocarBocaArriba();
        aitsu.colocarEnPosAtaque();
        try {
            aitsu.atacar(yuGi, campoYugi);
        } catch (NoSePuedeAtacarAJugadorError e) {
        }

        assertTrue(yuGi.verVida() == 8000);
    }

    public void testMonstruoNoPuedeAtacarAJugadorSiHayMonstruoBocaAbajoEnElCampoEnemigo() {

        Monstruo m1 = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m1, 1);
        Monstruo m2 = new Monstruo(100, 100);
        CartaMonstruo aitsuEnemigo = new CartaMonstruo(m2, 1);
        Jugador yuGi = new Jugador("YuGi", 8000);
        Campo campoYugi = new Campo(new Cementerio());

        aitsuEnemigo.colocarse(campoYugi);
        aitsuEnemigo.colocarBocaAbajo();
        aitsu.colocarBocaArriba();
        aitsu.colocarEnPosAtaque();
        try {
            aitsu.atacar(yuGi, campoYugi);
        } catch (NoSePuedeAtacarAJugadorError e) {
        }

        assertTrue(yuGi.verVida() == 8000);
    }

    public void testMonstruoJinzo7PuedeAtacarAJugadorAunqueHayMonstruosEnElCampoEnemigo() {

        Monstruo m1 = new Monstruo(400, 100);
        CartaMonstruoJinzo7 jinzo7 = new CartaMonstruoJinzo7(m1, 1);
        Monstruo m2 = new Monstruo(100, 100);
        CartaMonstruo aitsuEnemigo = new CartaMonstruo(m2, 1);
        Monstruo m3 = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina = new CartaMonstruo(m3, 1);
        Jugador yuGi = new Jugador("YuGi", 8000);
        Campo campoYugi = new Campo(new Cementerio());

        aitsuEnemigo.colocarse(campoYugi);
        aitsuEnemigo.colocarBocaAbajo();
        agujaAsesina.colocarse(campoYugi);
        agujaAsesina.colocarBocaArriba();
        jinzo7.colocarBocaArriba();
        jinzo7.colocarEnPosAtaque();
        jinzo7.atacar(yuGi, campoYugi);

        assertTrue(yuGi.verVida() == (8000-400));
    }
}
