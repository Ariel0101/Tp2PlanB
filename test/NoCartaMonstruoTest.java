import Controlador.ConstructorDeCartas;
import Controlador.Partida;
import Modelo.Campo.Campo;
import Modelo.Campo.Cementerio;
import Modelo.CartasMonstruo.CartaMonstruo;
import Modelo.CartasMonstruo.Monstruo;
import Modelo.CartasMonstruo.NoCartaMonstruo;
import Modelo.Excepciones.NoCartaMonstruoError;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.Mano;
import org.junit.Test;


public class NoCartaMonstruoTest  {
    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlColocarEnPosAtaque()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarEnPosAtaque();
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlColocarEnPosDefensa()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarEnPosDefensa();
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlColocarBocaArriba()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarBocaArriba();
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlColocarBocaAbajo()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarEnPosAtaque();
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlAtacar()  {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        mokeyMokey.colocarBocaArriba();
        mokeyMokey.colocarEnPosAtaque();
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.atacar(mokeyMokey, new Campo(new Cementerio()));
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlRecibirAtacar()  {
        ConstructorDeCartas constructorDeCartas = new ConstructorDeCartas();
        CartaMonstruo mokeyMokey = constructorDeCartas.mokeyMokey();
        mokeyMokey.colocarBocaArriba();
        mokeyMokey.colocarEnPosAtaque();
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.recibirAtaque(mokeyMokey, new Campo(new Cementerio()));
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlDestruir()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.destruir(new Cementerio());
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorColocarseEnCampo()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarse(new Campo(new Cementerio()));
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorColocarseEnMano()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.colocarse(new Mano(new Jugador("",100, new Partida())));
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlAumentarAtaque()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.aumentarAtaque(100);
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlAumentarDefensa()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.aumentarDefensa(100);
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlVerConCuantoPuntosAtaca()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.conCuantosPuntosAtaca();
    }

    @Test(expected = NoCartaMonstruoError.class)
    public void testNoCartaMonstruoLevantaErrorAlDesactivarTemporales()  {
        Monstruo monstruoCualquiera = new Monstruo(0,0);
        NoCartaMonstruo noCartaMonstruo = new NoCartaMonstruo(monstruoCualquiera);

        noCartaMonstruo.desactivarTemporales();
    }
}
