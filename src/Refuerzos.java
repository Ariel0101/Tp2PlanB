public class Refuerzos implements Trampa {

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError {
        int aumento = 500;
        monstruoAtacado.agregarAumentoTemporal(500);
        return monstruoAtacante.atacar(monstruoAtacado);
    }
}
