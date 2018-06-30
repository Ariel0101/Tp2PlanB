import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMagiaTrampa.AgujeroOscuro;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Excepciones.MonstruoNoPuedeAtacarError;
import Modelo.Jugador.Jugador;
import junit.framework.TestCase;

public class EntregaUnoTest extends TestCase {

    public void testColocarUnMonstruoEnPosicionDeAtaque() throws MonstruoNoPuedeAtacarError {

        Monstruo ganador = new Monstruo(1001, 0);
        ganador.colocarEnPosAtaque();
        Monstruo perdedor = new Monstruo(1000, 0);
        perdedor.colocarEnPosAtaque();
        CartaMonstruo cGanador = new CartaMonstruo(ganador, 0);
        CartaMonstruo cPerdedor = new CartaMonstruo(perdedor, 0);

        Botin b = ganador.atacar(perdedor);
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        assertTrue(c.esta(cPerdedor));
        assertFalse(c.esta(cGanador));

    }

    public void testColocarUnMonstruoEnPosicionDeDefensa() throws MonstruoNoPuedeAtacarError{

        Monstruo ganador = new Monstruo(0, 1001);
        ganador.colocarEnPosDefensa();
        Monstruo perdedor = new Monstruo(1000, 0);
        perdedor.colocarEnPosAtaque();
        CartaMonstruo cGanador = new CartaMonstruo(ganador, 0);
        CartaMonstruo cPerdedor = new CartaMonstruo(perdedor, 0);

        Botin b = perdedor.atacar(ganador);
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        assertFalse(c.esta(cPerdedor));
        assertFalse(c.esta(cGanador));

    }

    public void testColocarMagicaBocaAbajoNoActivaNingunEfecto(){

        Cementerio cementerio = new Cementerio();
        Campo campo = new Campo(cementerio);
        AgujeroOscuro agujero = new AgujeroOscuro(campo, campo);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo m = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m, 4);

        agujeroOscuro.colocarBocaAbajo();
        campo.colocarCarta(agujeroOscuro);
        campo.colocarCarta(aitsu);

        assertFalse(cementerio.esta(aitsu));
    }

    public void testDestruirCartaMandaAlMonstruoAlCementerio(){

        Cementerio cementerio = new Cementerio();
        Monstruo m = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(m, 4);

        aitsu.destruir(cementerio);

        assertTrue(cementerio.esta(aitsu));

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnAtaqueDestruyoAAitsuYElJugadorSufreDanio() throws MonstruoNoPuedeAtacarError{

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosAtaque();
        aitsu.colocarBocaArriba();
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();
        Jugador jAitsu = new Jugador("", 10000, new Partida());
        Jugador jAgujero = new Jugador("", 10000, new Partida());

        Botin b = agujaAsesina.atacar(aitsu, new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000 - 1100);

    }

    public void testAgujaAsesinaEnAtaqueContraAgujaAsesinaEnAtaqueDestruyoAAmbosNadieSufrioDanio() throws MonstruoNoPuedeAtacarError{

        Monstruo ag1 = new Monstruo(1200, 1000);
        Monstruo ag2 = new Monstruo(1200, 1000);
        CartaMonstruo agujaAsesina1 = new CartaMonstruo(ag1, 4);
        CartaMonstruo agujaAsesina2 = new CartaMonstruo(ag2, 4);
        agujaAsesina1.colocarEnPosAtaque();
        agujaAsesina1.colocarBocaArriba();
        agujaAsesina2.colocarEnPosAtaque();
        agujaAsesina2.colocarBocaArriba();
        Jugador j1 = new Jugador("", 10000, new Partida());
        Jugador j2 = new Jugador("", 10000, new Partida());

        Botin b = agujaAsesina1.atacar(agujaAsesina2,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(j1, j2);

        assertTrue(c.esta(agujaAsesina1));
        assertTrue(c.esta(agujaAsesina2));
        assertEquals(j1.verVida(), 10000);
        assertEquals(j2.verVida(), 10000);

    }

    public void testAgujaAsesinaEnAtaqueContraAitsuEnDefensaDestruyoAAitsuYElJugadorNoSufreDanio() throws MonstruoNoPuedeAtacarError{

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosDefensa();
        aitsu.colocarBocaArriba();
        agujaAsesina.colocarEnPosAtaque();
        agujaAsesina.colocarBocaArriba();
        Jugador jAitsu = new Jugador("", 10000, new Partida());
        Jugador jAgujero = new Jugador("", 10000, new Partida());

        Botin b = agujaAsesina.atacar(aitsu,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertTrue(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testAitsuEnAtaqueContraAgujaAsesinaEnDefensaNoDestruyoAAitsuYElJugadorNoSufreDanio() throws MonstruoNoPuedeAtacarError{

        Monstruo ai = new Monstruo(100, 100);
        Monstruo ag = new Monstruo(1200, 1000);
        CartaMonstruo aitsu = new CartaMonstruo(ai, 5);
        CartaMonstruo agujaAsesina = new CartaMonstruo(ag, 4);
        aitsu.colocarEnPosAtaque();
        agujaAsesina.colocarEnPosDefensa();
        Jugador jAitsu = new Jugador("", 10000, new Partida());
        Jugador jAgujero = new Jugador("", 10000, new Partida());

        Botin b = aitsu.atacar(agujaAsesina,new Campo(new Cementerio()));
        Cementerio c = new Cementerio();
        b.ejecutar(new Campo(c));

        b.infligirDanios(jAgujero, jAitsu);

        assertFalse(c.esta(aitsu));
        assertEquals(jAitsu.verVida(), 10000);

    }

    public void testColocarAgujeroOscuroBocaArribaMataATodosLosMonstruosDeTodoElCampo(){

        Cementerio cementerio = new Cementerio();
        Campo campoUno = new Campo(cementerio);
        Campo campoDos = new Campo(cementerio);
        AgujeroOscuro agujero = new AgujeroOscuro(campoUno, campoDos);
        CartaMagica agujeroOscuro = new CartaMagica(agujero);
        Monstruo a = new Monstruo(100, 100);
        CartaMonstruo aitsu = new CartaMonstruo(a, 4);
        Monstruo m = new Monstruo(300,100);
        CartaMonstruo mokeyMokey = new CartaMonstruo(m,3);
        campoUno.colocarCarta(aitsu);
        campoDos.colocarCarta(mokeyMokey);
        campoUno.colocarCarta(agujeroOscuro);
        agujeroOscuro.colocarBocaArriba();

        assertTrue(cementerio.esta(aitsu));
        assertTrue(cementerio.esta(mokeyMokey));
        
    }
    
    public void testColocarMonstruoDe5EstrellasSacrificaAMonstruoEnCampo() throws MonstruoNoPuedeAtacarError {
    	
        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada = new CartaMonstruo(monstruoSacrificado, 4);
        Monstruo monstruo5Estrellas = new Monstruo(300, 100);
        CartaMonstruo carta5Estrellas = new CartaMonstruo(monstruo5Estrellas ,5);
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo(monstruoAtacado ,1);
        
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
    
    public void testColocarMonstruoDe7EstrellasSacrificaDosMonstruosEnCampo() throws MonstruoNoPuedeAtacarError {
    	
        Cementerio unCementerio = new Cementerio();
        Cementerio otroCementerio = new Cementerio();
        Campo unCampo = new Campo(unCementerio);
        Campo otroCampo = new Campo(otroCementerio);
        Monstruo monstruoSacrificado1 = new Monstruo(100, 100);
        CartaMonstruo cartaSacrificada1 = new CartaMonstruo(monstruoSacrificado1, 4);
        Monstruo monstruoSacrificado2 = new Monstruo(100, 50);
        CartaMonstruo cartaSacrificada2 = new CartaMonstruo(monstruoSacrificado2, 2);
        Monstruo monstruo7Estrellas = new Monstruo(300, 100);
        CartaMonstruo carta7Estrellas = new CartaMonstruo(monstruo7Estrellas, 7);
        Monstruo monstruoAtacado = new Monstruo(10, 10);
        CartaMonstruo cartaAtacada = new CartaMonstruo(monstruoAtacado ,1);
        
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
}
