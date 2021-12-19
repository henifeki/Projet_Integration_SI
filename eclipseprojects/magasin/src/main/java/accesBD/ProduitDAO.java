package accesBD;
import java.sql.Connection;

import java.sql.*;
import Entites.*;
public class ProduitDAO {

	public void save (Produit p) {
		
			Connection cnx=SConnection.getInstance();
			int n = 0;
			try 
			{
				PreparedStatement pstm1 = cnx.prepareStatement("update Produit set  libelle=? , prix=? where reference=?");
				pstm1.setString(1, p.getLibelle());
				pstm1.setFloat(2, p.getPrix());
				pstm1.setString(3, p.getReference());
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
					PreparedStatement pstm = cnx.prepareStatement("Insert into produit(reference, libelle, prix) values (?,?,?)");
					pstm.setString(1, p.getLibelle());
					pstm.setFloat(2, p.getPrix());
					pstm.setString(3, p.getReference());
					n= pstm.executeUpdate();
				}
			}catch(SQLException e)
			{
				System.out.println("le produit existe d�ja");
				
			}
			finally 
			{
				SConnection.close();
			}	
		}

	public void delete(Produit p) {
		int n=0;
		String rq="delete from produit where reference=?";
		Connection cnx= SConnection.getInstance();
		
	
			try {
				PreparedStatement st= cnx.prepareStatement(rq);
				st = cnx.prepareStatement(rq);
				st.setString(1, p.getReference());
				n= st.executeUpdate();
				
			if(n==1)
				System.out.println("Le produit a �t� supprim�e avec succ�s");
			else 
				System.out.println("Aucun Produit n'a �t� supprim�e ");

			  }
		 catch (SQLException e) {
			System.out.println("Exception dans la suppression du produit ");

		 	}
			finally {
				SConnection.close();
			}
	}
	
	public Produit findAllByReference (	String ref){
		Connection cnx=SConnection.getInstance();
		Produit prod = new Produit(ref, 0, "");
	try
	{
			PreparedStatement pstm1 = cnx.prepareStatement("select libelle, prix from produit where reference =?");
			pstm1.setString(1, ref);
			ResultSet rset1 = pstm1.executeQuery();
			if(rset1.next()) {
				rset1.getString(1);
				float prix = rset1.getFloat("prix");
				String lib = rset1.getString("libelle");
				prod = new Produit(ref, prix, lib);
			}
			
	}catch(SQLException ex)
	{
		System.out.println("");
	}
	finally{
		SConnection.close();
	}
	return prod;
	}
}
