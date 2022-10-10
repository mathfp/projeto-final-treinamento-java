
package br.com.mathfp.restaurante.dao;

import br.com.mathfp.restaurante.bd.RestauranteBD;
import br.com.mathfp.restaurante.entidade.Pedido;
import br.com.mathfp.restaurante.enums.Bebida;
import br.com.mathfp.restaurante.enums.TipoPrato;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {
    private static final String INSERT_SQL = "Insert into pedido "
            + "(idCliente, prato, bebida, valor) "
            + "values (%d, '%s', '%s', '%s')";
    private static final String UPDATE_SQL = "Update pedido "
            + "set prato = '%s', bebida = '%s', valor = '%s' "
            + "where id = %d";
    private static final String DELETE_SQL = "Delete from pedido "
            + "where id = %d";
    private static final String SELECT_TODOS = "Select * from pedido";
    private static final String SELECT_POR_CLIENTE = "Select * "
            + "from pedido where idCliente = %d";
    
    public static void inserir(Pedido pedido) {
        String sql = String.format(INSERT_SQL,
                pedido.getCliente().getId(),
                pedido.getPrato().getTipoPrato(),
                pedido.getBedida().getBebida(),
                pedido.getValor());
        RestauranteBD.execute(sql, true);
    }
    
    public static void alterar(Pedido pedido) {
        String sql = String.format(UPDATE_SQL,
                pedido.getPrato().getTipoPrato(),
                pedido.getBedida().getBebida(),
                pedido.getValor(),
                pedido.getId());
        RestauranteBD.execute(sql, true);
    }
    
    public static void deletar(Pedido pedido) {
        String sql = String.format(DELETE_SQL,
                pedido.getId());
        RestauranteBD.execute(sql, true);
    }
    
    public static List<Pedido> selecionarTodos() {
        List<Pedido> lista = new ArrayList<>();
        Connection con = RestauranteBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCliente = rs.getInt("idCliente");
                String prato = rs.getString("prato");
                String bebida = rs.getString("bebida");
                String valor = rs.getString("valor");
                lista.add(new Pedido(id,
                        ClienteDAO.getClientePorId(idCliente),
                        TipoPrato.getTipoPratoPorNome(prato),
                        Bebida.getBebidaPorNome(bebida),
                        valor));
            }
            RestauranteBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    public static List<Pedido> selecionarPedidosPorCliente(int idCliente) {
        List<Pedido> lista = new ArrayList<>();
        Connection con = RestauranteBD.conectar();
        try {
            String sql = String.format(SELECT_POR_CLIENTE, idCliente);
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idClienteRetornado = rs.getInt("idCliente");
                String prato = rs.getString("prato");
                String bebida = rs.getString("bebida");
                String valor = rs.getString("valor");
                lista.add(new Pedido(id,
                        ClienteDAO.getClientePorId(idClienteRetornado),
                        TipoPrato.getTipoPratoPorNome(prato),
                        Bebida.getBebidaPorNome(bebida),
                        valor));
            }
            RestauranteBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    
    public static Pedido selecionarPorCliente(int idCliente) {
        Pedido retorno = null;
        Connection con = RestauranteBD.conectar();
        try {
            String sql = String.format(SELECT_POR_CLIENTE, idCliente);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            int idClienteRetornado = rs.getInt("idCliente");
            String prato = rs.getString("prato");
            String bebida = rs.getString("bebida");
            String valor = rs.getString("valor");
            retorno = new Pedido(id, 
                    ClienteDAO.getClientePorId(idClienteRetornado),
                    TipoPrato.getTipoPratoPorNome(prato),
                    Bebida.getBebidaPorNome(bebida),
                    valor);
            RestauranteBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
    
}
