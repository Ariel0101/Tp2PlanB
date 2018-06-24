public interface Carta {
     void colocarse(Mano unaMano);

     void colocarse(Campo c);

     void colocarBocaAbajo();

     void colocarBocaArriba();

    default String nombre() {
        return "caca";
    }
}
