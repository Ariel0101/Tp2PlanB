import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class BotonSeleccionarMonstruo implements EventHandler<ActionEvent> {
    private final ComboBox<String> elegirMonstruo;
    private final HashMap<String, CartaMonstruo> monstruosPorClave;
    private final BotonElegirMonstruo botonElegirMonstruo;
    private final Stage ventana;


    public BotonSeleccionarMonstruo(ComboBox<String> elegirMonstruo, HashMap<String, CartaMonstruo> monstruosPorClave, BotonElegirMonstruo botonElegirMonstruo, Stage ventana) {
        this.elegirMonstruo = elegirMonstruo;
        this.monstruosPorClave = monstruosPorClave;
        this.botonElegirMonstruo = botonElegirMonstruo;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombreDeCartaElegida = this.elegirMonstruo.getValue();
        CartaMonstruo monstruoElegido = this.monstruosPorClave.get(nombreDeCartaElegida);
        botonElegirMonstruo.setMonstruoElegido(monstruoElegido);
        this.ventana.close();
    }
}
