import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Collection;
import java.util.Iterator;

public class BotonActualizarEventHandler implements EventHandler<ActionEvent> {

    private final Collection<Actualizable> representaciones;

    BotonActualizarEventHandler(Collection<Actualizable> representaciones){
        this.representaciones = representaciones;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Iterator<Actualizable> iteradorActualizables = this.representaciones.iterator();
        while (iteradorActualizables.hasNext()){
            Actualizable representacion = iteradorActualizables.next();
            representacion.actualizar();
        }
    }
}
