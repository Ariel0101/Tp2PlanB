package Cartas;

public class CartaMonstruoDragonDefinitivo extends CartaMonstruo {

    private static Monstruo dragonDefinitivo = new Monstruo(4500, 3800);

	CartaMonstruoDragonDefinitivo() {
        super (dragonDefinitivo, 12);
		this.invocacion = new InvocacionFusion(new CartaMonstruoDragon(), 3);
	}

}
