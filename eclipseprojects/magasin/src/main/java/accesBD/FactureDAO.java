package accesBD;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Entites.*;
public class FactureDAO {
	
	public void save (Facture f) {
		
		Connection cnx=SConnection.getInstance();
		int n = 0;
		try 
		{
			PreparedStatement pstm1 = cnx.prepareStatement("update Facture set  datefacture=? , codeclient=? where numero=?");
			pstm1.setDate(1, Date.valueOf(f.getDatefacture()));
			pstm1.setString(2, f.getClient().getCode());
			pstm1.setString(3, f.getNumero());
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
				PreparedStatement pstm = cnx.prepareStatement("Insert into facture(numero,datefacture, codeclient) values (?,?,?)");
				pstm.setString(1, f.getNumero());
				pstm.setDate(2, Date.valueOf(f.getDatefacture()));
				pstm.setString(3, f.getClient().getCode());
				n= pstm.executeUpdate();
			}
		}catch(SQLException e)
		{
			System.out.println("la facture existe d�ja");
			
		}
		finally 
		{
			SConnection.close();
		}	
	}
	public void delete(Facture f) {
		int n=0;
		String rq="delete from facture where numero=?";
		Connection cnx= SConnection.getInstance();
		
	
			try {
				PreparedStatement st= cnx.prepareStatement(rq);
				st = cnx.prepareStatement(rq);
				st.setString(1, f.getNumero());
				n= st.executeUpdate();
				
			if(n==1)
				System.out.println("La facture a �t� supprim�e avec succ�s");
			else 
				System.out.println("Aucune facture n'a �t� supprim�e ");

			  }
		 catch (SQLException e) {
			System.out.println("Exception dans la suppression de la facture ");

		 	}
			finally {
				SConnection.close();
			}
	}
/*	public Produit findAllByNumero (String num){
		Connection cnx=SConnection.getInstance();
		Facture fact = new Facture();
	try
	{
		
			PreparedStatement pstm1 = cnx.prepareStatement("select * from Lignefacture where numero =?");
			pstm1.setString(1, num);
			ResultSet rset1 = pstm1.executeQuery();
			if(rset1.next()) {
				float prix = rset1.getFloat(0);
				String ref = rset1.getString(1);
				int qte = rset1.getInt(2);
				ProduitDAO pdao = new ProduitDAO();
				Produit p = pdao.findAllByReference(ref);
				LigneFacture lf = new LigneFacture(prix, p ,qte );
				fact.getLignes().add(lf);
			}
			PreparedStatement pstm = cnx.prepareStatement("select * from facture where numero =?");
			pstm1.setString(1, num);
			ResultSet rset = pstm1.executeQuery();
			if(rset.next()) {
				//= rset1.getString(0);
			}
				
	}catch(SQLException ex)
	{
		System.out.println("");
	}
	finally{
		SConnection.close();
	}
	
	return prod;
	}*/
}

