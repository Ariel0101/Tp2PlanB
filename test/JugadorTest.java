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
}
