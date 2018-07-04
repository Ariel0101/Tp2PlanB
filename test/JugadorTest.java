import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Jugador.Jugador;
import junit.framework.TestCase;

public class JugadorTest extends TestCase {

	public void testVerVidaDeJugador () {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000, new Partida());
		assertEquals(jugadorUno.verVida(), 8000);
		
	}
	
	public void testJugadorRecibirDanioRestaDichoDanioASuVida() {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000, new Partida());
		jugadorUno.recibirDanio(7334);
		int resultadoEsperado = 8000-7334;
		
		assertEquals(jugadorUno.verVida(), resultadoEsperado);
		
	}

	public void testJugadorGanarSeSeteaComoGanadorEnPartida(){
	    Partida unaPartida = new Partida();
	    String nombre = "Modelo.Jugador.Jugador 1";
	    Jugador unJugador = new Jugador(nombre,8000, unaPartida);
	    unJugador.ganar();

	    assertEquals(nombre, unaPartida.verGanador());
    }

    public void testJugadorPerderSeSeteaComoPerdedorEnPartida(){
        Partida unaPartida = new Partida();
        String nombre = "Modelo.Jugador.Jugador 1";
        Jugador unJugador = new Jugador(nombre,8000, unaPartida);
        unJugador.perder();

        assertEquals(nombre, unaPartida.verPerdedor());
    }

    public void testJugadorToStringDevuelveElNombreConQueSeInicializo(){
	    String nombre = "nombre";
	    Jugador unJugador = new Jugador(nombre, 8000, new Partida());

	    assertEquals(nombre, unJugador.toString());
    }

    public void testJugadorPierdeCuandoSuVidaEsReducidaACero(){
	    Partida unaPartida = new Partida();
	    String nombreJugador = "nombre";
	    Jugador unJugador = new Jugador(nombreJugador, 100, unaPartida);

	    unJugador.recibirDanio(100);

	    assertEquals(nombreJugador, unaPartida.verPerdedor());
	}

    public void testJugadorPierdeCuandoSuVidaEsReducidaAUnValorNegativo(){
        Partida unaPartida = new Partida();
        String nombreJugador = "nombre";
        Jugador unJugador = new Jugador(nombreJugador, 100, unaPartida);

        unJugador.recibirDanio(101);

        assertEquals(nombreJugador, unaPartida.verPerdedor());
    }

    public void testJugadorRecibirAtaqueDeUnaCartaMonstruoRecibeTodosLosPuntosDeAtaqueDelMonstruoAtacante(){
        int vidaInicial = 8000;
        Jugador unJugador = new Jugador("j1", vidaInicial, new Partida());
        int danio = 300;
        CartaMonstruo mokeyMokey = new CartaMonstruo("", new Monstruo(danio, 100),3);
        mokeyMokey.colocarEnPosAtaque();
        mokeyMokey.colocarBocaArriba();
        Campo unCampo = new Campo(new Cementerio());

        unJugador.recibirAtaque(mokeyMokey, unCampo);

        assertEquals(vidaInicial-danio, unJugador.verVida());
    }

    public void testJugadorRecibirAtaqueDeCartaMonstruoConMayorAtaqueQueLaVidaDelJugadorLoHacePerder(){
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador("j1", 100, unaPartida);
        CartaMonstruo mokeyMokey = new CartaMonstruo("", new Monstruo(300, 100),3);
        mokeyMokey.colocarEnPosAtaque();
        mokeyMokey.colocarBocaArriba();
        Campo unCampo = new Campo(new Cementerio());

        unJugador.recibirAtaque(mokeyMokey, unCampo);

        assertEquals(unJugador.toString(), unaPartida.verPerdedor());
    }
}
