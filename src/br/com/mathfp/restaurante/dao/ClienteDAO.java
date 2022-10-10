
package br.com.mathfp.restaurante.dao;

import br.com.mathfp.restaurante.bd.RestauranteBD;
import br.com.mathfp.restaurante.entidade.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    private static final String INSERT_SQL = "Insert into cliente "
            + "(nome, cpf, contato) "
            + "values ('%s', '%s', '%s')";
    private static final String UPDATE_SQL = "Update cliente "
            + "set nome = '%s', contato = '%s' "
            + "where id = %d";
    private static final String DELETE_SQL = "Delete from cliente "
            + "where id = %d";
    private static final String SELECT_TODOS = "Select * from cliente";
    private static final String SELECT_POR_ID = "Select * from cliente "
            + "where id = %d;";
    private static final String SELECT_POR_NOME = "Select * from cliente "
            + "where nome = '%s';";
    private static final String SELECT_POR_NOME_E_CPF = "Select * from cliente "
            + "where nome = '%s' and cpf = '%s';";
    
    public static void inserir(Cliente cliente) {
        String sql = String.format(INSERT_SQL,
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getContato());
        RestauranteBD.execute(sql, true);
    }
    
    public static void alterar(Cliente cliente) {
        String sql = String.format(UPDATE_SQL,
                cliente.getNome(),
                cliente.getContato(),
                cliente.getId());
        RestauranteBD.execute(sql, true);
    }
    
    public static void deletar(Cliente cliente) {
        String sql = String.format(DELETE_SQL, cliente.getId());
        RestauranteBD.execute(sql, true);
    }
    
    public static List<Cliente> selecionarTodos() {
        List<Cliente> lista = new ArrayList<>();
        Connection con = RestauranteBD.conectar();
        try {
            ResultSet rs = con.createStatement().executeQuery(SELECT_TODOS);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String contato = rs.getString("contato");
                lista.add(new Cliente(id, nome, cpf, contato));
            }
            RestauranteBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return lista;
    }
    
    public static Cliente getClientePorId(int idCliente) {
        Cliente retorno = null;
        Connection con = RestauranteBD.conectar();
        try {
            String sql = String.format(SELECT_POR_ID, idCliente);
            ResultSet rs = con.createStatement().executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String contato = rs.getString("contato");
            retorno = new Cliente(id, nome, cpf, contato);
            RestauranteBD.desconectar(con);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return retorno;
    }
    
}
