package com.worldsoft.model;

public class HotelModel {
	public HotelModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private long idHo;
	private String NomHo;
	private String adr;
	private String ville;
	private String pays;
	private String categorieHotel;
	private String abrv;
	
	public HotelModel(String categorieHotel) {
		super();
		this.categorieHotel = categorieHotel;
	}

	public long getIdHo() {
		return idHo;
	}

	public void setIdHo(long idHo) {
		this.idHo = idHo;
	}

	public String getCategorieHotel() {
		return categorieHotel;
	}

	public void setCategorieHotel(String categorieHotel) {
		this.categorieHotel = categorieHotel;
	}

	public HotelModel(long idHo, String nomHo) {
		super();
		this.idHo = idHo;
		NomHo = nomHo;
	}

	public String getNomHo() {
		return NomHo;
	}

	public void setNomHo(String nomHo) {
		NomHo = nomHo;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getAbrv() {
		return abrv;
	}

	public void setAbrv(String abrv) {
		this.abrv = abrv;
	}

	public HotelModel(long idHo, String nomHo, String adr, String ville, String pays, 
			String abrv) {
		super();
		this.idHo = idHo;
		this.NomHo = nomHo;
		this.adr = adr;
		this.ville = ville;
		this.pays = pays;
		
		this.abrv = abrv;
	}

	public HotelModel(long idHo, String nomHo, String adr, String ville, String pays, String categorieHotel,
			String abrv) {
		super();
		this.idHo = idHo;
		NomHo = nomHo;
		this.adr = adr;
		this.ville = ville;
		this.pays = pays;
		this.categorieHotel = categorieHotel;
		this.abrv = abrv;
	}

	public HotelModel(long idHo, String nomHo, String abrv) {
		super();
		this.idHo = idHo;
		NomHo = nomHo;
		this.abrv = abrv;
	}

	
	
	
	

}
