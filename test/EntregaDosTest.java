import junit.framework.TestCase;

public class EntregaDosTest extends TestCase {

    public void testActivarWasteLandAumenta200ElDanioDeMonstruosAmigosY300LaDefensaOponente(){

        Campo c1 = new Campo(new Cementerio());
        Campo c2 = new Campo(new Cementerio());
        Jugador j1 = new Jugador("a", 1000);
        Jugador j2 = new Jugador("b", 1000);
        Monstruo a1 = new Monstruo(200, 100);
        Monstruo a2 = new Monstruo(10, 10);
        CartaMonstruo aitsu1 = new CartaMonstruo(a1, 4);
        CartaMonstruo aitsu2 = new CartaMonstruo(a2, 4);
        WasteLand w = new WasteLand(c1, c2);
        CartaDeCampo waste = new CartaDeCampo(w);
        aitsu1.colocarEnPosAtaque();
        aitsu2.colocarEnPosAtaque();
        aitsu1.colocarse(c1);
        waste.colocarse(c1);
        aitsu2.colocarse(c2);

        Botin b = aitsu1.atacar(aitsu2);
        b.infligirDanios(j1, j2);

        assertEquals(j2.verVida(), 1000 - 390);
        assertEquals(j1.verVida(), 1000);

    }

}
