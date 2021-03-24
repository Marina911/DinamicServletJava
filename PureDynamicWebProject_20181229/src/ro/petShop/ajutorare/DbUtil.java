package ro.petShop.ajutorare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

private static Connection connect = null;
	

	public static Connection getConnection() throws Exception {
		
	String DB = "petshop";
	String USERNAME ="root";
	String PASSWORD =null;
	 
	try {
		//String driver = "com.mysql.cj.jdbc.Driver";
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
   
        }
		
		String url = "jdbc:mysql://127.0.0.1:3306/"+DB; //+"?autoReconnect=true&useSSL=false"
	
		connect = DriverManager.getConnection(url, USERNAME, PASSWORD);
		
		if(connect!=null) {
			System.out.println("Conectat!");
		}else {
			System.out.println("Nu s-a putut conecta!");
		}
		
	}catch(SQLException sqlexception){
		System.out.println("sqlexception: "+sqlexception);
		throw new Exception("Eroare: Nu s-a putut realiza conexiunea :'( O_o");
	}
	return connect;
}

	public static void closeAll(Connection connect, PreparedStatement preparedStm, ResultSet resultSet) {
		
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(preparedStm != null) {
			try {
				preparedStm.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
		if(connect != null) {
			try {
				connect.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
		}
		
	}


}
