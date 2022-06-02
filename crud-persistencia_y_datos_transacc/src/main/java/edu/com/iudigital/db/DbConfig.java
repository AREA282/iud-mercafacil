package edu.com.iudigital.db;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;

@AllArgsConstructor
public class DbConfig {


    private String host;
    private String port;
    private String db;



    public Connection connect(){
        Connection connection = null;
        try {
            String connectionString = "jdbc:mysql://"+ host +":"+port + "/" + db;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, "root", "Qwer1234");
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return  connection;
    }
}
