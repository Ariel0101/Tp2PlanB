import junit.framework.TestCase;

public class CartaMonstruoSimpleTest extends TestCase {

    public void testCartaConMosntruoAitsuNoAtacaSiEstaBocaAbajo(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruoSimple cAitsu = new CartaMonstruoSimple(aitsu);
        cAitsu.colocarEnPosAtaque();
        cAitsu.colocarBocaAbajo();

        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        CartaMonstruoSimple cAguja = new CartaMonstruoSimple(agujaAsesina);
        cAguja.colocarEnPosAtaque();
        cAguja.colocarBocaArriba();

        Botin b = new Botin();//cAitsu.atacar(cAguja);
        Cementerio c = new Cementerio();

        b.ejecutar(c);

        assertFalse(c.esta(aitsu));

    }

    public void testCartaConMosntruoAitsuAtacaSiEstaBocaArriba(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruoSimple cAitsu = new CartaMonstruoSimple(aitsu);
        cAitsu.colocarEnPosAtaque();
        cAitsu.colocarBocaArriba();

        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        CartaMonstruoSimple cAguja = new CartaMonstruoSimple(agujaAsesina);
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
        CartaMonstruoSimple ins = new CartaMonstruoSimple(insecto);
        MonstruoComeHombres insectoComeHombres = new MonstruoComeHombres(ins);

        Monstruo aitsu = new Monstruo(100, 100, 5);
        CartaMonstruoSimple mOponente = new CartaMonstruoSimple(aitsu);

        campoOponente.colocarCarta(mOponente);
        mOponente.colocarEnPosAtaque();
        insectoComeHombres.colocarBocaArriba(mOponente);


        assertTrue(cementerioOponente.esta(mOponente));

    }

    public void testMonstruoConSeisEstrellasSacrificaUnMonstruoDelCampoAlColocarse(){

        Cementerio cementerio = new Cementerio();
        Campo campo = new Campo(cementerio);

        Monstruo aitsu = new Monstruo(100, 100, 2);
        CartaMonstruoSimple otroMonstruo = new CartaMonstruoSimple(aitsu);

        Monstruo monstruo = new Monstruo(1, 1, 6);
        CartaMonstruoSimple carta = new CartaMonstruoSimple(monstruo);
        MonstruoConSacrificio cartaConSacrificio = new MonstruoConSacrificio(carta);

        campo.colocarCarta(otroMonstruo);
        campo.colocarCarta(cartaConSacrificio);

        assertTrue(cementerio.esta(otroMonstruo));

    }


}
