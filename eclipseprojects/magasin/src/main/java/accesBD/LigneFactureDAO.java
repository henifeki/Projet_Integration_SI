package accesBD;

import java.sql.Connection;
import javax.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import Entites.*;
public class LigneFactureDAO {
	public void save (Facture f,LigneFacture lf) 
	{
		Connection cnx=SConnection.getInstance();
		int n = 0;
		try 
		{
			PreparedStatement pstm1 = cnx.prepareStatement("update LigneFacture set quantite=?, prix=? where numFacture=? and refProduit=?");
			pstm1.setInt(1, lf.getQuantite());
			pstm1.setFloat(2, lf.getPrix());
			pstm1.setString(3, f.getNumero());
			pstm1.setString(4, lf.getProd().getReference());
			n = pstm1.executeUpdate();
			System.out.println("Mise a jour effectu�e avec succes");
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		try 
		{
			if(n==0)
			{
				PreparedStatement pstm = cnx.prepareStatement("Insert into LigneFacture(refProduit, numFacture, quantite,prix) values (?,?,?,?)");
				pstm.setString(1, lf.getProd().getReference());
				pstm.setString(2, f.getNumero());
				pstm.setInt(3, lf.getQuantite());
				pstm.setFloat(4, lf.getPrix());
				n= pstm.executeUpdate();
			}
		}catch(SQLException e)
		{
			System.out.println("le client existe d�ja");
			
		}
		finally 
		{
			SConnection.close();
		}	
	}
	public void delete(Facture f, Produit p) {
		int n=0;
		String rq="delete from lignefacture where numFacture=? and refProduit=?";
		Connection cnx= SConnection.getInstance();
		
	
			try {
				PreparedStatement st= cnx.prepareStatement(rq);
				st = cnx.prepareStatement(rq);
				st.setString(1, f.getNumero());
				st.setString(2, p.getReference());
				n= st.executeUpdate();
				
			if(n==1)
				System.out.println("La ligne facture a �t� supprim�e avec succ�s");
			else 
				System.out.println("Aucune ligne facture n'a �t� supprim�e ");

			  }
		 catch (SQLException e) {
			System.out.println("Exception dans la suppression de ligne facture ");

		 	}
			finally {
				SConnection.close();
			}
	}
	public Collection<LigneFacture> findAllByFacture (Facture f){
		Connection cnx=SConnection.getInstance();
		Collection<LigneFacture>  clignefactures = null ;
	try
	{
		PreparedStatement pstm = cnx.prepareStatement("select * from LigneFacture where numFacture=?"); 
		pstm.setString(1, f.getNumero());
		ResultSet rset = pstm.executeQuery();
		while(rset.next()) {
			String refprod = rset.getString("refproduit");
			PreparedStatement pstm1 = cnx.prepareStatement("select libelle, prix from produit where reference =?");
			pstm1.setString(1, refprod);
			ResultSet rset1 = pstm1.executeQuery();
			if(rset1.next()) {
				rset1.getString(1);
				int quantite = rset.getInt("quantite");
				float prix = rset.getFloat("prix");
				String lib = rset1.getString("libelle");
				float prx = rset1.getFloat("prix");
				Produit prod = new Produit(refprod, prx, lib);
				LigneFacture lf = new LigneFacture(prix, prod, quantite);
				clignefactures.add(lf);
			}
		}
	}catch(SQLException ex)
	{
		System.out.println("");
	}
	finally{
		SConnection.close();
	}
	return clignefactures;
	}
	}

