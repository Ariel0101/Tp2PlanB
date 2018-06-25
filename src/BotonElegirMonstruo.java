import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BotonElegirMonstruo implements EventHandler<ActionEvent> {

    private final Campo campo;
    private final String aviso;
    private CartaMonstruo monstruoElegido;

    BotonElegirMonstruo(Campo unCampo, String avisoAlAsuarioDeQueElegir){
        this.campo = unCampo;
        this.aviso = avisoAlAsuarioDeQueElegir;
        this.monstruoElegido = null;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevaVentana = new Stage();
        HashMap<String, CartaMonstruo> monstruosPorClave= new HashMap<>(); // Para relacionar a cada monstruo con una de los items del combo box

        ListaMonstruos monstruos = this.campo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstruos.iterator();

        ComboBox<String> elegirMonstruo = new ComboBox<>();
        elegirMonstruo.setPromptText(this.aviso);
        int indiceMonstruo = 1;
        while (iteradorMonstruos.hasNext()){
            CartaMonstruo carta = iteradorMonstruos.next();
            String nombreCarta = String.format("M%d : " , indiceMonstruo) + carta.toString();
            monstruosPorClave.put(nombreCarta, carta);
            elegirMonstruo.getItems().add(nombreCarta);
            indiceMonstruo += 1;
        }
        ArrayList<CartaMonstruo> monstruoElegidoArray = new ArrayList<>();
        monstruoElegidoArray.add(null);
        BotonSeleccionarMonstruo  botonSeleccionarMonstruo = new BotonSeleccionarMonstruo (elegirMonstruo, monstruosPorClave, this, nuevaVentana);

        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setOnAction(botonSeleccionarMonstruo);

        VBox contenedorElegirAtacante = new VBox(10);
        contenedorElegirAtacante.setPadding(new Insets(20, 20, 300, 20));
        contenedorElegirAtacante.getChildren().addAll(elegirMonstruo, botonAceptar);

        Scene escenaElegirMonstruo = new Scene(contenedorElegirAtacante, 300, 500);
        nuevaVentana.setScene(escenaElegirMonstruo);
        nuevaVentana.show();
    }

    public void setMonstruoElegido(CartaMonstruo carta){
        this.monstruoElegido = carta;
    }

    public CartaMonstruo getMonstruo() {
        return this.monstruoElegido;
    }
}
