import junit.framework.TestCase;

public class CombateTest extends TestCase {
    public void testCombateDestruyeMokeyMokeyYResta100AJugadorOponenteTrasCombatirAtacanteGoblinFalsoYAtacadoMokeyMokey(){
        Cementerio unCementerio = new Cementerio();
        Jugador miJugador = new Jugador("1", 8000);
        Campo miCampo = new Campo(unCementerio);
        Jugador jugadorOponente = new Jugador("2", 8000);
        Campo campoOponete = new Campo(unCementerio);

        Monstruo gf = new Monstruo(400, 400);
        CartaMonstruo goblinFalso = new CartaMonstruo(gf, 1);
        goblinFalso.colocarEnPosAtaque();
        goblinFalso.colocarBocaArriba();
        goblinFalso.colocarse(miCampo);

        Monstruo mk = new Monstruo(300, 100);
        CartaMonstruo mokeyMokey = new CartaMonstruo(mk, 3);
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

    public void testCombateLevantaErrorCuandoCartaMonstruoAtacanteNoPerteneceAlCampoAtacante(){
        Cementerio unCementerio = new Cementerio();
        Jugador miJugador = new Jugador("1", 8000);
        Campo miCampo = new Campo(unCementerio);
        Jugador jugadorOponente = new Jugador("2", 8000);
        Campo campoOponete = new Campo(unCementerio);

        Monstruo mk = new Monstruo(300, 100);
        CartaMonstruo mokeyMokey = new CartaMonstruo(mk, 3);
        mokeyMokey.colocarEnPosAtaque();
        mokeyMokey.colocarBocaArriba();
        mokeyMokey.colocarse(campoOponete);

        Combate unCombate = new Combate(miJugador,miCampo, jugadorOponente, campoOponete);

        boolean lanzoError = false;
        try {
            unCombate.combatir(mokeyMokey, mokeyMokey);
        } catch (MonstruoAtacanteNoPertenceACampoAtacanteError e){
            lanzoError = true;
        }

        assertTrue(lanzoError);
    }

    public void testCombateLevantaErrorCuandoCartaMonstruoAtacadoNoPerteneceAlCampoAtacado(){
        Cementerio unCementerio = new Cementerio();
        Jugador miJugador = new Jugador("1", 8000);
        Campo miCampo = new Campo(unCementerio);
        Jugador jugadorOponente = new Jugador("2", 8000);
        Campo campoOponete = new Campo(unCementerio);

        Monstruo gf = new Monstruo(400, 400);
        CartaMonstruo goblinFalso = new CartaMonstruo(gf, 1);
        goblinFalso.colocarEnPosAtaque();
        goblinFalso.colocarBocaArriba();
        goblinFalso.colocarse(miCampo);

        Combate unCombate = new Combate(miJugador,miCampo, jugadorOponente, campoOponete);

        boolean lanzoError = false;

        try {
            unCombate.combatir(goblinFalso, goblinFalso);
        } catch (MonstruoAtacanteNoPertenceACampoAtacadoError e){
            lanzoError = true;
        }

        assertTrue(lanzoError);
    }
}
