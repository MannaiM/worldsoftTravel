package com.worldsoft.model;

public class classVolModel {
	private long idClassVol;
	private String nomClass;
	private String lblClass;
	private String idAv;

	public long getIdClassVol() {
		return idClassVol;
	}

	public void setIdClassVol(long idClassVol) {
		this.idClassVol = idClassVol;
	}

	public String getNomClass() {
		return nomClass;
	}

	public void setNomClass(String nomClass) {
		this.nomClass = nomClass;
	}

	public classVolModel(long idClassVol, String nomClass) {
		super();
		this.idClassVol = idClassVol;
		this.nomClass = nomClass;
	}

	public String getIdAv() {
		return idAv;
	}

	public void setIdAv(String idAv) {
		this.idAv = idAv;
	}

	public classVolModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLblClass() {
		return lblClass;
	}

	public void setLblClass(String lblClass) {
		this.lblClass = lblClass;
	}

	@Override
	public String toString() {
		return "classVolModel [idClassVol=" + idClassVol + ", nomClass=" + nomClass + ", lblClass=" + lblClass
				+ ", idAv=" + idAv + "]";
	}

	public classVolModel(long idClassVol, String nomClass, String lblClass) {
		super();
		this.idClassVol = idClassVol;
		this.nomClass = nomClass;
		this.lblClass = lblClass;
	}

}
