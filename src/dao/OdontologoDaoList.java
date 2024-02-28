package dao;

import model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoList implements IDao<Odontologo> {
private List <Odontologo> odontologos;
public OdontologoDaoList() {
    this.odontologos=new ArrayList<>();
}
    @Override
    public Odontologo guardar(Odontologo data) {
        this.odontologos.add(data);
        return data;
    }

    @Override
    public List<Odontologo> listar() {
        return this.odontologos;
    }
}
