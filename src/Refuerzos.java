public class Refuerzos implements Trampa {

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) {
        int aumento = 500;
        monstruoAtacado.agregarAumentoAtaqueTemporal(500);
        return monstruoAtacante.atacar(monstruoAtacado);
    }
}
