import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Jugador.Jugador;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MonstruoTest{

    @Test
    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYAitsuMuere() throws MonstruoNoPuedeAtacarError {

        Monstruo a = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(a, 5);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = a.atacar(agujaAsesina);
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(aitsu));
    }

    @Test
    public void testPeleaAgujaAsesinaEnAtaqueContraAlasDeLaLlamaPerversaEnAtaqueYAlasDeLaLlamaPerversaMuere() throws MonstruoNoPuedeAtacarError{

        Monstruo a = new Monstruo(700, 600);
        CartaMonstruo alasDeLlamaPerversa = new CartaMonstruo(a, 2);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Cementerio c = new Cementerio();
        alasDeLlamaPerversa.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(a);
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(alasDeLlamaPerversa));
    }

    @Test
    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos() {

        Monstruo agresorOscuro = new Monstruo(1200, 1200);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        CartaMonstruo cartaAgresor = new CartaMonstruo(agresorOscuro, 4);
        CartaMonstruo cartaAguja = new CartaMonstruo(agujaAsesina, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(cartaAgresor));
        assertTrue(c.esta(cartaAguja));
    }

    @Test
    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYNingunoMuere() {

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        CartaMonstruo cAitsu = new CartaMonstruo(aitsu, 5);
        CartaMonstruo cAguja = new CartaMonstruo(agujaAsesina, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(new Campo(c));

        assertFalse(c.esta(cAitsu));
        assertFalse(c.esta(cAguja));
    }

    @Test
    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuereAgresorOscuro() {

        Monstruo agresorOscuro = new Monstruo(1200, 1200);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        CartaMonstruo cAgresor = new CartaMonstruo(agresorOscuro, 5);
        CartaMonstruo cAguja = new CartaMonstruo(agujaAsesina, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(cAgresor));
        assertFalse(c.esta(cAguja));
    }

    @Test
    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYElBotinNoQuitaVida() {

        Monstruo agresorOscuro = new Monstruo(1200, 1200);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Jugador atacante = new Jugador("", 1000, new Partida());
        Jugador atacado = new Jugador("", 1000, new Partida());
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    @Test
    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYElBotinQuita1100DeVidaAlAtacado() {

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Jugador atacante = new Jugador("", 10000, new Partida());
        Jugador atacado = new Jugador("", 10000, new Partida());
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }
    @Test
    public void testPeleaAitsuEnDefensaContraAgujaAsesinaEnAtaqueYElBotinNoQuitaVida() {

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Jugador atacante = new Jugador("", 10000, new Partida());
        Jugador atacado = new Jugador("", 10000, new Partida());
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000);

    }
    @Test(expected = MonstruoNoPuedeAtacarError.class)
    public void testAitsuEnPosDefensaIntentaAtacarAAgujaAsesinaYSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        aitsu.colocarEnPosDefensa();

        aitsu.atacar(agujaAsesina);

    }
    @Test
    public void testAitsuEnPosAtaqueIntentaAtacarAAgujaAsesinaYNoSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();
        boolean lanzoError = false;
        try{
            aitsu.atacar(agujaAsesina);
        } catch (MonstruoNoPuedeAtacarError e){
            lanzoError = true;
        }
        assertFalse(lanzoError);

    }
}