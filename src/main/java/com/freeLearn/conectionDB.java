
package com.freeLearn;

/**
 *
 * @author wailf
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import org.json.JSONArray;

import org.json.simple.JSONObject;

/**
 *
 * @author gil
 */
public class conectionDB implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	
//	static final String bd = "DBSRALYC";
//    static final String login = "procesos_internos";
//    static final String password = "r3d4lycP";
//    static final String url = "jdbc:oracle:thin:@148.215.1.155:1521:DBSRALYC";
	
	////conexion a la 2.13
//	static final String bd = "dbsralyc2";
//    static final String login = "uredalycportal";
//    static final String password = "Pr3d4lyc13x";
//    static final String url = "jdbc:oracle:thin:@148.215.2.13:1521:dbsralyc2";
   
    
    
    ///local
    static final String bd = "xe";
    static final String login = "system";
    static final String password = "oracle11g";
    static final String url = "jdbc:oracle:thin:@127.0.0.1:1521";
    
    //local copy
//	static final String bd = "xe";
//    static final String login = "system";
//    static final String password = "oracle";
//    static final String url = "jdbc:oracle:thin:@localhost:1521";  
    


    Connection conn;
    Statement st;

    public conectionDB() throws ClassNotFoundException, SQLException {
    }

    public Connection getConexion() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, login, password);
        }
        return conn;
    }

    public String getAllUsersADEA(String query){
    	System.out.println(":::::ejecuta query de busqueda:::::::::"+query);
    	String response []={""};
        String message="";
        try {
        	conectionDB c = new conectionDB();
        	Statement statement = c.getConexion().createStatement();
        	ResultSet resultado = statement.executeQuery(query);
                 JSONObject json = new JSONObject();
                 JSONArray array = new JSONArray();
        	while (resultado.next()) {
                        System.out.println("elemento de base 1 ::::::::: "+resultado.getString("NOMBRE"));
                        
                        JSONObject item = new JSONObject();
                        item.put("LOGIN",resultado.getString("LOGIN"));
                        item.put("PASSWORD",resultado.getString("PASSWORD"));
                        item.put("NOMBRE",resultado.getString("NOMBRE"));
                        item.put("CLIENTE",resultado.getString("CLIENTE"));
                        item.put("EMAIL",resultado.getString("EMAIL"));
                        item.put("FECHAALTA",resultado.getString("FECHAALTA"));
                        item.put("FECHABAJA",resultado.getString("FECHABAJA"));
                        item.put("STATUS",resultado.getString("STATUS"));
                        item.put("INTENTOS",resultado.getString("INTENTOS"));
                        item.put("FECHAREVOCADO",resultado.getString("FECHAREVOCADO"));
                        item.put("FECHA_VIGENCIA",resultado.getString("FECHA_VIGENCIA"));
                        item.put("NO_ACCESO",resultado.getString("NO_ACCESO"));
                        item.put("APELLIDO_PATERNO",resultado.getString("APELLIDO_PATERNO"));
                        item.put("APELLIDO_MATERNO",resultado.getString("APELLIDO_MATERNO"));
                        item.put("AREA",resultado.getString("AREA"));
                        item.put("FECHAMODIFICACION",resultado.getString("FECHAMODIFICACION"));

                        array.put(item);
                        
                }
                /////json.put("usuarios", array);
                message = array.toString();
            try{
            	c.finalize();
            
            } catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
        } catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("fallo conexion den connDB no se pudo correr el query:::::::::");
        	ex.printStackTrace();
            Logger.getLogger(conectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("fallo conexion den connDB ocurrio un error externo:::::::::");
            e.printStackTrace();
        }
        return message;
    }
    public String getOneUserADEA(String query){
    	System.out.println(":::::ejecuta query de busqueda solo uno:::::::::"+query);
        String message="";
        try {
        	conectionDB c = new conectionDB();
        	Statement statement = c.getConexion().createStatement();
        	ResultSet resultado = statement.executeQuery(query);
                 JSONObject json = new JSONObject();
                 JSONArray array = new JSONArray();
        	while (resultado.next()) {
                        System.out.println("elemento de base 1 ::::::::: "+resultado.getString("NOMBRE"));
                        
                        JSONObject item = new JSONObject();
                        item.put("LOGIN",resultado.getString("LOGIN"));
                        item.put("PASSWORD",resultado.getString("PASSWORD"));
                        item.put("NOMBRE",resultado.getString("NOMBRE"));
                        item.put("CLIENTE",resultado.getString("CLIENTE"));
                        item.put("EMAIL",resultado.getString("EMAIL"));
                        item.put("FECHAALTA",resultado.getString("FECHAALTA"));
                        item.put("FECHABAJA",resultado.getString("FECHABAJA"));
                        item.put("STATUS",resultado.getString("STATUS"));
                        item.put("INTENTOS",resultado.getString("INTENTOS"));
                        item.put("FECHAREVOCADO",resultado.getString("FECHAREVOCADO"));
                        item.put("FECHA_VIGENCIA",resultado.getString("FECHA_VIGENCIA"));
                        item.put("NO_ACCESO",resultado.getString("NO_ACCESO"));
                        item.put("APELLIDO_PATERNO",resultado.getString("APELLIDO_PATERNO"));
                        item.put("APELLIDO_MATERNO",resultado.getString("APELLIDO_MATERNO"));
                        item.put("AREA",resultado.getString("AREA"));
                        item.put("FECHAMODIFICACION",resultado.getString("FECHAMODIFICACION"));

                        array.put(item);
                        
                }
                System.out.println("resultado ::::::::: "+array.length());
                if(array.length()>0){
                    message = array.toString();
                }
                if(array.length()==0){
                    JSONObject jsone = new JSONObject();
                    JSONArray arraye = new JSONArray();
                    System.out.println("elemento no existe ::::::::: ");
                    JSONObject iteme = new JSONObject();
                    iteme.put("messaje", "fallo");
                    iteme.put("error", "no existe");
                    arraye.put(iteme);
                    jsone.put("resultado", arraye);
                    message = jsone.toString();
                }
            try{
            	c.finalize();
            
            } catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
        } catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("fallo conexion den connDB no se pudo correr el query:::::::::");
        	ex.printStackTrace();
            Logger.getLogger(conectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("fallo conexion den connDB ocurrio un error externo:::::::::");
            e.printStackTrace();
        }
        return message;
    }
    public String setOneUserADEA(String query){
    	System.out.println(":::::ejecuta query de crear solo uno:::::::::"+query);
        String message="";
        try {
        	conectionDB c = new conectionDB();
        	Statement statement = c.getConexion().createStatement();
        	ResultSet resultado = statement.executeQuery(query);
                 JSONObject json = new JSONObject();
                 JSONArray array = new JSONArray();
        	System.out.println("elemento de base creado ::::::::: ");
                        JSONObject item = new JSONObject();
                        item.put("messaje","creado");
                        item.put("error","xxxxx");
                        array.put(item);
                ///json.put("resultado", array);
                message = array.toString();
            try{
            	c.finalize();
            
            } catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
                                
			}
        } catch(SQLIntegrityConstraintViolationException  sql ){
            JSONObject jsone = new JSONObject();
            JSONArray arraye = new JSONArray();
            System.out.println("elemento de base creado ::::::::: ");
            JSONObject iteme = new JSONObject();
            iteme.put("messaje", "fallo");
            iteme.put("error", "ya existe el usuario");
            arraye.put(iteme);
            ///jsone.put("resultado", arraye);
            message = arraye.toString();
        }
        catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("fallo conexion den connDB no se pudo correr el query:::::::::");
        	ex.printStackTrace();
            Logger.getLogger(conectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("fallo conexion den connDB ocurrio un error externo:::::::::");
            e.printStackTrace();
        }
        return message;
    }
    public String alterUserADEA(String query){
    	System.out.println(":::::ejecuta query de crear solo uno:::::::::"+query);
        String message="";
        try {
        	conectionDB c = new conectionDB();
        	Statement statement = c.getConexion().createStatement();
        	ResultSet resultado = statement.executeQuery(query);
                 JSONObject json = new JSONObject();
                 JSONArray array = new JSONArray();
        	System.out.println("elemento de base editado ::::::::: ");
                        JSONObject item = new JSONObject();
                        item.put("messaje","modificado");
                        item.put("error","xxxxx");
                        array.put(item);
                //json.put("resultado", array);
                message = array.toString();
            try{
            	c.finalize();
            
            } catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
                                
			}
        } catch(SQLIntegrityConstraintViolationException  sql ){
            JSONObject jsone = new JSONObject();
            JSONArray arraye = new JSONArray();
            System.out.println("elemento de base no modificado ::::::::: ");
            JSONObject iteme = new JSONObject();
            iteme.put("messaje", "fallo");
            iteme.put("error", "el usuario no se pudo modificar verificar datos");
            arraye.put(iteme);
            ///jsone.put("resultado", arraye);
            message = arraye.toString();
        }
        catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("fallo conexion den connDB no se pudo correr el query:::::::::");
        	ex.printStackTrace();
            Logger.getLogger(conectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("fallo conexion den connDB ocurrio un error externo:::::::::");
            e.printStackTrace();
        }
        return message;
    }
    public String deleteUserADEA(String query){
    	System.out.println(":::::ejecuta query de crear solo uno:::::::::"+query);
        String message="";
        try {
        	conectionDB c = new conectionDB();
        	Statement statement = c.getConexion().createStatement();
        	///ResultSet resultado = statement.executeQuery(query);
                int deleted = statement.executeUpdate(query);
                 JSONObject json = new JSONObject();
                 JSONArray array = new JSONArray();
        	System.out.println("elemento de base borrado ::::::::: ");
                        JSONObject item = new JSONObject();
                        item.put("messaje","borrado");
                        item.put("error","xxxxx");
                        array.put(item);
                ////json.put("resultado", array);
                message = item.toString();
                
                if(deleted==0){
                    JSONObject jsone = new JSONObject();
                    JSONArray arraye = new JSONArray();
                    System.out.println("elemento de base no borrado ::::::::: ");
                    JSONObject iteme = new JSONObject();
                    iteme.put("messaje", "fallo");
                    iteme.put("error", "el usuario no se pudo borrar verificar datos");
                    arraye.put(iteme);
                    ////jsone.put("resultado", arraye);
                    message = item.toString();
                }
            try{
            	c.finalize();
            
            } catch (Throwable e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
                                
			}
        } 
        catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("fallo conexion den connDB no se pudo correr el query:::::::::");
        	ex.printStackTrace();
            Logger.getLogger(conectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            System.out.println("fallo conexion den connDB ocurrio un error externo:::::::::");
            e.printStackTrace();
        }
        return message;
    }
}

