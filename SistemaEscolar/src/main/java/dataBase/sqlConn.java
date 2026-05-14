package dataBase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class sqlConn {
    private static final String url = "jdbc:mysql://localhost:3306/sitema_escolar";
    private static final String user = "root";
    private static final String password = "Senai@134";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

    public static void testConnection(){
        try (Connection conn = getConnection()){
            System.out.println("Conexão foi estabelecida com sucesso!" + conn);
        }
        catch (SQLException e){
            System.out.println("Falha na conexão" + e.getMessage());
            System.out.println("Verifique: ");
            System.out.println("1. MySql está rodando:" + e.getMessage());
            System.out.println("2. O banco " + url + " realmente existe");
            System.out.println("3. O usuário ou senha estão corretos" + e.getMessage());
        }
    }
}