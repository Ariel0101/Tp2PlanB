abstract class CartaMonstruoDecorator implements Carta {

    Carta cartaTemp;

    CartaMonstruoDecorator(CartaMonstruo carta){

        this.cartaTemp = carta;
    }

}
