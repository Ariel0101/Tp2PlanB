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
import java.util.concurrent.atomic.AtomicReference;

public class BotonAtacar implements EventHandler<ActionEvent> {

    private final Campo campoAmigo;
    private final Campo campoEnemigo;
    private final Jugador jugadorAmigo;
    private final Jugador jugadorEnemigo;
    private final BotonElegirMonstruo elegirMonstruoAtacante;
    private final BotonElegirMonstruo elegirMonstruoAtacado;


    BotonAtacar(Jugador jugadorAmigo,Campo campoAmigo, BotonElegirMonstruo elegirMonstruoAtacante,Jugador jugadorEnemigo,Campo campoEnemigo, BotonElegirMonstruo elegirMonstruoAtacado){
        this.jugadorAmigo = jugadorAmigo;
        this.campoAmigo = campoAmigo;
        this.jugadorEnemigo = jugadorEnemigo;
        this.campoEnemigo = campoEnemigo;
        this.elegirMonstruoAtacante = elegirMonstruoAtacante;
        this.elegirMonstruoAtacado = elegirMonstruoAtacado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        CartaMonstruo monstruoAtacante = this.elegirMonstruoAtacante.getMonstruo();
        if (monstruoAtacante == null) {
            System.out.println("No se eligio monstruo atacante");
            return;
        }
        CartaMonstruo monstruoAtacado = this.elegirMonstruoAtacado.getMonstruo();
        if (monstruoAtacado == null) {
            System.out.println("No se eligio monstruo atacado");
            return;
        }
        Combate unCombate = new Combate(jugadorAmigo, campoAmigo, jugadorEnemigo, campoEnemigo);
        unCombate.combatir(monstruoAtacante, monstruoAtacado);
    }
    /*
    private void preguntarMonstruo(Campo campoDelMonstruo, String avisoAlAsuarioDeQueElegir){
        Stage nuevaVentana = new Stage();

        HashMap<String, CartaMonstruo> monstruosPorClave= new HashMap<>(); // Para relacionar a cada monstruo con una de los items del combo box

        ListaMonstruos monstruos = campoDelMonstruo.listaMonstruos();
        Iterator<CartaMonstruo> iteradorMonstruos = monstruos.iterator();

        ComboBox<String> elegirMonstruo = new ComboBox<>();
        elegirMonstruo.setPromptText(avisoAlAsuarioDeQueElegir);
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
        BotonSeleccionarMonstruo  botonSeleccionarMonstruo = new BotonSeleccionarMonstruo (elegirMonstruo, monstruosPorClave, monstruoElegidoArray, nuevaVentana);

        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setOnAction(botonSeleccionarMonstruo);

        VBox contenedorElegirAtacante = new VBox(10);
        contenedorElegirAtacante.setPadding(new Insets(20, 20, 300, 20));
        contenedorElegirAtacante.getChildren().addAll(elegirMonstruo, botonAceptar);

        Scene escenaElegirMonstruo = new Scene(contenedorElegirAtacante, 300, 500);
        nuevaVentana.setScene(escenaElegirMonstruo);
        nuevaVentana.show();
    }
    */

}
