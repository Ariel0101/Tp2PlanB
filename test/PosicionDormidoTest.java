import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.PosDormido;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PosicionDormidoTest {

    @Test(expected = MonstruoNoPuedeAtacarError.class)
    public void testPosDormidoObtenerPuntosLanzaError() {
        PosDormido posicionDormido = new PosDormido();

        posicionDormido.obtenerPuntos(100,100);

    }


    @Test
    public void testPosDefensaDanioDePersonajeDevuelveCero(){

        PosDormido posicionDormido = new PosDormido();

        assertEquals(posicionDormido.danioDePersonaje(200), 0);

    }

    @Test(expected = MonstruoNoPuedeAtacarError.class)
    public void testPosDormidoMatarLanzaError(){

        PosDormido posicionDormido = new PosDormido();
        Botin unBotin = new Botin();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);

        posicionDormido.matar(mokeyMokey, unBotin);
    }


    @Test(expected = MonstruoNoPuedeAtacarError.class)
    public void testPosDormidoAtacarLanzaError(){
        PosDormido posicionDormido = new PosDormido();

        posicionDormido.atacar();

    }

    @Test
    public void testPosDefensaEnCaracteresDevuelveCadenaDefensa(){
        PosDormido posicionDormido = new PosDormido();
        assertEquals("Dormido", posicionDormido.enCaracteres());
    }

}
