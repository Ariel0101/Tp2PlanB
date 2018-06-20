class AgujeroOscuro implements Magica {

    private Campo campo;

    AgujeroOscuro(Campo campo) {

        this.campo = campo;

    }


    public void activar() {

        this.campo.aplicarEnMonstruos(new EfectoDestruirMonstruo(this.campo));

    }
}
