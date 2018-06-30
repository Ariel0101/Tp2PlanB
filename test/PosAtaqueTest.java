import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.PosAtaque;
import junit.framework.TestCase;

public class PosAtaqueTest extends TestCase {

    public void testPosAtaqueObtenerPuntosDevuelveElAtaqueDelMonstruo() {

        PosAtaque d = new PosAtaque();

        assertEquals(d.obtenerPuntos(100, 1), 100);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPelea(){

        PosAtaque p = new PosAtaque();

        assertEquals(p.danioDePersonaje(200), 200);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPeleaEnModulo(){

        PosAtaque p = new PosAtaque();

        assertEquals(p.danioDePersonaje(-200), 200);

    }

    public void testPosAtaqueMatarAUnMonstruoLoAgregaAlBotinDeMuertos(){

        PosAtaque p = new PosAtaque();
        Cementerio c = new Cementerio();
        Monstruo m = new Monstruo(1,1);
        CartaMonstruo carta = new CartaMonstruo(m, 1);
        Botin b = new Botin();

        p.matar(m, b);

        b.ejecutar(new Campo(c));

        assertTrue(c.esta(carta));

    }

   /* public void testPosAtaqueAtacarNoLanzaError(){

        Modelo.Estados.PosAtaque p = new Modelo.Estados.PosAtaque();
        boolean lanzoError = false;

        try{

            p.atacar();

        }catch(MonstruoNoPuedeAtacarError e ){

            lanzoError = true;

        }

        assertFalse(lanzoError);
    }
*/
}