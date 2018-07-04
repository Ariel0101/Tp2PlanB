import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.CartaMonstruoDragon;
import Modelo.CartasMonstruo.CartaMonstruoDragonDefinitivo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.NoHaySufucienteSacrificiosError;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SacrificiosTest  {

    @Test
    public void testColocarMonstruoDe5EstrellasSacrificaAMonstruoEnCampo() {

        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada = new CartaMonstruo("", monstruoSacrificado, 4);
        Monstruo monstruo5Estrellas = new Monstruo(300, 100);
        CartaMonstruo carta5Estrellas = new CartaMonstruo("", monstruo5Estrellas ,5);
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo("", monstruoAtacado ,1);

        unCampo.colocarCarta(cartaSacrificada);
        unCampo.colocarCarta(carta5Estrellas);
        carta5Estrellas.colocarBocaArriba();
        carta5Estrellas.colocarEnPosAtaque();
        otroCampo.colocarCarta(cartaAtacada);
        cartaAtacada.colocarBocaArriba();
        cartaAtacada.colocarEnPosAtaque();
        Botin b = carta5Estrellas.atacar(cartaAtacada, otroCampo);
        b.ejecutar(otroCampo);

        assertTrue(unCementerio.esta(cartaSacrificada));
        assertTrue(otroCementerio.esta(cartaAtacada));
    }

    @Test
    public void testColocarMonstruoDe7EstrellasSacrificaDosMonstruosEnCampo() {

        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado1 = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada1 = new CartaMonstruo("", monstruoSacrificado1, 4);
        Monstruo monstruoSacrificado2 = new Monstruo(100, 50);
        CartaMonstruo cartaSacrificada2 = new CartaMonstruo("", monstruoSacrificado2, 2);
        Monstruo monstruo7Estrellas = new Monstruo(300, 100);
        CartaMonstruo carta7Estrellas = new CartaMonstruo("", monstruo7Estrellas, 7);
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo("", monstruoAtacado ,1);

        unCampo.colocarCarta(cartaSacrificada1);
        unCampo.colocarCarta(cartaSacrificada2);
        unCampo.colocarCarta(carta7Estrellas);
        carta7Estrellas.colocarBocaArriba();
        carta7Estrellas.colocarEnPosAtaque();
        otroCampo.colocarCarta(cartaAtacada);
        cartaAtacada.colocarBocaArriba();
        cartaAtacada.colocarEnPosAtaque();
        Botin b = carta7Estrellas.atacar(cartaAtacada, otroCampo);
        b.ejecutar(otroCampo);

        assertTrue(unCementerio.esta(cartaSacrificada1));
        assertTrue(unCementerio.esta(cartaSacrificada2));
        assertTrue(otroCementerio.esta(cartaAtacada));
    }

    @Test(expected = NoHaySufucienteSacrificiosError.class)
    public void testColocarMonstruoLevantaNoHaySuficientesSacrificiosErrorCuandoNoHaySuficientesMonstruosEnElCampoParaInvoacionPedida(){
        Cementerio unCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);

        Monstruo monstruo7Estrellas = new Monstruo(300, 100);
        CartaMonstruo carta7Estrellas = new CartaMonstruo("", monstruo7Estrellas, 7);

        carta7Estrellas.colocarse(unCampo);

        assertFalse(unCampo.esta(carta7Estrellas));
    }

    @Test
    public  void testInvocar3DragonesBlancosDeOjosAzulesYAlDragonDefinitivoSacrificaLosTresDragones() {
        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado1 = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada1 = new CartaMonstruo("", monstruoSacrificado1, 4);
        Monstruo monstruoSacrificado2 = new Monstruo(100, 50);
        CartaMonstruo cartaSacrificada2 = new CartaMonstruo("", monstruoSacrificado2, 3);
        Monstruo monstruoSacrificado3 = new Monstruo(100, 8);
        CartaMonstruo cartaSacrificada3 = new CartaMonstruo("", monstruoSacrificado3, 4);
        Monstruo monstruoSacrificado4 = new Monstruo(100, 6);
        CartaMonstruo cartaSacrificada4 = new CartaMonstruo("", monstruoSacrificado4, 1);
        Monstruo monstruoSacrificado5 = new Monstruo(100, 77);
        CartaMonstruo cartaSacrificada5 = new CartaMonstruo("", monstruoSacrificado5, 2);
        Monstruo monstruoSacrificado6 = new Monstruo(100, 33);
        CartaMonstruo cartaSacrificada6 = new CartaMonstruo("", monstruoSacrificado6, 1);

        CartaMonstruo cartaDragon1 = new CartaMonstruoDragon("Dragon De Ojos Azules");
        CartaMonstruo cartaDragon2 = new CartaMonstruoDragon("Dragon De Ojos Azules");
        CartaMonstruo cartaDragon3 = new CartaMonstruoDragon("Dragon De Ojos Azules");
        CartaMonstruoDragonDefinitivo cartaDragonDefinitivo = new CartaMonstruoDragonDefinitivo("Dragon Definitivo");
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo("", monstruoAtacado ,1);

        unCampo.colocarCarta(cartaSacrificada1);
        unCampo.colocarCarta(cartaSacrificada2);
        unCampo.colocarCarta(cartaSacrificada3);
        unCampo.colocarCarta(cartaSacrificada4);
        unCampo.colocarCarta(cartaSacrificada5);
        unCampo.colocarCarta(cartaSacrificada6);
        unCampo.colocarCarta(cartaDragon1);
        unCampo.colocarCarta(cartaDragon2);
        unCampo.colocarCarta(cartaDragon3);
        unCampo.colocarCarta(cartaDragonDefinitivo);

        cartaDragonDefinitivo.colocarBocaArriba();
        cartaDragonDefinitivo.colocarEnPosAtaque();
        otroCampo.colocarCarta(cartaAtacada);
        cartaAtacada.colocarBocaArriba();
        cartaAtacada.colocarEnPosAtaque();
        Botin b = cartaDragonDefinitivo.atacar(cartaAtacada, otroCampo);
        b.ejecutar(otroCampo);

        assertTrue(unCementerio.esta(cartaSacrificada1));
        assertTrue(unCementerio.esta(cartaSacrificada2));
        assertTrue(unCementerio.esta(cartaSacrificada3));
        assertTrue(unCementerio.esta(cartaSacrificada4));
        assertTrue(unCementerio.esta(cartaSacrificada5));
        assertTrue(unCementerio.esta(cartaSacrificada6));
        assertTrue(unCementerio.esta(cartaDragon1));
        assertTrue(unCementerio.esta(cartaDragon2));
        assertTrue(unCementerio.esta(cartaDragon3));
        assertTrue(otroCementerio.esta(cartaAtacada));
    }

    @Test(expected = NoHaySufucienteSacrificiosError.class)
    public void testInvocar3DragonesBlancosDeOjosAzulesYAlDragonDefinitivoLevantaErrorNohaySufucienteSacrificiosErrorCuandoNoHaySuficientesDragonesBlancosDeOjosAzulesEnJuego(){
        Cementerio unCementerio = new Cementerio();

        Campo unCampo = new Campo(unCementerio);
        Monstruo monstruoSacrificado1 = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada1 = new CartaMonstruo("", monstruoSacrificado1, 4);
        Monstruo monstruoSacrificado2 = new Monstruo(100, 50);
        CartaMonstruo cartaSacrificada2 = new CartaMonstruo("", monstruoSacrificado2, 3);
        CartaMonstruo cartaDragon1 = new CartaMonstruoDragon("Dragon De Ojos Azules");
        CartaMonstruoDragonDefinitivo cartaDragonDefinitivo = new CartaMonstruoDragonDefinitivo("Dragon Definitivo");

        cartaSacrificada1.colocarse(unCampo);
        cartaSacrificada2.colocarse(unCampo);
        cartaDragon1.colocarse(unCampo);

        unCampo.colocarCarta(cartaDragonDefinitivo);

        assertFalse(unCampo.esta(cartaDragonDefinitivo));



    }
}

