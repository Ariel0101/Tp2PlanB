import junit.framework.TestCase;

public class CartaMonstruoTest extends TestCase {

    public void testCartaConMosntruoAitsuNoAtacaSiEstaBocaAbajo(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruo cAitsu = new CartaMonstruo(aitsu);
        cAitsu.colocarEnPosAtaque();
        cAitsu.colocarBocaAbajo();

        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        CartaMonstruo cAguja = new CartaMonstruo(agujaAsesina);
        cAguja.colocarEnPosAtaque();
        cAguja.colocarBocaArriba();

        Botin b = new Botin();//cAitsu.atacar(cAguja);
        Cementerio c = new Cementerio();

        b.ejecutar(c);

        assertFalse(c.esta(aitsu));

    }

    public void testCartaConMosntruoAitsuAtacaSiEstaBocaArriba(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruo cAitsu = new CartaMonstruo(aitsu);
        cAitsu.colocarEnPosAtaque();
        cAitsu.colocarBocaArriba();

        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        CartaMonstruo cAguja = new CartaMonstruo(agujaAsesina);
        cAguja.colocarEnPosAtaque();
        cAguja.colocarBocaArriba();

        Botin b = new Botin();// cAitsu.atacar(cAguja);
        Cementerio c = new Cementerio();

        b.ejecutar(c);

        assertTrue(c.esta(aitsu));

    }

}
