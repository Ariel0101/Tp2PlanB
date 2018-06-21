import junit.framework.TestCase;

public class MonstruoTest extends TestCase {

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYAitsuMuere() throws MonstruoNoPuedeAtacarError{

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

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnAtaqueYMuerenAmbos() throws MonstruoNoPuedeAtacarError{

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

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnDefensaYNingunoMuere() throws MonstruoNoPuedeAtacarError{

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

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYMuereAgresorOscuro() throws MonstruoNoPuedeAtacarError{

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

    public void testPeleaAgujaAsesinaEnAtaqueContraAgresorOscuroEnDefensaYElBotinNoQuitaVida() throws MonstruoNoPuedeAtacarError{

        Monstruo agresorOscuro = new Monstruo(1200, 1200);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Jugador atacante = new Jugador("", 1000);
        Jugador atacado = new Jugador("", 1000);
        agresorOscuro.colocarEnPosDefensa();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(agresorOscuro);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 1000);
        assertEquals(atacado.verVida(), 1000);

    }

    public void testPeleaAitsuEnAtaqueContraAgujaAsesinaEnAtaqueYElBotinQuita1100DeVidaAlAtacado() throws MonstruoNoPuedeAtacarError{

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
        Jugador atacante = new Jugador("", 10000);
        Jugador atacado = new Jugador("", 10000);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosAtaque();

        Botin b = agujaAsesina.atacar(aitsu);
        b.infligirDanios(atacante, atacado);

        assertEquals(atacante.verVida(), 10000);
        assertEquals(atacado.verVida(), 10000 - 1100);

    }

    public void testPeleaAitsuEnDefensaContraAgujaAsesinaEnAtaqueYElBotinNoQuitaVida() throws MonstruoNoPuedeAtacarError{

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
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

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
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

        Monstruo aitsu = new Monstruo(100, 100);
        Monstruo agujaAsesina = new Monstruo(1200, 1000);
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
