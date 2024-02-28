import dao.BD;
import dao.IDao;
import dao.OdontologoDaoH2;
import dao.OdontologoDaoList;
import model.Odontologo;
import service.OdontologoService;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BD.crearTabla();
        IDao dao =new OdontologoDaoH2();
        OdontologoService service= new OdontologoService(dao);
        Odontologo odonto1= new Odontologo("Roldan","Juan","1234");
        Odontologo odonto2= new Odontologo("Hurtado","Anna","4567");
        Odontologo odonto3= new Odontologo("Roman","Julio","2575");
        service.guardar(odonto1);
        service.guardar(odonto2);
        service.guardar(odonto3);


List odontologos = service.listar();
        for (int i = 0; i < odontologos.size(); i++) {
            System.out.println(odontologos.get(i).toString());
        }

        dao =new OdontologoDaoList();
        service= new OdontologoService(dao);
         odonto1= new Odontologo("Roldan","Juan","1234");
         odonto2= new Odontologo("Hurtado","Anna","4567");
         odonto3= new Odontologo("Roman","Julio","2575");
        service.guardar(odonto1);
        service.guardar(odonto2);
        service.guardar(odonto3);


        odontologos = service.listar();
        for (int i = 0; i < odontologos.size(); i++) {
            System.out.println(odontologos.get(i).toString());
        }
    }

}