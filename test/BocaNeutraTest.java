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
}
