package edu.itla.tripdom.dao;

/**
 * Created by Tipo666 on 11/26/2017.
 */

public class SqlHelperSchema {
    public static final String USUARIO_TABLE = "CREATE TABLE `usuario` (" + "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "`nombre`TEXT NOT NULL," + "`tipo_usuario`TEXT NOT NULL," + "`email`TEXT NOT NULL," + "`telefono`TEXT NOT NULL" + ")";


    //Crear Las restantes entidades
    public static final String PUBLICACION_DETALLE_TABLE = "CREATE TABLE IF NOT EXISTS `publicacion_detalle` (" + "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "`publicacion`TEXT NOT NULL," + "`lugar`TEXT NOT NULL," + "`descripcion`TEXT NOT NULL" + ");";

    public static final String PUBLICACION_TABLE = "CREATE TABLE IF NOT EXISTS `publicacion` (" + "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "`fecha_publicacion`TEXT NOT NULL," + "`usuario_id`INTEGER NOT NULL," + "`fecha_viaje`TEXT NOT NULL," + "`costo`REAL NOT NULL," + "`descripcion`TEXT NOT NULL," + "`estado`TEXT NOT NULL," + "`origen`TEXT NOT NULL" + ");";



}
