
package br.com.mathfp.restaurante.entidade;

import br.com.mathfp.restaurante.enums.Bebida;
import br.com.mathfp.restaurante.enums.TipoPrato;


public class Pedido {
    private int id;
    private Cliente cliente;
    private TipoPrato prato;
    private Bebida bedida;
    private String valor;

    public Pedido(Cliente cliente, TipoPrato prato, Bebida bedida, String valor) {
        this.cliente = cliente;
        this.prato = prato;
        this.bedida = bedida;
        this.valor = valor;
    }

    public Pedido(int id, Cliente cliente, TipoPrato prato, Bebida bedida, String valor) {
        this.id = id;
        this.cliente = cliente;
        this.prato = prato;
        this.bedida = bedida;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoPrato getPrato() {
        return prato;
    }

    public Bebida getBedida() {
        return bedida;
    }

    public String getValor() {
        return valor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPrato(TipoPrato prato) {
        this.prato = prato;
    }

    public void setBedida(Bebida bedida) {
        this.bedida = bedida;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
