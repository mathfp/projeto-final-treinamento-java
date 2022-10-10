
package br.com.mathfp.restaurante.enums;


public enum Bebida {
   COCACOLA("Coca Cola"),
   GUARANA("Guarana"),
   SUCO("Suco"),
   FANTA("Fanta"),
   NENHUMA("Nenhuma");
   
   private final String bebida;

    private Bebida(String bebida) {
        this.bebida = bebida;
    }

    public String getBebida() {
        return bebida;
    }
   
   public static Bebida getBebidaPorNome(String nome) {
        Bebida retorno = NENHUMA;
        for (Bebida bebida : Bebida.values()) {
            if (bebida.getBebida().equalsIgnoreCase(nome)) {
                retorno = bebida;
            }
        }
        return retorno;
    }
   
}
