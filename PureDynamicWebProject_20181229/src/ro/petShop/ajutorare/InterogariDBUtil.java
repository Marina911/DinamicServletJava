package ro.petShop.ajutorare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.petShop.incapsulare.Client;
import ro.petShop.incapsulare.Animal;
import ro.petShop.incapsulare.Specie;

public class InterogariDBUtil {

	public static void insertAnimal(int idSpecie, String culoare, int pret) throws Exception {

		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			int id = getIdForNewAnimal();
			preparedStatement = connect.prepareStatement("INSERT INTO animale(id_animal, id_specieAnimal, culoare, pret) VALUES (?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, idSpecie);
			preparedStatement.setString(3, culoare);
			preparedStatement.setInt(4, pret);
			
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
	}
	
	
	
	private static int getIdForNewAnimal() throws Exception {
		int idAnimalNou = 0;
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		 
		try {	
			preparedStatement = connect.prepareStatement("(SELECT MAX(id_animal) AS maxId FROM animale)");
			rezultat = preparedStatement.executeQuery();
			while(rezultat.next()) {
				idAnimalNou = rezultat.getInt("maxId");
			}
			System.out.println("Id-ul pentru noul animal va fi: "+(idAnimalNou+1));
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return idAnimalNou +1;
	}
	
	public static List<Animal> getAllAnimale() throws Exception {
		 
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Animal> listaAnimale =  new ArrayList<Animal>();
		 
		try {
				
			preparedStatement = connect.prepareStatement("SELECT id_animal, specieAnimal, culoare, pret " + 
															"FROM animale " + 
															"INNER JOIN speciideanimale " + 
															"ON animale.id_specieAnimal = speciideanimale.id_specieAnimal ");
			
			rezultat = preparedStatement.executeQuery();
			
			System.out.println("\nLista tuturor animalelor:\n");
	
			while(rezultat.next()) {
				
				Animal animal = new Animal();
				
				animal.setIdAnimal(rezultat.getInt("id_animal"));
				Specie specieAnimal = new Specie();
				specieAnimal.setNumeSpecie(rezultat.getString("specieAnimal"));
				animal.setSpecieAnimal(specieAnimal);
				animal.setCuloare(rezultat.getString("culoare"));
				animal.setPret(Integer.parseInt(rezultat.getString("pret")));
				
				listaAnimale.add(animal);
				
			}
			
			System.out.println("Animalul este: " +listaAnimale);
			
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}

		return listaAnimale;
	}
	
	public static void deleteAnimal(int idAnimal) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			deleteAnimalDinVanzare(idAnimal);
			preparedStatement = connect.prepareStatement("DELETE FROM animale WHERE id_animal = ?");
			preparedStatement.setInt(1, idAnimal);
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}
	
	private static void deleteAnimalDinVanzare(int idAnimal) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connect.prepareStatement("DELETE FROM vanzare WHERE id_animal = ?");
			preparedStatement.setInt(1, idAnimal);
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}

	public static Animal getAnimalById(int idAnimal) throws Exception {
		Animal animal = new Animal(); 
		animal.setIdAnimal(idAnimal);
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		 
		try {
				
			preparedStatement = connect.prepareStatement("SELECT specieAnimal, culoare, pret " + 
															"FROM animale " + 
															"INNER JOIN speciideanimale " + 
															"ON animale.id_specieAnimal = speciideanimale.id_specieAnimal " +
															" WHERE id_animal = ?");
			
			preparedStatement.setInt(1, idAnimal);
			rezultat = preparedStatement.executeQuery();
			
			System.out.println("\nLista tuturor animalelor pe baza id-ului cautat:\n");
	
			while(rezultat.next()) {
				
				animal.setCuloare(rezultat.getString("culoare"));
				animal.setPret(Integer.parseInt(rezultat.getString("pret")));
				
				Specie specieAnimalGasit = new Specie();
				
				specieAnimalGasit.setNumeSpecie(rezultat.getString("specieAnimal"));
				animal.setSpecieAnimal(specieAnimalGasit);
			}
			
			System.out.println("Animalul este: " +animal);
			
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return animal;
	}

	public static void updateAnimal(Animal animalNou) throws Exception {

		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connect.prepareStatement("UPDATE animale SET culoare = ?, pret = ? WHERE id_animal = ?");
			preparedStatement.setString(1, animalNou.getCuloare());
			preparedStatement.setInt(2, animalNou.getPret());
			preparedStatement.setInt(3, animalNou.getIdAnimal());
			preparedStatement.execute();

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}

	}
	
	public static List<Animal> getAnimaleBetweenPret(int pret1, int pret2) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Animal> animal = new ArrayList<Animal>();
	
		try {
			
		preparedStatement = connect.prepareStatement("SELECT id_animal, specieAnimal, culoare, pret " + 
													"FROM animale " + 
													"INNER JOIN speciideanimale " + 
													"ON animale.id_specieAnimal = speciideanimale.id_specieAnimal " + 
													"WHERE pret BETWEEN ? AND ?");
		preparedStatement.setInt(1, pret1);
		preparedStatement.setInt(2, pret2);
		
		rezultat = preparedStatement.executeQuery();
		
		while(rezultat.next()) {
			
			Animal animale = new Animal();
			animale.setIdAnimal(rezultat.getInt("id_animal"));
			Specie specie = new Specie();
			specie.setNumeSpecie(rezultat.getString("specieAnimal"));
			animale.setSpecieAnimal(specie);
			animale.setCuloare(rezultat.getString("culoare"));
			animale.setPret(Integer.parseInt(rezultat.getString("pret")));
			
			animal.add(animale);

		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return animal;
	}
	
	
	public static void insertClient(String numeClient, String prenumeClient, String localitate) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			
			int id = getIdForNewClient();
			
			preparedStatement = connect.prepareStatement("INSERT INTO client(id_client, nume, prenume, localitate) VALUES (?,?,?,?)");
	
			preparedStatement.setInt(1, id);
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

	private static int getIdForNewClient() throws Exception {
		int idClientNou = 0;
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		 
		try {	
			preparedStatement = connect.prepareStatement("SELECT MAX(id_client) AS maxId FROM client");
			rezultat = preparedStatement.executeQuery();
			while(rezultat.next()) {
				idClientNou = rezultat.getInt("maxId");
			}
			System.out.println("Id-ul pentru noul client va fi: "+(idClientNou+1));
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return idClientNou +1;
	}
	
	public static List<Client> getAllClienti() throws Exception {
		 
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Client> clienti =  new ArrayList<Client>();
		 
		try {
			
			preparedStatement = connect.prepareStatement("SELECT id_client, nume, prenume, localitate FROM client");
			
			rezultat = preparedStatement.executeQuery();
			
			System.out.println("\nLista tuturor clientilor:\n");
	
			while(rezultat.next()) {
				
				Client client = new Client();
				
				client.setIdClient(rezultat.getInt("id_client"));
				client.setNume(rezultat.getString("nume"));
				client.setPrenume(rezultat.getString("prenume"));
				client.setLocalitate(rezultat.getString("localitate"));
				
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
	
	public static List<Client> getClientByName(String numeClient) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		List<Client> client = new ArrayList<Client>();
	
		try {
			
		preparedStatement = connect.prepareStatement("SELECT id_client, nume, prenume, localitate FROM client WHERE nume = ?");
		preparedStatement.setString(1, numeClient);
		rezultat = preparedStatement.executeQuery();
		
		while(rezultat.next()) {
			
			Client clienti = new Client();
			clienti.setIdClient(rezultat.getInt("id_client"));
			clienti.setNume(rezultat.getString("nume"));
			clienti.setPrenume(rezultat.getString("prenume"));
			clienti.setLocalitate(rezultat.getString("localitate"));
			
			client.add(clienti);

		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return client;
	}
	
	
	public static void updateClient(Client clientDeModificat) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connect.prepareStatement("UPDATE client SET  nume = ?, prenume = ?, localitate = ? WHERE id_client = ?");
			preparedStatement.setString(1, clientDeModificat.getNume());
			preparedStatement.setString(2, clientDeModificat.getPrenume());
			preparedStatement.setString(3, clientDeModificat.getLocalitate());
			preparedStatement.setInt(4, clientDeModificat.getIdClient());
			
			preparedStatement.execute();
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, null);
		}
		
	}
	
	
	public static Client getClientById(int idClient) throws Exception {		
		Client client = new Client();
		client.setIdClient(idClient);
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		
		try {
			
		preparedStatement = connect.prepareStatement("SELECT nume, prenume, localitate FROM client WHERE id_client = ?");
		
		preparedStatement.setInt(1, idClient);
		rezultat = preparedStatement.executeQuery();
		
		System.out.println("\nLista tuturor clientilor:\n");

		while(rezultat.next()) {
			
			client.setNume(rezultat.getString("nume"));
			client.setPrenume(rezultat.getString("prenume"));
			client.setLocalitate(rezultat.getString("localitate"));
			
		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		return client;
	}
	
	
	public static void deleteClient(int idClient) throws Exception {
		
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
	
	
}
