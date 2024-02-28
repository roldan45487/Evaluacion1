package model;

public class Odontologo {
private int id;
    private String apellido;

    private String nombre;
    private String numeroMatricula;

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.numeroMatricula = matricula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return numeroMatricula;
    }

    public void setMatricula(String matricula) {
        this.numeroMatricula= matricula;
    }

    public void setId (int id) {
        this.id= id;
    }

    @Override
    public String toString() {
        return this.apellido + " " + this.nombre + " " + this.numeroMatricula + " ";
    }
}
