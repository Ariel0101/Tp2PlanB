import junit.framework.TestCase;

public class PosDefensaTest extends TestCase {

    public void testPosDefensaObtenerPuntosDevuelveLaDefensaDelMonstruo() {

        PosDefensa d = new PosDefensa();

        assertEquals(d.obtenerPuntos(100, 1), 1);

    }

    public void testPosDefensaDanioDePersonajeDevuelveCero(){

        PosDefensa p = new PosDefensa();

        assertEquals(p.danioDePersonaje(200), 0);

    }

    public void testPosDefensaMatarAUnMonstruoNoLoAgregaAlBotinDeMuertos(){

        PosDefensa p = new PosDefensa();
        Cementerio c = new Cementerio();
        Monstruo m = new Monstruo(1,1);
        CartaMonstruo carta = new CartaMonstruo(m, 1);
        Botin b = new Botin();

        p.matar(m, b);

        b.ejecutar(new Campo(c));

        assertFalse(c.esta(carta));

    }

    public void testPosDefensaAtacarLanzaError(){

        PosDefensa p = new PosDefensa();
        boolean lanzoError = false;

        try{

            p.atacar();

        }catch(MonstruoNoPuedeAtacarError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }

}