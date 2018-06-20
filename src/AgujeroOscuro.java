class AgujeroOscuro implements Magica{

    private Campo campo;

    AgujeroOscuro(Campo campo) {

        this.campo = campo;

    }


    public void activar() {

        for(CartaMonstruo m : this.campo.monstruos()){

            this.campo.destruir(m);

        }

    }
}
