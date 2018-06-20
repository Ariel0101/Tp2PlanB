class AumentoDefensa implements Aumento{
    private final int aumento;

    AumentoDefensa(int i) {

        this.aumento = i;
    }

    void activar(ListaMonstruos monstruos){

        for (CartaMonstruo m: monstruos){

            m.aumentarDefensa(this.aumento);

        }

    }

    void activarEn(CartaMonstruo m){

        m.aumentarDefensa(this.aumento);

    }
}
