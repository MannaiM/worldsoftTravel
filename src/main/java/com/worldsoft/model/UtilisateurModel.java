package com.worldsoft.model;

public class UtilisateurModel {
	private long idRefTiers;
	private long idUtilisateur;
	private String nomRefUtilisateur;
	private String logUtilisateur;
	private String passwUtilisateur;

	public long getIdRefTiers() {
		return idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomRefUtilisateur() {
		return nomRefUtilisateur;
	}

	public void setNomRefUtilisateur(String nomRefUtilisateur) {
		this.nomRefUtilisateur = nomRefUtilisateur;
	}

	public String getLogUtilisateur() {
		return logUtilisateur;
	}

	public void setLogUtilisateur(String logUtilisateur) {
		this.logUtilisateur = logUtilisateur;
	}

	public String getPasswUtilisateur() {
		return passwUtilisateur;
	}

	public void setPasswUtilisateur(String passwUtilisateur) {
		this.passwUtilisateur = passwUtilisateur;
	}

	public UtilisateurModel(long idRefTiers, long idUtilisateur, String nomRefUtilisateur, String logUtilisateur,
			String passwUtilisateur) {
		super();
		this.idRefTiers = idRefTiers;
		this.idUtilisateur = idUtilisateur;
		this.nomRefUtilisateur = nomRefUtilisateur;
		this.logUtilisateur = logUtilisateur;
		this.passwUtilisateur = passwUtilisateur;
	}

	public UtilisateurModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UtilisateurModel(long idUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String toString() {
		return "UtilisateurModel [idRefTiers=" + idRefTiers + ", idUtilisateur=" + idUtilisateur
				+ ", nomRefUtilisateur=" + nomRefUtilisateur + ", logUtilisateur=" + logUtilisateur
				+ ", passwUtilisateur=" + passwUtilisateur + "]";
	}

}
