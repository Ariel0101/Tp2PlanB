package Modelo.CartasMonstruo;

public class CartaMonstruoDragonDefinitivo extends CartaMonstruo {

    private static Monstruo dragonDefinitivo = new Monstruo(4500, 3800);

	public CartaMonstruoDragonDefinitivo(String nombre) {
        super (nombre, dragonDefinitivo, 12);
		this.invocacion = new InvocacionFusion(new CartaMonstruoDragon(nombre), 3);
	}

}
