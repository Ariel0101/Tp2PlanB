public class CilindroMagico implements Trampa {

    public Botin activar(Monstruo monstruoAtacante, Monstruo monstruoAtacado, Botin unBotin) {
        Botin nuevoBotin = new Botin();
        nuevoBotin.setDanioAtacante(monstruoAtacante.obtenerPuntosDeAtaque());
        return nuevoBotin;
    }
}
