package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoList implements IDao<Odontologo> {
    private static final Logger logger=Logger.getLogger(OdontologoDaoList.class);
    private List <Odontologo> odontologos;
public OdontologoDaoList() {
    this.odontologos=new ArrayList<>();
}
    @Override
    public Odontologo guardar(Odontologo data) {
        logger.info("creando Odontologo en array list");
    this.odontologos.add(data);
        return data;
    }

    @Override
    public List<Odontologo> listar() {
        logger.info("consultando Odontologos en array list");
    return this.odontologos;
    }
}
