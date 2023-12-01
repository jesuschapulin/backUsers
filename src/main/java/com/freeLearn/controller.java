package com.freeLearn;

import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.Response;
import org.json.simple.parser.JSONParser;

import org.json.*;

/**
 *
 * @author wailf
 */
@Stateless
@LocalBean
public class controller {
    conectionDB connDB;
   
    public String getAllUsersADEA(){
		String response="";
		try {
			connDB=new conectionDB();
			response=connDB.getAllUsersADEA("select * from usuariosadea");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
        public String getOneUserADEA(String login, String pass){
		String response="";
		try {
			connDB=new conectionDB();
                        String encodedUrl = Base64.getUrlEncoder().encodeToString(pass.getBytes());
                        System.out.println("contra :::"+encodedUrl);
			response=connDB.getOneUserADEA("select * from usuariosadea where LOGIN='"+login+"' and PASSWORD='"+encodedUrl+"'");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
        public String getUserADEAByLogin(String login){
		String response="";
		try {
			connDB=new conectionDB();
			response=connDB.getOneUserADEA("select * from usuariosadea where LOGIN='"+login+"'");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
        public String searchUsersADEA(String words){
		String response="";
		try {
			connDB=new conectionDB();
                        System.out.println("words :::"+words);
			response=connDB.getAllUsersADEA("select * from usuariosadea where NOMBRE like'%"+words+"%'");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
         public String searchUsersADEAactive(String active){
		String response="";
		try {
			connDB=new conectionDB();
                        System.out.println("words :::"+active);
			response=connDB.getAllUsersADEA("select * from usuariosadea where STATUS like'%"+active+"%'");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
          public String getUsersADEAByDate(String date1,String date2){
		String response="";
		try {
			connDB=new conectionDB();
                        System.out.println("words :::"+date1);
			response=connDB.getAllUsersADEA("select * from usuariosadea where FECHAALTA BETWEEN to_date('"+date1+"') and to_date('"+date2+"')");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
        public String deleteUserADEA(String login, String pass){
		String response="";
		try {
			connDB=new conectionDB();
                        String encodedUrl = Base64.getUrlEncoder().encodeToString(pass.getBytes());
                        System.out.println("contra :::"+encodedUrl);
			response=connDB.deleteUserADEA("delete from usuariosadea where LOGIN='"+login+"'");
                        System.out.println("se ejecuto query en controller:::");
                } 
                catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
        public String alterUserADEA(String login, String nombre,String cliente, String apaterno,String amaterno,String estado,String dateRegs){
		String response="";
		try {
			connDB=new conectionDB();
                        String pass="1425";
                        String encodedUrl = Base64.getUrlEncoder().encodeToString(pass.getBytes());
                        System.out.println("contra :::"+encodedUrl);
			response=connDB.alterUserADEA(
                            "UPDATE usuariosadea\n" +
                            "SET \n" +
                            "NOMBRE='"+nombre+"',\n" +
                            "CLIENTE="+cliente+",\n" +
                            "EMAIL='"+login+"@"+login+"',\n" +
                            "FECHAALTA='"+dateRegs+"',\n" +
                            "FECHABAJA=sysdate,\n" +
                            "STATUS='"+(estado.equals("A") ? 'A' : estado.equals("B") ? 'B' : estado.equals("R") ? 'R' : '0' )+"',\n" +
                            "INTENTOS=0,\n" +
                            "FECHAREVOCADO=sysdate,\n" +
                            "FECHA_VIGENCIA=sysdate,\n" +
                            "NO_ACCESO=1,\n" +
                            "APELLIDO_PATERNO='"+apaterno+"',\n" +
                            "APELLIDO_MATERNO='"+amaterno+"',\n" +
                            "AREA=1,\n" +
                            "FECHAMODIFICACION=sysdate\n" +
                            "where LOGIN='"+login+"'\n" +
                            ""
                        );
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por caracteres:::");
                            e.printStackTrace();
                }catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
         public String setOneUserADEA(String login, String pass,String nombre,String amaterno,String apaterno,String cliente,String estado,String dateRegs){
		String response="";
		try {
                    System.out.println("recibe :::"+pass);
			connDB=new conectionDB();
                        String secretx64="";
                        secretx64=""+pass;
                        ///secretx64 = Base64.getEncoder().encodeToString(pass.getBytes());
                        String encodedUrl = Base64.getUrlEncoder().encodeToString(pass.getBytes());
                        System.out.println("contra :::"+encodedUrl);
			response=connDB.setOneUserADEA(
                                    "INSERT INTO usuariosadea VALUES (\n" +
                                    "'"+login+"',\n" +
                                    " '"+encodedUrl+"',\n" +
                                    " '"+nombre+"',\n" +
                                    " "+cliente+",\n" +
                                    " '"+nombre+"@"+nombre+"',\n" +
                                    " '"+dateRegs+"',\n" +
                                    " sysdate,\n" +
                                    "'"+(estado.equals("A") ? 'A' : estado.equals("B") ? 'B' : estado.equals("R") ? 'R' : '0' )+"',\n" +
                                    " 0,\n" +
                                    " sysdate,\n" +
                                    " sysdate,\n" +
                                    " 1,\n" +
                                    " '"+amaterno+"',\n" +
                                    " '"+apaterno+"',\n" +
                                    " 1,\n" +
                                    " sysdate \n" +
                                    " )");
                        System.out.println("se ejecuto query en controller:::");
                } 
                    catch (NullPointerException e){
                            System.out.println("fallo por algo vacio:::");
                            e.printStackTrace();
                }
                catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
    public Response getHeaders(String resultado) {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Content-Type", "text/plain;charset=UTF-8")
                .header("Access-Control-Max-Age", "1209600")
                .entity(resultado)
                .build();
    }
}
