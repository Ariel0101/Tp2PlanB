import Excepciones.MonstruoNoPuedeAtacarError;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Iterator;

public class CartaMonstruoComeHombres extends CartaMonstruo {

    private final Campo campoEnemigo;
    private CartaMonstruo cartaSeleccionada;
    private Efecto efecto;
    CartaMonstruoComeHombres(Monstruo monstruo, int estrellas, Campo campoEnemigo) {
        super(monstruo, estrellas);
        this.cartaSeleccionada = null;
        this.campoEnemigo = campoEnemigo;
    }


    public void colocarBocaAbajo(){

        this.boca = new BocaAbajoComeHombres();

    }

    public void colocarBocaArriba(){
        if (this.boca.estaBocaAbajo()){
            this.activarEfecto();
        }
        this.boca = new BocaArriba();
    }

    private void activarEfecto(){

        if (this.cartaSeleccionada != null){
            this.campoEnemigo.destruir(this.cartaSeleccionada);
        }
        this.cartaSeleccionada = null; //Deselecciono la carta
    }

    public Botin recibirAtaque(CartaMonstruo cartaAtacante, Campo miCampo) throws MonstruoNoPuedeAtacarError {
        this.seleccionar(cartaAtacante);
        return this.boca.recibirAtaque(this, this.monstruo, cartaAtacante.monstruo, miCampo);
    }

    public void seleccionar(CartaMonstruo unaCarta) {
        this.cartaSeleccionada = unaCarta;
    }

    public void activarEfectoVisualmente(ActualizadorDeRepresentaciones actualizador) {
        Stage ventanaSeleccionarCarta = new Stage();

        ListaMonstruos monstrosEnemigos = this.campoEnemigo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstrosEnemigos.iterator();
        ComboBox<CartaMonstruo> opcionesMonstruos = new ComboBox<>();
        opcionesMonstruos.setPromptText("Elegir Monstruo a Destruir");
        while (iteradorMonstruos.hasNext()){
            CartaMonstruo carta = iteradorMonstruos.next();
            opcionesMonstruos.getItems().add(carta);
        }
        Button botonAceptarSeleccion = new Button("aceptar");
        botonAceptarSeleccion.setOnAction(actionEvent -> {
            CartaMonstruo cartaElegida = opcionesMonstruos.getValue();
            this.seleccionar(cartaElegida);
            this.activarEfecto();
            actualizador.actualizar();
            ventanaSeleccionarCarta.close();
        });
        VBox contenedorSeleccion = new VBox(10);
        contenedorSeleccion.setPadding(new Insets(20, 20, 300, 20));
        contenedorSeleccion.getChildren().addAll(opcionesMonstruos,botonAceptarSeleccion);
        Scene escenaSeleccionarCarta = new Scene(contenedorSeleccion);
        ventanaSeleccionarCarta.setScene(escenaSeleccionarCarta);
        ventanaSeleccionarCarta.show();
    }
}