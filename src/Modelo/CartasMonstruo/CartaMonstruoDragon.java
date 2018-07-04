package Modelo.CartasMonstruo;

public class CartaMonstruoDragon extends CartaMonstruo {
    
	private static Monstruo dragon = new Monstruo(3000, 2500);

	public CartaMonstruoDragon(String nombre) {
		super (nombre, dragon, 8);
	}

}
