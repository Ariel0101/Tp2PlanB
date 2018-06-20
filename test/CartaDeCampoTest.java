import junit.framework.TestCase;

public class CartaDeCampoTest extends TestCase {

	public void testActivarCartaDeCampoWastelandModificaDosMonstruosYaEnElCampo() {
		/* efecto: aumenta en 200 puntos el ataque de tus monstruos, 
		 * y 300 puntos la defensa de los monstruos de tu oponente */
		
		Campo unCampo = new Campo(new Cementerio());
		Campo otroCampo = new Campo(new Cementerio());
		EfectoWasteland efectoWasteland = new EfectoWasteland(unCampo, otroCampo);
		CartaDeCampo cartaWasteland = new CartaDeCampo(efectoWasteland);
		
		int ataqueInicialM1 = 100, defensaInicialM2 = 100;
		Monstruo m1 = new Monstruo(ataqueInicialM1, 0);
		Monstruo m2 = new Monstruo(0, defensaInicialM2);
		CartaMonstruo cartaMonstruoUno = new CartaMonstruo(m1, 1);
		CartaMonstruo cartaMonstruoDos = new CartaMonstruo(m2, 2);
		
		cartaMonstruoUno.colocarse(unCampo);
		cartaMonstruoDos.colocarse(otroCampo);
		
		cartaWasteland.colocarse(unCampo);
		
		assertTrue(m1.obtenerPuntosDeAtaque() == (ataqueInicialM1 + 200));
		assertTrue(m2.obtenerPuntosDeDefensa() == (defensaInicialM2 + 300));

	}
	
	public void testActivarCartaDeCampoWastelandModificaDosMonstruosColocadosMasTarde() {

		Campo unCampo = new Campo(new Cementerio());
		Campo otroCampo = new Campo(new Cementerio());
		EfectoWasteland efectoWasteland = new EfectoWasteland(unCampo, otroCampo);
		CartaDeCampo cartaWasteland = new CartaDeCampo(efectoWasteland);
		
		int ataqueInicialM1 = 200, defensaInicialM2 = 0;
		int ataqueInicialM3 = 50, defensaInicialM4 = 300;
		Monstruo m1 = new Monstruo(ataqueInicialM1, 0);
		Monstruo m2 = new Monstruo(0, defensaInicialM2);
		Monstruo m3 = new Monstruo(ataqueInicialM3, 0);
		Monstruo m4 = new Monstruo(0, defensaInicialM4);
		CartaMonstruo cartaMonstruoUno = new CartaMonstruo(m1, 1);
		CartaMonstruo cartaMonstruoDos = new CartaMonstruo(m2, 2);
		CartaMonstruo cartaMonstruoTres = new CartaMonstruo(m3, 1);
		CartaMonstruo cartaMonstruoCuatro = new CartaMonstruo(m4, 2);
		
		cartaMonstruoUno.colocarse(unCampo);
		cartaMonstruoDos.colocarse(otroCampo);
		
		cartaWasteland.colocarse(unCampo);
		
		cartaMonstruoTres.colocarse(unCampo);
		cartaMonstruoCuatro.colocarse(otroCampo);
		
		assertTrue(m1.obtenerPuntosDeAtaque() == (ataqueInicialM1 + 200));
		assertTrue(m2.obtenerPuntosDeDefensa() == (defensaInicialM2 + 300));
		assertTrue(m3.obtenerPuntosDeAtaque() == (ataqueInicialM3 + 200));
		assertTrue(m4.obtenerPuntosDeDefensa() == (defensaInicialM4 + 300));
	}


}
