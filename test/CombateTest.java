import Controlador.ConstructorDeCartas;
import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Combate;
import Modelo.Jugador.Jugador;
import junit.framework.TestCase;

public class CombateTest extends TestCase {
    public void testCombateDestruyeMokeyMokeyYResta100AJugadorOponenteTrasCombatirAtacanteGoblinFalsoYAtacadoMokeyMokey(){
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Cementerio unCementerio = new Cementerio();
        Jugador miJugador = new Jugador("1", 8000, new Partida());
        Campo miCampo = new Campo(unCementerio);
        Jugador jugadorOponente = new Jugador("2", 8000, new Partida());
        Campo campoOponete = new Campo(unCementerio);

        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso(); //daño: 400, defensa: 400
        goblinFalso.colocarEnPosAtaque();
        goblinFalso.colocarBocaArriba();
        goblinFalso.colocarse(miCampo);

        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey(); //daño: 300, defensa: 100
        mokeyMokey.colocarEnPosAtaque();
        mokeyMokey.colocarBocaArriba();
        mokeyMokey.colocarse(campoOponete);

        Combate unCombate = new Combate(miJugador,miCampo, jugadorOponente, campoOponete);

        unCombate.combatir(goblinFalso, mokeyMokey);

        assertTrue(unCementerio.esta(mokeyMokey));
        assertFalse(unCementerio.esta(goblinFalso));
        assertEquals(8000, miJugador.verVida());
        assertEquals(8000-100, jugadorOponente.verVida());
    }

}
