class AgujeroOscuro implements Magica{

    private Campo campo;
    private Cementerio cementerio;

    AgujeroOscuro(Campo campo, Cementerio c) {

        this.campo = campo;
        this.cementerio = c;

    }


    public void activar() {

        campo.destruirTodas(this.cementerio);

    }
}
