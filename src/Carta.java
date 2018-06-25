import javafx.scene.image.Image;

public interface Carta {
     void colocarse(Mano unaMano);

     void colocarse(Campo c);

     void colocarBocaAbajo();

     void colocarBocaArriba();

     String toString();

    default Image imagen(){

         return new Image("Aitsu.jpg");

    }

    /*@Override
    default String toString() {
        return "caca";
    }*/
}
