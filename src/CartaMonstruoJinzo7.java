public class CartaMonstruoJinzo7 extends CartaMonstruo {
    CartaMonstruoJinzo7(Monstruo m, int estrellas) {
        super(m, estrellas);
    }

    public void atacar(Jugador jugadorAtacado) throws MonstruoNoPuedeAtacarError {
        Monstruo monstruoTemporal = new Monstruo(0,0);
        monstruoTemporal.colocarEnPosAtaque();
        Botin unBotin = this.monstruo.atacar(monstruoTemporal);
        unBotin.infligirDanios(new Jugador("",100000), jugadorAtacado);
    }
}
