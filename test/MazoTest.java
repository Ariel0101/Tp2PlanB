import Controlador.Partida;
import Modelo.Campo.*;
import Modelo.Carta;
import Modelo.CartasMagiaTrampa.*;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Excepciones.NoHayCartasError;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import Modelo.Jugador.Mazo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazoTest {
    @Test
    public void testMazoSacarCartaLaSacaDelMazoYLaHaceColocarseEnManoRecibida(){
        Jugador unJugador = new Jugador("j1", 8000, new Partida());
        Mazo unMazo = new Mazo(unJugador);
        Mano unaMano = new Mano(unJugador);
        Carta unaCartaCualquiera = new CartaMonstruo("", new Monstruo(0,0),1);
        Carta otraCartaCualquiera = new CartaMonstruo("", new Monstruo(0,0),1);
        unMazo.agregar(unaCartaCualquiera);
        unMazo.agregar(otraCartaCualquiera);
        unMazo.sacar(unaMano);

        assertEquals(1, unMazo.cantidad());
        assertEquals(1, unaMano.contarCartas(unaCartaCualquiera.getClass()));
    }

    @Test(expected = NoHayCartasError.class)
    public void testMazoSacarLevantaErrorCuandoNoQuedanMasCartas(){
        Jugador unJugador = new Jugador("Jugador 1", 8000, new Partida());
        Mano unaMano = new Mano(unJugador);
        Mazo unMazo = new Mazo(unJugador);

        unMazo.sacar(unaMano);

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
        CartaMonstruo cartaMonstruo = new CartaMonstruo("", new Monstruo(1,1),2);
        CartaMagica cartaMagica = new CartaMagica("", new OllaDeLaCodicia(new Mano(unJugador), unMazo));
        CartaTrampa cartaTrampa = new CartaTrampa("", new TrampaNula());
        Cementerio c1 = new Cementerio();
        Cementerio c2 = new Cementerio();
        CartaDeCampo cartaDeCampo = new CartaDeCampo("", new EfectoSogen(new Campo(c1), new Campo(c2)));
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
        Mano unaMano = new Mano(unJugador);
        Mazo unMazo = new Mazo(unJugador);
        Monstruo aitsu = new Monstruo(100,100);
        CartaMonstruo cartaAitsu = new CartaMonstruo("", aitsu,4);
        unMazo.agregar(cartaAitsu);
        unMazo.sacar(unaMano);

        assertEquals(nombreJugador, unaPartida.verPerdedor());

    }


}
