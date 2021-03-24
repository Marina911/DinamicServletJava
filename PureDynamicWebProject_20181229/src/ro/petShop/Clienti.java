package ro.petShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ro.petShop.ajutorare.DbUtil;

public class Clienti {
	
	private int idClient;
	private String numeClient;
	private String prenumeClient;
	private String localitateClient;
	
	public Clienti() {
		
	}

	public Clienti(int idIntrodus, String numeIntrodus, String prenumeIntrodus, String localitateIntrodusa){
		
		idClient = idIntrodus;
		numeClient = numeIntrodus;
		prenumeClient = prenumeIntrodus;
		localitateClient = localitateIntrodusa;
	}
	
	

	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public String getNumeClient() {
		return numeClient;
	}



	public void setNumeClient(String numeClient) {
		this.numeClient = numeClient;
	}



	public String getPrenumeClient() {
		return prenumeClient;
	}



	public void setPrenumeClient(String prenumeClient) {
		this.prenumeClient = prenumeClient;
	}



	public String getLocalitateClient() {
		return localitateClient;
	}



	public void setLocalitateClient(String localitateClient) {
		this.localitateClient = localitateClient;
	}

	
	
	public List<Clienti> getAllClienti() throws Exception {
		 
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Clienti> clienti =  new ArrayList<Clienti>();
		 
		try {
			
			preparedStatement = connect.prepareStatement("SELECT id_client, nume, prenume, localitate FROM client");
			
			rezultat = preparedStatement.executeQuery();
			
			System.out.println("\nLista tuturor clientilor:\n");
	
			while(rezultat.next()) {
				
				Clienti client = new Clienti();
				
				client.setIdClient(rezultat.getInt("id_client"));
				client.setNumeClient(rezultat.getString("nume"));
				client.setPrenumeClient(rezultat.getString("prenume"));
				client.setLocalitateClient(rezultat.getString("localitate"));
				
				clienti.add(client);
				
			}
			
			System.out.println("Clientul este: " +clienti);
			
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		
		
		return clienti;
	
	}


	public Clienti getClientById(int id) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		Clienti client = new Clienti();
		
		try {
			
		preparedStatement = connect.prepareStatement("SELECT nume, prenume, localitate FROM client WHERE id_client = ?");
		preparedStatement.setInt(1, id);
		rezultat = preparedStatement.executeQuery();
		
		System.out.println("\nLista tuturor clientilor:\n");

		while(rezultat.next()) {
			
			client.setNumeClient(rezultat.getString("nume"));
			client.setPrenumeClient(rezultat.getString("prenume"));
			client.setLocalitateClient(rezultat.getString("localitate"));
			
		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return client;
	}

	
	public List<Clienti> getClientByName(String numeClient) throws Exception {
	
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Clienti> client = new ArrayList<Clienti>();
	
		try {
			
		preparedStatement = connect.prepareStatement("SELECT id_client, nume, prenume, localitate FROM client WHERE nume = ?");
		preparedStatement.setString(1, numeClient);
		rezultat = preparedStatement.executeQuery();
		
		while(rezultat.next()) {
			
			Clienti clienti = new Clienti();
			clienti.setIdClient(rezultat.getInt("id_client"));
			clienti.setNumeClient(rezultat.getString("nume"));
			clienti.setPrenumeClient(rezultat.getString("prenume"));
			clienti.setLocalitateClient(rezultat.getString("localitate"));
			
			client.add(clienti);

		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return client;
	}
	
		
	public void insertClient(int id_client, String numeClient, String prenumeClient, String localitate) throws Exception {
	
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connect.prepareStatement("INSERT INTO client(id_client, nume, prenume, localitate) VALUES (?,?,?,?)");
			
			preparedStatement.setInt(1, id_client);
			preparedStatement.setString(2, numeClient);
			preparedStatement.setString(3, prenumeClient);
			preparedStatement.setString(4, localitate);
			
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
	}
	
	
	public void updateClient(Clienti clientDeModificat) throws Exception {
	
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connect.prepareStatement("UPDATE client SET  nume = ?, prenume = ?, localitate = ? WHERE id_client = ?");
			preparedStatement.setString(1, clientDeModificat.getNumeClient());
			preparedStatement.setString(2, clientDeModificat.getPrenumeClient());
			preparedStatement.setString(3, clientDeModificat.getLocalitateClient());
			preparedStatement.setInt(4, clientDeModificat.getIdClient());
			
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}
	
	
	public void deleteClient(int idClient) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			deleteClientDinVanzare(idClient);
			preparedStatement = connect.prepareStatement("DELETE FROM client WHERE id_client = ?");
			preparedStatement.setInt(1, idClient);
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}
	
	private static void deleteClientDinVanzare(int idClient) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connect.prepareStatement("DELETE FROM vanzare WHERE id_client = ?");
			preparedStatement.setInt(1, idClient);
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}
	
	public String toString() {
	return "Clienti [idClient=" + idClient + ", numeClient=" + numeClient + ", prenumeClient=" + prenumeClient
			+ ", localitateClient=" + localitateClient + "]";
	}
	
}