import Controlador.ConstructorDeCartas;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.Combate.Botin;
import Modelo.Estados.Boca;
import Modelo.Estados.BocaArriba;
import Modelo.Estados.BocaNeutra;
import junit.framework.TestCase;

public class BocaNeutraTest extends TestCase {
    public void testBocaNeutraAtacarDevuelveBotinVacio(){
        Cementerio unCementerio = new Cementerio();
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        CartaMonstruo goblinFalso = constructorDeCartas.goblinFalso();
        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        mokeyMokey.colocarse(campoAmigo);
        goblinFalso.colocarse(campoEnemigo);
        Boca bocaNeutra = new BocaNeutra();

        Botin botinVacio = bocaNeutra.atacar(mokeyMokey, goblinFalso, campoEnemigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertTrue(campoAmigo.esta(mokeyMokey));
        assertTrue(campoEnemigo.esta(goblinFalso));
    }

    public void testBocaNeutraRecibirAtaqueDevuelveBotinVacio(){
        Cementerio unCementerio = new Cementerio();
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        Monstruo mokeyMokey = new Monstruo(300,100);
        CartaMonstruo cartaMokey = new CartaMonstruo(mokeyMokey,3);
        Monstruo goblinFalso = new Monstruo(400,400);
        CartaMonstruo cartaGoblin = new CartaMonstruo(goblinFalso,3);

        Campo campoEnemigo = new Campo(unCementerio);
        Campo campoAmigo = new Campo(unCementerio);
        cartaMokey.colocarse(campoAmigo);
        cartaGoblin.colocarse(campoEnemigo);
        Boca bocaNeutra = new BocaNeutra();

        Botin botinVacio = bocaNeutra.recibirAtaque(cartaMokey, mokeyMokey,goblinFalso, campoAmigo);

        botinVacio.ejecutar(campoAmigo);
        botinVacio.ejecutar(campoEnemigo);

        assertTrue(campoAmigo.esta(cartaMokey));
        assertTrue(campoEnemigo.esta(cartaGoblin));
    }

    public void testBocaNeutraEstaBocaArribaDevuelveFalse(){
        Boca bocaNeutra = new BocaNeutra();

        assertFalse(bocaNeutra.estaBocaArriba());
    }

    public void testBocaNeutraEstaBocaAbajoDevuelveFalse(){
        Boca bocaNeutra = new BocaNeutra();

        assertFalse(bocaNeutra.estaBocaAbajo());
    }

    public void testBocaNeutraVerNombreDevuelveUnSignoDePreguntaTrasRecibirOtraCadena(){
        Boca bocaNeutra = new BocaNeutra();
        String unNombre = "nombre";
        String res = bocaNeutra.verNombre(unNombre);

        assertEquals(unNombre, res);
    }
}
