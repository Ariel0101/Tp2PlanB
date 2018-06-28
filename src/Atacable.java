public interface Atacable {

    Botin recibirAtaque(CartaMonstruo atacante, Campo miCampo) throws MonstruoNoPuedeAtacarError;
}
