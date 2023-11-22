package com.freeLearn;

import com.freeLearn.service.MessageService;


import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.freeLearn.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/service")
public class Service {
    controller API;
    public Service(){
        
        API=new controller();
    }
    @Path("getUsersADEA")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response getUsersADEA(){
            String response="";
            String url="";		   

            try {
                    response = API.getAllUsersADEA();
                    System.out.println("Se consulto service de ADEA:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("getUsersADEAByName/{words}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response getUsersADEAByName(@PathParam("words") String words){
            String response="";
            String url="";		   

            try {
                    response = API.searchUsersADEA(words);
                    System.out.println("Se consulto service de ADEA:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("getUsersADEAByActive/{active}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response getUsersADEAByActive(@PathParam("active") String active){
            String response="";
            String url="";		   

            try {
                    response = API.searchUsersADEAactive(active);
                    System.out.println("Se consulto service de ADEA:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("getUsersADEAByDate/{date1}/{date2}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response getUsersADEAByDate(@PathParam("date1") String date1,@PathParam("date2") String date2){
            String response="";
            String url="";		   

            try {
                    response = API.getUsersADEAByDate(date1,date2);
                    System.out.println("Se consulto service de ADEA:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("getOneUserADEA/{login}/{secret}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response getOneUserADEA(@PathParam("login") String login,@PathParam("secret") String pass){
            String response="";
            String url="";		   

            try {
                    response = API.getOneUserADEA(login,pass);
                    System.out.println("Se consulto service de ADEA solo uno:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("setOneUserADEA/{login}/{secret}/{nombre}/{apaterno}/{amaterno}/{cliente}/{estado}/{dateRegs}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response setOneUserADEA(@PathParam("login") String login,@PathParam("secret") String secret,
            @PathParam("nombre") String nombre ,@PathParam("apaterno") String apaterno,@PathParam("amaterno") String amaterno,
             @PathParam("cliente") String cliente,@PathParam("estado") String estado,@PathParam("dateRegs") String dateRegs){
            String response="";
            String url="";		   

            try {
                System.out.println("entra :::"+ secret);
                    response = API.setOneUserADEA(login,secret,nombre,amaterno,apaterno,cliente,estado,dateRegs);
                    System.out.println("Se creo usuario de ADEA solo uno:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    @Path("alterUserADEA/{login}/{nombre}/{cliente}/{apaterno}/{amaterno}/{estado}/{dateRegs}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response alterUserADEA(@PathParam("login") String login,
            @PathParam("nombre") String nombre, @PathParam("cliente") String cliente,@PathParam("apaterno") String apaterno,@PathParam("amaterno") String amaterno,
            @PathParam("estado") String estado,@PathParam("dateRegs") String dateRegs
            ){
            String response="";
            String url="";		   

            try {
                System.out.println("entra :::"+ login);
                    response = API.alterUserADEA(login,nombre,cliente,apaterno,amaterno,estado,dateRegs);
                    System.out.println("Se edito usuario de ADEA solo uno:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

             return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
    
    @Path("deleteUserADEA/{login}/{secret}")
    @GET
    @Produces("text/plain; charset=UTF-8")
    public Response deleteUserADEA(@PathParam("login") String login,@PathParam("secret") String secret){
            String response="";
            String url="";		   

            try {
                System.out.println("entra :::"+ secret);
                    response = API.deleteUserADEA(login,secret);
                    System.out.println("Se creo usuario de ADEA solo uno:::"+ response);
            }catch(Exception ex){
                    System.out.println("error pagina:::"+ url);
                    ex.printStackTrace();
            }

            return Response.ok()
               .entity(response)
               .header("Access-Control-Allow-Origin", "*")
               .build();
    }
}
