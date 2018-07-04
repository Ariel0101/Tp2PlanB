import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.PosDefensa;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PosDefensaTest{

    @Test
    public void testPosDefensaObtenerPuntosDevuelveLaDefensaDelMonstruo() {

        PosDefensa posicionDefensa = new PosDefensa();

        assertEquals(posicionDefensa.obtenerPuntos(100, 1), 1);

    }

    @Test
    public void testPosDefensaDanioDePersonajeDevuelveCero(){

        PosDefensa posicionDefensa = new PosDefensa();

        assertEquals(posicionDefensa.danioDePersonaje(200), 0);

    }

    @Test
    public void testPosDefensaMatarAUnMonstruoNoLoAgregaAlBotinDeMuertos(){

        PosDefensa posicionDefensa = new PosDefensa();
        Cementerio cementerio = new Cementerio();
        Monstruo monstruo = new Monstruo(1,1);
        CartaMonstruo carta = new CartaMonstruo("", monstruo, 1);
        Botin unBotin = new Botin();

        posicionDefensa.matar(monstruo, unBotin);

        unBotin.ejecutar(new Campo(cementerio));

        assertFalse(cementerio.esta(carta));

    }

    @Test(expected = MonstruoNoPuedeAtacarError.class)
    public void testPosDefensaAtacarLanzaError(){

        PosDefensa posicionDefensa = new PosDefensa();

        posicionDefensa.atacar();

    }

    @Test
    public void testPosDefensaEnCaracteresDevuelveCadenaDefensa(){
        PosDefensa posicionDefensa = new PosDefensa();
        assertEquals("Defensa", posicionDefensa.enCaracteres());
    }

}