package ro.petShop.incapsulare;

public class Client {

	private int idClient;
	private String nume;
	private String prenume;
	private String localitate;
	
	public Client() {
		
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getLocalitate() {
		return localitate;
	}
	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}
	
}
