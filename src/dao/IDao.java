package dao;

import java.util.List;

public interface IDao <T> {

     T guardar (T data);

     List<T> listar ();

}
