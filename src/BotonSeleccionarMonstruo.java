import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.HashMap;

public class BotonSeleccionarMonstruo implements EventHandler<ActionEvent> {
    private final ComboBox<String> elegirMonstruo;
    private final HashMap<String, CartaMonstruo> monstruosPorClave;
    private final ArrayList<CartaMonstruo> monstruoElegidoArray;

    public BotonSeleccionarMonstruo (ComboBox<String> elegirMonstruo, HashMap<String, CartaMonstruo> monstruosPorClave, ArrayList<CartaMonstruo> monstruoElegidoArray) {
        this.elegirMonstruo = elegirMonstruo;
        this.monstruosPorClave = monstruosPorClave;
        this.monstruoElegidoArray = monstruoElegidoArray;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombreDeCartaElegida = this.elegirMonstruo.getValue();
        CartaMonstruo monstruoElegido = this.monstruosPorClave.get(nombreDeCartaElegida);
        this.monstruoElegidoArray.remove(0);
        this.monstruoElegidoArray.add(monstruoElegido);
    }
}
