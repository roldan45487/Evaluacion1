package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao <Odontologo> {
    private static final Logger logger=Logger.getLogger(OdontologoDaoH2.class);
private String CREAR="INSERT INTO ODONTOLOGO ( APELLIDO,NOMBRE,MATRICULA ) VALUES (?,?,?);";
private String LISTAR= "SELECT * FROM ODONTOLOGO";
    @Override
    public Odontologo guardar(Odontologo data) {
       Connection con=null;
        try {
         con=BD.conectar();
            PreparedStatement stmt=con.prepareStatement(this.CREAR,PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1,data.getApellido());
            stmt.setString(2,data.getNombre());
            stmt.setString(3,data.getMatricula());

            logger.info("creando odontologo en H2");

            stmt.execute();
            System.out.println("guardando");
            ResultSet resultSet= stmt.getGeneratedKeys();
            while (resultSet.next()) {
                data.setId (resultSet.getInt(1));
            }
        } catch (Exception e) {
            logger.error("OCURRIO EL SIGUIENTE ERROR: ",e);
           e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                logger.error("OCURRIO EL SIGUIENTE ERROR: ",e);
                e.printStackTrace();
            }
        }

        return data;
    }
    @Override
    public List listar() {
        Connection con=null;
        List<Odontologo> odontologos=new ArrayList<>();
        try {
            con=BD.conectar();
            PreparedStatement stmt=con.prepareStatement(this.LISTAR);
            logger.info("consultando Odontologos en H2");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                odontologos.add(new Odontologo(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("OCURRIO EL SIGUIENTE ERROR: ",e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                logger.error("OCURRIO EL SIGUIENTE ERROR: ",e);
                e.printStackTrace();
            }
        }
        return odontologos;
    }
}

