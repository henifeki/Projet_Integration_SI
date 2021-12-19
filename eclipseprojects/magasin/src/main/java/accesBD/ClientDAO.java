package accesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Entites.Client;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

public class ClientDAO {
	
	
	public static Collection<Client> findAll()  
	{	Collection<Client> clients = new ArrayList<Client>();
		Connection cnx=SConnection.getInstance();
		try {
		PreparedStatement pstm = cnx.prepareStatement("SELECT * from Client ");
		ResultSet rset = pstm.executeQuery();
		while(rset.next()) {
			String code = rset.getString("code");
			String nom = rset.getString("nom");
			Client cl = new Client(code,nom);
			clients.add(cl);
			}
		
		
		return clients;}
		catch(SQLException e)
		{
			System.out.println("pas de client  ");
			System.out.println(e.getMessage());
		}
		finally {
			SConnection.close();
		}
		return null;
		
	}
	public static Client findById(String code)  
	{
		Connection cnx=SConnection.getInstance();
		try {
		PreparedStatement pstm = cnx.prepareStatement("SELECT nom from Client where code =?");
		pstm.setString(1,code);
		ResultSet rset = pstm.executeQuery();
		if(rset.next()) {
			String nom = rset.getString("nom");
			Client cl = new Client(code,nom);
			return cl;
			}
		System.out.println("pas de client avec le code : "+code);
		return null;}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			SConnection.close();
		}
		return null;
	}

	
	public static void save(Client c) {
		Connection cnx = SConnection.getInstance();
		String code = c.getCode();
		String nom = c.getNom();
		int n=0;
		try {  
		PreparedStatement pstm = cnx.prepareStatement("INSERT INTO client VALUES (?,?)");
		pstm.setString(1, code);
		pstm.setString(2, nom);
		n= pstm.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println("le client existe d�ja");
		}
		try
		{if(n==0)
		{
			PreparedStatement pstm1 = cnx.prepareStatement("update client set nom=? where code=?");
			pstm1.setString(1, nom);
			pstm1.setString(2, code);
			n = pstm1.executeUpdate();
			System.out.println("Mise a jour effectu�e avec succes");
		}
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			SConnection.close();
		}
	}
	public static void delete(String c) {
		Connection cnx = SConnection.getInstance();
		try {
			PreparedStatement pstm = cnx.prepareStatement("delete from client  where code=?");
			pstm.setString(1,c);
			pstm.executeUpdate();
			System.out.println("etat = 0 ");
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally 
		{
			SConnection.close();
		}	
	}
	public static void main(String[] args) {
		System.out.println(ClientDAO.findAll());
	}
}
