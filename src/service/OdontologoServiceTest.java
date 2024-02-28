package service;

import dao.BD;
import dao.IDao;
import dao.OdontologoDaoH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    public void listarTest() {

        BD.crearTabla();
        IDao dao = new OdontologoDaoH2();
        OdontologoService service = new OdontologoService(dao);
        Odontologo odonto1 = new Odontologo("Roldan", "Juan", "1234");
        Odontologo odonto2 = new Odontologo("Hurtado", "Anna", "4567");
        Odontologo odonto3 = new Odontologo("Roman", "Julio", "2575");
        service.guardar(odonto1);
        service.guardar(odonto2);
        service.guardar(odonto3);

        List <Odontologo> odontologos = service.listar();

        Assertions.assertTrue(buscarOdontologo(odonto1,odontologos));
        Assertions.assertTrue(buscarOdontologo(odonto2,odontologos));
        Assertions.assertTrue(buscarOdontologo(odonto3,odontologos));
    }
    private boolean buscarOdontologo (Odontologo od,List <Odontologo> odontologos){
        boolean encontrado = false;
        for (int i = 0; i < odontologos.size(); i++) {
            if (odontologos.get(i).getApellido()==od.getApellido()) {
                encontrado=true;
            }
            System.out.println(odontologos.get(i).toString());
        }
        return encontrado;
    }
}