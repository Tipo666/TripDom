package edu.itla.tripdom.dao;
import android.content.Context;

/**
 * Created by Tipo666 on 11/26/2017.
 */

public class PublicacionDbo {

    private DbConnection connection;
    public PublicacionDbo(Context context){
        connection = new DbConnection(context);
    }
}