import Excepciones.MonstruoNoPuedeAtacarError;
import junit.framework.TestCase;

public class PosicionDormidoTest extends TestCase {
    public void testPosDormidoObtenerPuntosLanzaError() {

        PosDormido p = new PosDormido();
        boolean lanzoError = false;

        try{

            p.obtenerPuntos(100,100);

        }catch(MonstruoNoPuedeAtacarError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }



    public void testPosDefensaDanioDePersonajeDevuelveCero(){

        PosDormido p = new PosDormido();

        assertEquals(p.danioDePersonaje(200), 0);

    }

    public void testPosDormidoMatarLanzaError(){

        PosDormido p = new PosDormido();
        Botin unBotin = new Botin();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        boolean lanzoError = false;

        try{

            p.matar(mokeyMokey,unBotin);

        }catch(MonstruoNoPuedeAtacarError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }



    public void testPosDormidoAtacarLanzaError(){

        PosDormido p = new PosDormido();
        boolean lanzoError = false;

        try{

            p.atacar();

        }catch(MonstruoNoPuedeAtacarError e ){

            lanzoError = true;

        }

        assertTrue(lanzoError);
    }

}
