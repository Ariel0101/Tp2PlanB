import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.CartaDeCampo;
import Modelo.Campo.Cementerio;
import Modelo.Campo.EfectoDeCampoNulo;
import Modelo.CartasMagiaTrampa.CartaMagica;
import Modelo.CartasMagiaTrampa.CartaTrampa;
import Modelo.CartasMagiaTrampa.MagiaNula;
import Modelo.CartasMagiaTrampa.TrampaNula;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Excepciones.NoHayCartasError;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mazo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazoTest {
    @Test(expected = NoHayCartasError.class)
    public void testMazoSacarLevantaErrorCuandoNoQuedanMasCartas(){
        Jugador unJugador = new Jugador("Jugador 1", 8000, new Partida());
        Mazo unMazo = new Mazo(unJugador);

        unMazo.sacar();

    }
    @Test
    public void testMazoCantidadEsCeroAlCrearse(){
        Jugador unJugador = new Jugador("Jugador 1", 8000, new Partida());
        Mazo unMazo = new Mazo(unJugador);

        assertEquals(0, unMazo.cantidad());
    }
    @Test
    public void testMazoCantidadEs4CuandoAgrego4Cartas(){
        Jugador unJugador = new Jugador("Jugador 1", 8000, new Partida());
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
    @Test
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
