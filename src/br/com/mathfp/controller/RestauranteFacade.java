
package br.com.mathfp.controller;

import br.com.mathfp.restaurante.Base;
import br.com.mathfp.restaurante.dao.ClienteDAO;
import br.com.mathfp.restaurante.dao.PedidoDAO;
import br.com.mathfp.restaurante.entidade.Cliente;
import br.com.mathfp.restaurante.entidade.Pedido;
import br.com.mathfp.restaurante.enums.Bebida;
import br.com.mathfp.restaurante.enums.TipoPrato;
import br.com.mathfp.restaurante.gui.ModificarClienteGUI;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RestauranteFacade {
    
    public static DefaultTableModel operacaoAtualizarInterfaceCliente(){
        String[] camposCliente = {"ID", "Nome", "CPF", "Contato"};
        List<Cliente> clientes = ClienteDAO.selecionarTodos();
        String[][] dadosClientes;
        dadosClientes = new String[clientes.size()][4];
        int posicao = 0;
        for (Cliente c : clientes) {
            String[] umCliente = new String[4];
            umCliente[0] = String.valueOf(c.getId());
            umCliente[1] = c.getNome();
            umCliente[2] = c.getCpf();
            umCliente[3] = c.getContato();
            dadosClientes[posicao++] = umCliente;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosClientes, camposCliente);
        return modelo;
    }
    
    public static void operacaoInserirCliente(){
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente");
        String cpf = JOptionPane.showInputDialog("Digite o cpf do cliente");
        String contato = JOptionPane.showInputDialog
        ("Digite o contato do cliente");  
        ClienteDAO.inserir(new Cliente(nome, cpf, contato));
        Base.mensagem("Cliente inserido!");
    }
    
    public static void operacaoDeletarCliente(int id, String nome, String cpf,
            String contato){
        Cliente cliente = new Cliente(id, nome, cpf, contato);
        Pedido pedido = PedidoDAO.selecionarPorCliente(cliente.getId());
        operacaoDeletarCliente(cliente, pedido);
    }
    
    public static void operacaoDeletarCliente(Cliente cliente, Pedido pedido){
        PedidoDAO.deletar(pedido);
        ClienteDAO.deletar(cliente);
        Base.mensagem("Cliente removido!");
    }
    
    public static void operacaoModificarCliente(
            int id, String nome, String cpf, String contato){
        Cliente cliente = new Cliente(id, nome, cpf, contato);
        operacaoModificarCliente(cliente);
    }
    
    public static void operacaoModificarCliente(Cliente cliente){
        ModificarClienteGUI interfaceModificarCliente =
                new ModificarClienteGUI();
        interfaceModificarCliente.setVisible(true);
        interfaceModificarCliente.setDefaultCloseOperation(JFrame.
                DISPOSE_ON_CLOSE);
        interfaceModificarCliente.setJClienteLabel(cliente.getNome());
        interfaceModificarCliente.setTextJtfNome(cliente.getNome());
        interfaceModificarCliente.setTextJtfContato(cliente.getContato());
        interfaceModificarCliente.setTextJtfIdCliente(cliente.getId());
    }
    
    public static DefaultTableModel gerarModeloTabelaPedidos(String idString){        
        int id = Integer.parseInt(idString);
            String[] camposPedido = {
                "ID", "ID do Cliente", "Prato", "Bebida", "Valor"};
            List<Pedido> pedidos
                    = PedidoDAO.selecionarPedidosPorCliente(id);
            String[][] dadosPedidos = new String[pedidos.size()][5];
            int posicao = 0;
            for (Pedido pedido : pedidos) {
                String[] umPedido = new String[5];
                umPedido[0] = String.valueOf(pedido.getId());
                umPedido[1] = String.valueOf(pedido.getCliente().getId());
                umPedido[2] = pedido.getPrato().getTipoPrato();
                umPedido[3] = pedido.getBedida().getBebida();
                umPedido[4] = pedido.getValor();
                dadosPedidos[posicao++] = umPedido;
            }
            DefaultTableModel modelo = new DefaultTableModel(
                    dadosPedidos, camposPedido);
        return modelo;
    }
    
    public static void operacaoInserirPedido(int id, String nome, String cpf,
            String contato, String valor, String prato, String bebida){
        Cliente cliente = new Cliente(id, nome, cpf, contato);
        Pedido pedido = new Pedido(cliente,TipoPrato.getTipoPratoPorNome(prato),
                Bebida.getBebidaPorNome(bebida), valor);
        operacaoInserirPedido(pedido);
    }
    
    public static void operacaoInserirPedido(Pedido pedido){
        PedidoDAO.inserir(pedido);
        Base.mensagem("Pedido inserido com sucesso!");
    }
    
    public static Cliente operacaoGetClienteDoPedido(int idCliente){
        Cliente cliente = ClienteDAO.getClientePorId(idCliente);
        return cliente;
    }
    
    public static void operacaoAtualizarPedido(
            int id, int idCliente, String prato, String bebida, String valor ,
            String valorRetornado, String pratoRetornado, String bebidaRetornado){
        Pedido pedido = new Pedido(id, ClienteDAO.getClientePorId(idCliente),
                TipoPrato.getTipoPratoPorNome(prato),
                Bebida.getBebidaPorNome(bebida), valor);
        pedido.setValor(valorRetornado);
        pedido.setPrato(TipoPrato.getTipoPratoPorNome(pratoRetornado));
        pedido.setBedida(Bebida.getBebidaPorNome(bebidaRetornado));
        operacaoAtualizarPedido(pedido);
    }
    
    public static void operacaoAtualizarPedido(Pedido pedido){
        PedidoDAO.alterar(pedido);
        Base.mensagem("Pedido Alterado com sucesso!");
    }
    
    public static void operacaoRemoverPedido(
            int id, int idCliente, String prato, String bebida, String valor){
        Pedido pedido = new Pedido(id, ClienteDAO.getClientePorId(idCliente),
                TipoPrato.getTipoPratoPorNome(prato),
                Bebida.getBebidaPorNome(bebida), valor);
        operacaoRemoverPedido(pedido);
    }
    
    public static void operacaoRemoverPedido(Pedido pedido){
        PedidoDAO.deletar(pedido);
        Base.mensagem("Pedido Removido!");
    }
    
    public static DefaultTableModel gerarModeloAtualizarTabelaPedidos(int idCliente){
        String[] camposPedido = {"ID", "ID do Cliente", "Prato", "Bebida", "Valor"};
        List<Pedido> pedidos
                = PedidoDAO.selecionarPedidosPorCliente(idCliente);
        String[][] dadosPedidos = new String[pedidos.size()][5];
        int posicao = 0;
        for (Pedido pedido : pedidos) {
            String[] umPedido = new String[5];
            umPedido[0] = String.valueOf(pedido.getId());
            umPedido[1] = String.valueOf(pedido.getCliente().getId());
            umPedido[2] = pedido.getPrato().getTipoPrato();
            umPedido[3] = pedido.getBedida().getBebida();
            umPedido[4] = pedido.getValor();
            dadosPedidos[posicao++] = umPedido;
        }
        DefaultTableModel modelo = new DefaultTableModel(
                dadosPedidos, camposPedido);
        return modelo;
    }
    
    public static Pedido operacaoRetornarPedido(
            int id, int idCliente, String prato, String bebida, String valor){
        Pedido pedido = new Pedido(id, ClienteDAO.getClientePorId(idCliente),
                TipoPrato.getTipoPratoPorNome(prato),
                Bebida.getBebidaPorNome(bebida), valor);
        return pedido;
    }
    
}
