import junit.framework.TestCase;

public class JugadorTest extends TestCase {

	public void testVerVidaDeJugador () {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000);		
		assertEquals(jugadorUno.verVida(), 8000);
		
	}
	
	public void testJugadorRecibeAtaqueYSeLeRestaLaVidaCorrecta () {
		
		Jugador jugadorUno = new Jugador("nombreJugador", 8000);		
		jugadorUno.recibirAtaque(7334);
		int resultadoEsperado = 8000-7334;
		
		assertEquals(jugadorUno.verVida(), resultadoEsperado);
		
	}

	public void testJugadorGanarSeSeteaComoGanadorEnPartida(){
	    Partida unaPartida = new Partida();
	    String nombre = "Jugador 1";
	    Jugador unJugador = new Jugador(nombre,8000, unaPartida);
	    unJugador.ganar();

	    assertEquals(nombre, unaPartida.verGanador());
    }

    public void testJugadorPederSeSeteaComoPerdedorEnPartida(){
        Partida unaPartida = new Partida();
        String nombre = "Jugador 1";
        Jugador unJugador = new Jugador(nombre,8000, unaPartida);
        unJugador.perder();

        assertEquals(nombre, unaPartida.verPerdedor());
    }
}
