package dao;

import java.sql.*;
import java.sql.DriverManager;

public class BD {
    private static String SQL = "DROP TABLE IF EXISTS ODONTOLOGO; " +
            "CREATE TABLE ODONTOLOGO (ID INT AUTO_INCREMENT PRIMARY KEY,APELLIDO VARCHAR(100),NOMBRE VARCHAR(100),MATRICULA VARCHAR (100));";
    public static Connection conectar () {
        Connection con=null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:h2:" + "./Database/odontologo", "admin", "admin");
        } catch (Exception e) {
          e.printStackTrace();
        }
        return con;
    }
    public static void crearTabla () {
Connection con = BD.conectar();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
