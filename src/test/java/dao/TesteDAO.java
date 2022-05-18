package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDAO {
    static Connection connection;
    static Statement stmt;

    @BeforeClass
    public static void setupBeforeClass() throws SQLException {

        System.out.println("Iniciando conexao com o Banco");
        connection = ConnectionFactory.getConnection();
        System.out.println("Conexao feita com sucesso !!!");
        stmt = connection.createStatement();
        connection.setAutoCommit(false);
    }
    @Test
    public void testRetornoSelectDadosTeste() throws SQLException {
        String comandoSql = "SELECT dt.MASSA_TESTE from DADOS_TESTE dt WHERE ID_CASO_TESTE = 1"; //Criando um comando SQL
        ResultSet resultSet = stmt.executeQuery(comandoSql); //Faz a consulta e retorna em um resultSET
        resultSet.next(); //Representa um jSon e o mesmo vem setado antes da primeira posiçao, assim ele aponta para o primeiro resultado
        String jsonMassaDeTeste = resultSet.getString(1);
        System.out.println(jsonMassaDeTeste);
        Assert.assertTrue("Informacoes nao existem no select", jsonMassaDeTeste.contains("\"url\":\"https://amazon.com.br\""));
    }

    @After
    public void after() throws SQLException {
        stmt.close();
        connection.close();
        System.out.println("Conexao finalizada com sucesso");
    }

}
