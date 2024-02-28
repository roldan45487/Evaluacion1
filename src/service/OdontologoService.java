package service;

import dao.IDao;
import dao.OdontologoDaoH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao <Odontologo> dao;
    public OdontologoService (IDao<Odontologo>dao) {
        this.dao=dao;
    }

    public Odontologo guardar (Odontologo odontologo) {
return this.dao.guardar(odontologo);

    }
public List <Odontologo> listar () {
    return this.dao.listar();
}
}
