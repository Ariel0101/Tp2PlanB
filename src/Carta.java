import javafx.scene.image.Image;

public interface Carta {
     void colocarse(Mano unaMano);

     void colocarse(Campo c);

     void colocarBocaAbajo();

     void colocarBocaArriba();

     String toString();

     Image imagen();

     void ponerNombre(String refuerzos);
}
