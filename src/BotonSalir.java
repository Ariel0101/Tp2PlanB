import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSalir implements EventHandler<ActionEvent> {

    private final Partida partida;

    BotonSalir(Partida unaPartida){
        this.partida = unaPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    }
}
