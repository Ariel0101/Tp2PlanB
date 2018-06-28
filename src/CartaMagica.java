import javafx.scene.image.Image;

class CartaMagica implements Carta {

    private Magia magia;
    private Boca boca;
    private String nombre;

    CartaMagica(Magia magia) {

        this.magia = magia;
        this.boca = new BocaNeutra();

    }

    public void colocarBocaAbajo() {

        this.boca = new BocaAbajo();

    }

    public void colocarBocaArriba() {

        this.magia.activar();
        this.boca = new BocaArriba();

    }


    public void colocarse(Mano unaMano) {

        unaMano.agregar(this);

    }

    public void colocarse(Campo c) {

        c.colocarCarta(this);

    }

    public void ponerNombre(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public String toString(){

        return this.nombre;
    }

    public Image imagen(){

        return this.boca.imagen(this.nombre, "");

    }

}
