package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Tipo666 on 11/26/2017.
 *
 *
 */


public class UsuarioDbo {

    private DbConnection connection;

    public UsuarioDbo(Context context) { connection = new DbConnection(context);}

    public void crear(Usuario usuario){

        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("email", usuario.getEmail());
        cv.put("tipo_usuario", usuario.getTipoUsuario().toString());
        cv.put("telefono", usuario.getTelefono());

        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("usuario", null, cv);

        usuario.setId(id.intValue());

        db.close();
    }

    private void eliminar(Usuario usuario){
        ContentValues cv = new ContentValues();
        cv.clear();
    }

    public List<Usuario> buscar(){

        //Lista donde se iran agregando los usuaris
        List<Usuario> usuarios = new ArrayList<>();

        //Columnas a buscar en la base de datos
        String columnas[] = new String[] {"id", "nombre", "email", "telefono", "tipo_usuario"};

        //Abrir conexion a la base de datos (SOLO LECTURA)
        SQLiteDatabase db = connection.getReadableDatabase();

        //Ejecutamos el consulta
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            Usuario u = new Usuario();
            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setTipoUsuario(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipo_usuario"))));

            usuarios.add(u);

            cursor.moveToNext();

        }

        cursor.close();
        db.close();

        return usuarios;

    }

}
