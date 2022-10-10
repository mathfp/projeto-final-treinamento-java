
package br.com.mathfp.restaurante.enums;


public enum TipoPrato {
     HAMBURGUER("Hamburguer"),
     PIZZA("Pizza"),
     MASSA("Massa"),
     PASTEL("Pastel"),
     HOTDOG("Hotdog"),
     NENHUM("Nenhum");
     
     private final String tipoPrato;

    private TipoPrato(String tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    public String getTipoPrato() {
        return tipoPrato;
    }
    
    public static TipoPrato getTipoPratoPorNome(String nome) {
        TipoPrato retorno = NENHUM;
        for (TipoPrato tp : TipoPrato.values()) {
            if (tp.getTipoPrato().equalsIgnoreCase(nome)) {
                retorno = tp;
            }
        }
        return retorno;
    }
}
