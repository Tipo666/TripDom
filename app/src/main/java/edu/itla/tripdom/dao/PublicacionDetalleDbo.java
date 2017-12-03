package edu.itla.tripdom.dao;

import android.content.Context;

/**
 * Created by Tipo666 on 11/27/2017.
 */

public class PublicacionDetalleDbo {

    private DbConnection connection;
    public PublicacionDetalleDbo(Context context){

        connection = new DbConnection(context);
    }

}
