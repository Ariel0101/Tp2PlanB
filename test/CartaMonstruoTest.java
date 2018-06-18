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


    public void testInsectoComeHombresDestruyeUnMonstruoEnElCampoAlPosicionarloBocaArriba(){

        Cementerio cementerioOponente = new Cementerio();

        Campo campoOponente = new Campo(cementerioOponente);

        Efecto destruirMonstruo = new EfectoDestruirMonstruo(campoOponente);
        Monstruo insecto = new Monstruo(2,2,2, destruirMonstruo);
        CartaMonstruo ins = new CartaMonstruo(insecto);
        MonstruoComeHombres insectoComeHombres = new MonstruoComeHombres(ins);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruo mOponente = new CartaMonstruo(aitsu);

        campoOponente.colocarCarta(mOponente);
        mOponente.colocarEnPosAtaque();
        insectoComeHombres.colocarBocaArriba(mOponente);


        assertTrue(cementerioOponente.esta(mOponente));


    }


}
