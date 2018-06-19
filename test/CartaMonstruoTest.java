import junit.framework.TestCase;

public class CartaMonstruoTest extends TestCase {

    public void testCartaConMosntruoAitsuNoAtacaSiEstaBocaAbajo(){

        Monstruo ai = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaAbajo();

        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();

        Botin b = aitsu.atacar(agujaAsesina);
        Cementerio c = new Cementerio();

        b.ejecutar(new Campo(c));

        assertFalse(c.esta(aitsu));

    }

    public void testCartaConMosntruoAitsuAtacaSiEstaBocaArriba(){

        Monstruo ai = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaArriba();

        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();

        Botin b = aitsu.atacar(agujaAsesina);
        Cementerio c = new Cementerio();

        b.ejecutar(new Campo(c));

        assertTrue(c.esta(aitsu));

    }


    public void testInsectoComeHombresDestruyeUnMonstruoEnElCampoAlPosicionarloBocaArriba(){

        Cementerio cementerioOponente = new Cementerio();

        Campo campoOponente = new Campo(cementerioOponente);

        EfectoDestruirMonstruo destruirMonstruo = new EfectoDestruirMonstruo(campoOponente);
        Monstruo insecto = new Monstruo(2,2, destruirMonstruo);
        CartaMonstruoComeHombres insectoComeHombres = new CartaMonstruoComeHombres(insecto, 5);

        Monstruo aitsu = new Monstruo(100, 100);
        CartaMonstruo mOponente = new CartaMonstruo(aitsu, 5);

        campoOponente.colocarCarta(mOponente);
        mOponente.colocarEnPosAtaque();
        insectoComeHombres.colocarBocaArriba(mOponente);


        assertTrue(cementerioOponente.esta(mOponente));

    }


}
