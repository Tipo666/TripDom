package edu.itla.tripdom.entity;

/**
 * Created by Tipo666 on 11/12/2017.
 */

public class PublicacionDetalle {

    private int id;
    private Publicacion publicacion;
    private String lugar;
    private String descripcion;


    public void setId(int id) {
        this.id = id;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PublicacionDetalle(int id, Publicacion publicacion, String lugar, String descripcion) {
        this.id = id;
        this.publicacion = publicacion;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }
}
