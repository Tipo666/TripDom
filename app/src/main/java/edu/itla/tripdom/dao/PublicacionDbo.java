package edu.itla.tripdom.dao;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Tipo666 on 11/26/2017.
 */

public class PublicacionDbo {


    private DbConnection connection;
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    public PublicacionDbo(Context context) {
        connection = new DbConnection(context);
    }

    public void crear(Publicacion pu) {

        //pu.setUsuario(UsuarioActual.getUsuario());

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fecha", DF.format(pu.getFechaPublicacion()));
        cv.put("fecha_publicacion", DF.format(pu.getFechaViaje()));
        cv.put("usuario_id", UsuarioActual.getUsuario().getId());
    }

    public List<Publicacion> getPublication() {

        SQLiteDatabase db = connection.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT p.*, u.nombre FROM publicacion p INNER JOIN usuario u ON p.usuario_id = u.id", null);
        cursor.moveToNext();

        List<Publicacion> publicacions = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Publicacion p = new Publicacion();
            Usuario u = new Usuario();

            try {
                p.setFechaPublicacion(DF.parse(cursor.getString(cursor.getColumnIndex("fechapublicacion"))));
            } catch (ParseException ex) {
                p.setFechaPublicacion(new Date());
            }

            try {
                p.setFechaViaje(DF.parse(cursor.getString(cursor.getColumnIndex("fechaviaje"))));
            } catch (Exception ex) {
                p.setFechaViaje(new Date());
            }

            u.setId(cursor.getInt(cursor.getColumnIndex("usuario_id")));
            u.setNombre("nombre");
            u.setEmail("email");

            p.setUsuario(u);

            publicacions.add(p);

            cursor.moveToNext();
        }

            return publicacions;
    }
}
