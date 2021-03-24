package ro.petShop.incapsulare;
import ro.petShop.incapsulare.Specie;

public class Animal {

	private int idAnimal;
	private int idSpecie;
	private String culoare;
	private int pret; 
	private Specie specieAnimal;
	
	public Animal(){
		
	}
	
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public int getIdSpecie() {
		return idSpecie;
	}
	public void setIdSpecie(int idSpecie) {
		this.idSpecie = idSpecie;
	}
	public String getCuloare() {
		return culoare;
	}
	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public Specie getSpecieAnimal() {
		return specieAnimal;
	}
	public void setSpecieAnimal(Specie specieAnimal) {
		this.specieAnimal = specieAnimal;
	}
	
	
}
