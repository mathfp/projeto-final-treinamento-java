package br.com.mathfp.restaurante.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RestauranteBD {

    public static void inicializarBD() {
        String sql;
        Connection con = conectar();
        sql = "Drop table if exists pedido";
        execute(con, sql);
        sql = "Drop table if exists cliente";
        execute(con, sql);
        sql = "Create table if not exists cliente "
                + "(id int not null auto_increment primary key, "
                + "nome varchar(30) not null, "
                + "cpf varchar(20) not null, "
                + "contato varchar(30) not null, "
                + "unique key (nome, cpf))";
        execute(con, sql);
        sql = "Create table if not exists pedido "
                + "(id int not null auto_increment primary key, "
                + "idCliente int not null, "
                + "prato varchar(15) not null, "
                + "bebida varchar(15) not null, "
                + "valor varchar(10) not null,"
                + "foreign key (idCliente) references cliente(id))";
        execute(con, sql);
        sql = "Insert into cliente (nome, cpf, contato) values ('Rodolfo', '344.070.117-42', '(71)996883322')";
        execute(con, sql);
        sql = "Insert into cliente (nome, cpf, contato) values ('Guilherme', '147.270.127-72', '(11)997745678')";
        execute(con, sql);
        sql = "Insert into cliente (nome, cpf, contato) values ('Antonio', '524.370.177-52', '(11)998895578')";
        execute(con, sql);
        sql = "Insert into cliente (nome, cpf, contato) values ('Laura', '124.480.287-63', '(11)973714030')";
        execute(con, sql);
        sql = "Insert into pedido (idCliente, prato, bebida, valor) "
                + "values (1, 'Hamburguer', 'Coca Cola', '24,90')";
        execute(con, sql);
        sql = "Insert into pedido (idCliente, prato, bebida, valor) "
                + "values (2, 'Pizza', 'Guarana', '32,90')";
        execute(con, sql);
        sql = "Insert into pedido (idCliente, prato, bebida, valor) "
                + "values (3, 'Massa', 'Suco', '35,00')";
        execute(con, sql);
        sql = "Insert into pedido (idCliente, prato, bebida, valor) "
                + "values (4, 'Pastel', 'Nenhuma', '8,00')";
        execute(con, sql);
        desconectar(con);
    }

    public static Connection conectar() {
        Connection con = null;
        final String USUARIO = "root";
        final String SENHA = "123456";
        final String URL = "jdbc:mysql://localhost/Restaurante";
        try {
            con = DriverManager.getConnection(URL,
                    USUARIO, SENHA);
        } catch (SQLException ex) {
            //   Base.mensagemDeErro("Não foi possível conectar ao banco de dados. "
            //           + "Verifique e tente posteriormente");
            System.exit(1);
        }
        return con;
    }

    public static void desconectar(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
        }
    }

    private static void execute(Connection con, String sql) {
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            //   Base.mensagemDeErro("Não foi possível executar\n" + sql);
            System.exit(1);
        }
    }
    
    public static void execute(String sql, boolean continuaNoErro) {
        // Fazer versão para conexões seguidas não desconectar
        Connection con = conectar();
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            if (!continuaNoErro) {
                System.exit(1);
            }
        }
        desconectar(con);
    }
}
