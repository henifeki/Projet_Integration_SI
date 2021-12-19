package com.mag.magasin;

import java.util.Collection;

import Entites.Client;
import accesBD.ClientDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/client")
public class ClientSw {

	@Path("search")
	@GET
	@Produces("application/json")
	public Collection<Client>getClient()
	{
		
		Collection<Client>clients = ClientDAO.findAll();
		System.out.println(clients);
		return clients ;
	}
	
	@Path("{code}")
	@GET
	@Produces("application/json")
	  public Client getClientById(@PathParam("code") String code ) {
		
		Client cli = ClientDAO.findById(code); 
		System.out.println(cli);
		return cli;
       
    }
	@Path("add/{code}/{nom}")
	@POST
	
	@Produces("application/json")
	public Client addClient(@PathParam("code") String code, @PathParam("nom")String nom ) 
	{
		System.out.println("hhhhhh");
		Client cli = new Client(code,nom); 
		System.out.println(cli);
		ClientDAO.save(cli);
		return cli;
       
    }
	@Path("remove/{code}")
	@DELETE
	@Produces("application/json")
	public void removeClient(@PathParam("code") String code) 
	{
		System.out.println("hhhhhh");
		ClientDAO.delete(code);
		
       
    }
}
