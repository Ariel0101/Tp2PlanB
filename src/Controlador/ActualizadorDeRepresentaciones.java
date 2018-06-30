package Controlador;

import java.util.Collection;
import java.util.Iterator;

public class ActualizadorDeRepresentaciones {

    private final Collection<Actualizable> representaciones;

    ActualizadorDeRepresentaciones(Collection<Actualizable> representaciones){
        this.representaciones = representaciones;
    }

    public void actualizar() {
        Iterator<Actualizable> iteradorActualizables = this.representaciones.iterator();
        while (iteradorActualizables.hasNext()){
            Actualizable representacion = iteradorActualizables.next();
            representacion.actualizar();
        }
    }
}
