public interface Trampa {
    Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) throws MonstruoNoPuedeAtacarError;
}
