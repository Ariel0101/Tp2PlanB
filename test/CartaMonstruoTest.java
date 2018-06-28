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
}
