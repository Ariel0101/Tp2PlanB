import Controlador.ConstructorDeCartas;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaAbajo;
import junit.framework.TestCase;

public class BocaAbajoTest extends TestCase {
    public void testBocaAbajoAtacarDevuelveBotinVacio(){
        Cementerio unCementerio = new Cementerio();
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso();
        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        mokeyMokey.colocarse(campoAmigo);
        goblinFalso.colocarse(campoEnemigo);
        Boca bocaAbajo = new BocaAbajo();

        Botin botinVacio = bocaAbajo.atacar(mokeyMokey, goblinFalso, campoEnemigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertTrue(campoAmigo.esta(mokeyMokey));
        assertTrue(campoEnemigo.esta(goblinFalso));
    }

    public void testBocaAbajoRecibirAtaqueDevuelveBotinConResultadoDeLaBatalla(){
        Cementerio unCementerio = new Cementerio();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo("", mokeyMokey,3);
        cartaMokey.colocarEnPosAtaque();

        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblin = new CartaMonstruo("", goblinFalso,3);
        cartaGoblin.colocarEnPosAtaque();

        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        cartaMokey.colocarse(campoAmigo);
        cartaGoblin.colocarse(campoEnemigo);
        Boca bocaAbajo = new BocaAbajo();

        Botin botinVacio = bocaAbajo.recibirAtaque(cartaMokey, mokeyMokey,goblinFalso, campoAmigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertFalse(campoAmigo.esta(cartaMokey));
        assertTrue(unCementerio.esta(cartaMokey));
        assertTrue(campoEnemigo.esta(cartaGoblin));
    }

    public void testBocaAbajoEstaBocaArribaDevuelveFalse(){
        Boca bocaAbajo = new BocaAbajo();

        assertFalse(bocaAbajo.estaBocaArriba());
    }

    public void testBocaAbajoEstaBocaAbajoDevuelveTrue(){
        Boca bocaAbajo = new BocaAbajo();


        assertTrue(bocaAbajo.estaBocaAbajo());
    }

    public void testBocaAbajoVerNombreDevuelveUnSignoDePreguntaTrasRecibirOtraCadena(){
        Boca bocaAbajo = new BocaAbajo();
        String unNombre = "nombre";
        String res = bocaAbajo.verNombre(unNombre);

        assertEquals("?", res);
    }

}
