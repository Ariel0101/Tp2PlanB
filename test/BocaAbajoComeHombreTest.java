import Controlador.ConstructorDeCartas;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaAbajoComeHombres;
import junit.framework.TestCase;

public class BocaAbajoComeHombreTest extends TestCase {
    public void testBocaAbajoComeHombresAtacarDevuelveBotinVacio(){
        Cementerio unCementerio = new Cementerio();
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso();
        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        mokeyMokey.colocarse(campoAmigo);
        goblinFalso.colocarse(campoEnemigo);
        Boca bocaAbajoComeHombres = new BocaAbajoComeHombres();

        Botin botinVacio = bocaAbajoComeHombres.atacar(mokeyMokey, goblinFalso, campoEnemigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertTrue(campoAmigo.esta(mokeyMokey));
        assertTrue(campoEnemigo.esta(goblinFalso));
    }

    public void testBocaAbajoComeHombresRecibirAtaqueDevuelveBotinVacio(){
        Cementerio unCementerio = new Cementerio();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblin = new CartaMonstruo(goblinFalso,3);

        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        cartaMokey.colocarse(campoAmigo);
        cartaGoblin.colocarse(campoEnemigo);
        Boca bocaAbajoComeHombres = new BocaAbajoComeHombres();

        Botin botinVacio = bocaAbajoComeHombres.recibirAtaque(cartaMokey, mokeyMokey,goblinFalso, campoAmigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertTrue(campoAmigo.esta(cartaMokey));
        assertTrue(campoEnemigo.esta(cartaGoblin));
    }

    public void testBocaAbajoComeHombresEstaBocaArribaDevuelveFalse(){
        Boca bocaAbajoComeHombres = new BocaAbajoComeHombres();

        assertFalse(bocaAbajoComeHombres.estaBocaArriba());
    }

    public void testBocaAbajoComeHombresEstaBocaAbajoDevuelveTrue() {
        Boca bocaAbajoComeHombres = new BocaAbajoComeHombres();

        assertTrue(bocaAbajoComeHombres.estaBocaAbajo());
    }
}
