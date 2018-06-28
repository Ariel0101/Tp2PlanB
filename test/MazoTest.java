import Excepciones.NoHayCartasError;
import junit.framework.TestCase;

public class MazoTest extends TestCase {
    public void testMazoSacarLevantaErrorCuandoNoQuedanMasCartas(){
        Jugador unJugador = new Jugador("Jugador 1", 8000);
        Mazo unMazo = new Mazo(unJugador);
        boolean lanzoError = false;
        try {
            unMazo.sacar();
        } catch (NoHayCartasError e){
            lanzoError = true;
        }
        assertTrue(lanzoError);
    }

    public void testMazoCantidadEsCeroAlCrearse(){
        Jugador unJugador = new Jugador("Jugador 1", 8000);
        Mazo unMazo = new Mazo(unJugador);

        assertEquals(0, unMazo.cantidad());
    }

    public void testMazoCantidadEs4CuandoAgrego4Cartas(){
        Jugador unJugador = new Jugador("Jugador 1", 8000);
        Mazo unMazo = new Mazo(unJugador);
        CartaMonstruo cartaMonstruo = new CartaMonstruo(new Monstruo(1,1),2);
        CartaMagica cartaMagica = new CartaMagica(new MagiaNula());
        CartaTrampa cartaTrampa = new CartaTrampa(new TrampaNula());
        Cementerio c1 = new Cementerio();
        Cementerio c2 = new Cementerio();
        CartaDeCampo cartaDeCampo = new CartaDeCampo(new EfectoDeCampoNulo(new Campo(c1), new Campo(c2)));
        unMazo.agregar(cartaMonstruo);
        unMazo.agregar(cartaMagica);
        unMazo.agregar(cartaTrampa);
        unMazo.agregar(cartaDeCampo);

        assertEquals(4, unMazo.cantidad());
    }

    public void testMazoSacarUltimaCartaSeteaEnPartidaAlPerdedor(){
        String nombreJugador = "Jugador 1";
        Partida unaPartida = new Partida();
        Jugador unJugador = new Jugador(nombreJugador, 8000, unaPartida);
        Mazo unMazo = new Mazo(unJugador);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo(aitsu,4);
        unMazo.agregar(cartaAitsu);
        unMazo.sacar();

        assertEquals(nombreJugador, unaPartida.verPerdedor());

    }
}
