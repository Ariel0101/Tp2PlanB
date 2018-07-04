import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.PosAtaque;
import junit.framework.TestCase;

public class PosAtaqueTest extends TestCase {

    public void testPosAtaqueObtenerPuntosDevuelveElAtaqueDelMonstruo() {

        PosAtaque posicionAtaque = new PosAtaque();

        assertEquals(posicionAtaque.obtenerPuntos(100, 1), 100);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPelea(){

        PosAtaque posicionAtaque = new PosAtaque();

        assertEquals(posicionAtaque.danioDePersonaje(200), 200);

    }

    public void testPosAtaqueDanioDePersonajeDevuelveElResultadoDeLaPeleaEnModulo(){

        PosAtaque posicionAtaque = new PosAtaque();

        assertEquals(posicionAtaque.danioDePersonaje(-200), 200);

    }

    public void testPosAtaqueMatarAUnMonstruoLoAgregaAlBotinDeMuertos(){

        PosAtaque posicionAtaque = new PosAtaque();
        Cementerio cementerio = new Cementerio();
        Monstruo monstruo = new Monstruo(1,1);
        CartaMonstruo carta = new CartaMonstruo(monstruo, 1);
        Botin unBotin = new Botin();

        posicionAtaque.matar(monstruo, unBotin);

        unBotin.ejecutar(new Campo(cementerio));

        assertTrue(cementerio.esta(carta));

    }

    public void testPosAtaqueEnCaracteresDevuelveCadenaAtaque(){
        PosAtaque posicionAtaque = new PosAtaque();
        assertEquals("Ataque", posicionAtaque.enCaracteres());
    }

}