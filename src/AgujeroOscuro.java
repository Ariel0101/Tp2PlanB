class AgujeroOscuro implements Magica{

    private Campo campo;

    AgujeroOscuro(Campo campo) {

        this.campo = campo;

    }


    public void activar() {

        for(Carta m : this.campo.monstruos()){

            this.campo.destruir(m);

        }

    }
}
