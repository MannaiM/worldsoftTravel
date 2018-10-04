package com.worldsoft.model;


public class TypeChambreModel {

	private String idHotel;
	private long idTCham;
	private String nomTCham;
	private String lblTCham;
	private String type;
	public long getIdTCham() {
		return idTCham;
	}
	public void setIdTCham(long idTCham) {
		this.idTCham = idTCham;
	}
	public String getNomTCham() {
		return nomTCham;
	}
	public void setNomTCham(String nomTCham) {
		this.nomTCham = nomTCham;
	}
	public TypeChambreModel(long idTCham, String nomTCham) {
		super();
		this.idTCham = idTCham;
		this.nomTCham = nomTCham;
	}
	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}
	public String getLblTCham() {
		return lblTCham;
	}
	public void setLblTCham(String lblTCham) {
		this.lblTCham = lblTCham;
	}
	public TypeChambreModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeChambreModel(long idTCham, String nomTCham, String lblTCham) {
		super();
		this.idTCham = idTCham;
		this.nomTCham = nomTCham;
		this.lblTCham = lblTCham;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
