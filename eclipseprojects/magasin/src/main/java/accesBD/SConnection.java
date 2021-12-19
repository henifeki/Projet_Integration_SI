package accesBD ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SConnection {
	
			private static Connection  cnx ;
			private static String url="jdbc:mysql://localhost:3306/gestion_mag";
			private static String user="root";
			private static String mp="";
			//to connect to the dataBase 
			public static Connection getInstance() 
			{
				try
				{
						Class.forName("com.mysql.cj.jdbc.Driver");
						if(cnx==null)
						{cnx=DriverManager.getConnection(url,user,mp);
				
					 System.out.println("connection is successful to the database");
						}
				}catch(SQLException ex)
				{
					System.out.println("PB Dans la connexion\n");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return cnx;
			}
			
			public static void close() 
			{
				
				try
				{
					if(cnx!=null || !cnx.isClosed())
						cnx.close();

				}catch (SQLException ex)
				{
					ex.printStackTrace();
				}
			}
		
			public static void main(String[] args) {
				SConnection.getInstance(); 
			}
		}