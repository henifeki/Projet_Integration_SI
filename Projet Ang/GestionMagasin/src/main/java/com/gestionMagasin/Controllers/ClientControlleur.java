package com.gestionMagasin.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionMagasin.DAO.ClientDAO;
import com.gestionMagasin.metier.Client;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/client")
public class ClientControlleur {
	
	
	@Autowired
	ClientDAO cldao;
	
	
	@RequestMapping(value="/find", method = RequestMethod.GET)
	@CrossOrigin
	public Collection<Client> getAllClients()
	{
		List<Client> list = new ArrayList<Client>();
		list = cldao.findAll();
		System.out.println("listed");
		return list;
	}
	
	
	
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	@CrossOrigin
	public Client addClient(@RequestBody Client client) {
		
		
		cldao.save(client);
		return client;
	}
	
	

}
