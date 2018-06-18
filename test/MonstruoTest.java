import junit.framework.TestCase;

public class MonstruoTest extends TestCase {

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYAitsuMuere(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertTrue(c.esta(aitsu));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAlasDeLaLlamaPerversaEnAtaqueYAlasDeLaLlamaPerversaMuere(){

        Monstruo alasDeLlamaPerversa = new Monstruo(700, 600, 2);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        alasDeLlamaPerversa.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(alasDeLlamaPerversa);
        b.ejecutar(c);

        assertTrue(c.esta(alasDeLlamaPerversa));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertTrue(c.esta(agujaAsesina));
    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYNingunoMuere(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        Botin b = aitsu.atacar(agujaAsesina);
        b.ejecutar(c);

        assertFalse(c.esta(aitsu));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuereAgresorOscuro(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Cementerio c = new Cementerio();
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.ejecutar(c);

        assertTrue(c.esta(agresorOscuro));
        assertFalse(c.esta(agujaAsesina));
    }

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYElBotinNoQuitaVida(){

        Monstruo agresorOscuro = new Monstruo(1200, 1200, 4);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 1000);
        Jugador atacado = new Jugador("", 1000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYElBotinQuita1100DeVidaAlAtacado(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }

    public void testPeleaAitsuEnDefensaContraAgujaAsesinaEnAtaqueYElBotinNoQuitaVida(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000);

    }

    public void testAitsuEnPosDefensaIntentaAtacarAAgujaAsesinaYSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        aitsu.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            aitsu.atacar(agujaAsesina);

        }catch(MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertTrue(lanzoError);

    }

    public void testAitsuEnPosAtaqueIntentaAtacarAAgujaAsesinaYNoSeLevantaUnaExcepcion(){

        Monstruo aitsu = new Monstruo(100, 100, 5);
        Monstruo agujaAsesina = new Monstruo(1200, 1000, 4);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();

        boolean lanzoError = false;

        try{

            aitsu.atacar(agujaAsesina);

        }catch(MonstruoNoPuedeAtacarError e){

            lanzoError = true;

        }

        assertFalse(lanzoError);

    }

}
