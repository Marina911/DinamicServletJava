package ro.petShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ro.petShop.ajutorare.DbUtil;

public class SpeciiDeAnimale {
	
	
	private int idSpecie;
	private String specie;
	
	public SpeciiDeAnimale() {

	}
	
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	
	
	
	public String getSpecieById(int id) throws Exception {
		
		Connection connect = DbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rezultat = null;
		String specie_animal = null;
		try {
			
		preparedStatement = connect.prepareStatement("SELECT  specieAnimal " + 
													"FROM speciideanimale " +
													"WHERE id_specieAnimal = ?");
		preparedStatement.setInt(1, id);
		rezultat = preparedStatement.executeQuery();
		
		System.out.println("\nLista tuturor animalelor:\n");

		while(rezultat.next()) {
			specie_animal = rezultat.getString("specieAnimal");

			System.out.println("Specie animal: " +specie_animal);
		}
		
		}catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}finally {
			DbUtil.closeAll(connect, preparedStatement, rezultat);
		}
		
		return specie_animal;
		
	}

	
	
}
