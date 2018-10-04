package com.worldsoft.model;

public class JourModel {
	private long idjour;
	
	private String nomjour;

	public long getIdjour() {
		return idjour;
	}

	public void setIdjour(long idjour) {
		this.idjour = idjour;
	}

	public String getNomjour() {
		return nomjour;
	}

	public void setNomjour(String nomjour) {
		this.nomjour = nomjour;
	}

	public JourModel(long idjour, String nomjour) {
		super();
		this.idjour = idjour;
		this.nomjour = nomjour;
	}

	
	
}
