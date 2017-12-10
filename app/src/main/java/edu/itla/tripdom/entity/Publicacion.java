package edu.itla.tripdom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tipo666 on 11/12/2017.
 */

public class Publicacion {

        private int  Id;
        private Date fechaPublicacion;
        private Date fechaViaje;
        private int costo;
        private String descripcion;
        private int estado;
        private Usuario usuario;
        private String origen;
        private int cupo;

        List<PublicacionDetalle> detalle;

    public void setDetalle(List<PublicacionDetalle> detalle) {
        this.detalle = detalle;
    }

    public Publicacion(int id, Date fechaPublicacion, Date fechaViaje, int costo, String descripcion, int estado, Usuario usuario, String origen, int cupo) {
        Id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaViaje = fechaViaje;
        this.costo = costo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.origen = origen;
        this.cupo = cupo;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return Id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    // -Imagen (Temp)
      //  -Cupo (Del transporte)

    public List<PublicacionDetalle> getDetalle() {
        return detalle;
    }

    public void addDetalle(PublicacionDetalle pd){

        if (detalle == null){
            detalle = new ArrayList<>();
        }

        pd.setPublicacion(this);
        detalle.add(pd);

    }
}
