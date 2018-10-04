package com.worldsoft.model;

public class AvionModel {
	private long idavion;
	private String airline;
	private String nomavion;
	private String typeAv;
	private String abrvAv;

	public AvionModel(long idavion, String nomavion) {
		super();
		this.idavion = idavion;
		this.nomavion = nomavion;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNomavion() {
		return nomavion;
	}

	public void setNomavion(String nomavion) {
		this.nomavion = nomavion;
	}

	public AvionModel(long idavion, String airline, String nomavion) {
		super();
		this.setIdavion(idavion);
		this.airline = airline;
		this.nomavion = nomavion;
	}

	public String getTypeAv() {
		return typeAv;
	}

	public void setTypeAv(String typeAv) {
		this.typeAv = typeAv;
	}

	public String getAbrvAv() {
		return abrvAv;
	}

	public void setAbrvAv(String abrvAv) {
		this.abrvAv = abrvAv;
	}

	public AvionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdavion() {
		return idavion;
	}

	public void setIdavion(long idavion) {
		this.idavion = idavion;
	}

	public AvionModel(long idavion, String airline, String nomavion, String typeAv, String abrvAv) {
		super();
		this.idavion = idavion;
		this.airline = airline;
		this.nomavion = nomavion;
		this.typeAv = typeAv;
		this.abrvAv = abrvAv;
	}

	public AvionModel(String airline) {
		super();
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "AvionModel [idavion=" + idavion + ", airline=" + airline + ", nomavion=" + nomavion + ", typeAv="
				+ typeAv + ", abrvAv=" + abrvAv + "]";
	}

	
	

}