package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the REF_UTILISATEUR database table.
 * 
 */
@Entity
@Table(name = "REF_UTILISATEUR")
@NamedQuery(name = "RefUtilisateur.findAll", query = "SELECT r FROM RefUtilisateur r")
public class RefUtilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_UTILISATEUR")
	private long idUtilisateur;

	@Column(name = "LOG_UTILISATEUR")
	private String logUtilisateur;

	@Column(name = "NOM_REF_UTILISATEUR")
	private String nomRefUtilisateur;

	@Column(name = "PASSW_UTILISATEUR")
	private String passwUtilisateur;

	@Column(name = "ID_REF_TIERS")
	private long idRefTiers;

	// bi-directional many-to-one association to RefTier
	@ManyToOne
	@JoinColumn(name = "ID_REF_TIERS", insertable = false, updatable = false)
	private RefTier refTier;

	public RefUtilisateur() {
	}

	public long getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogUtilisateur() {
		return this.logUtilisateur;
	}

	public void setLogUtilisateur(String logUtilisateur) {
		this.logUtilisateur = logUtilisateur;
	}

	public String getNomRefUtilisateur() {
		return this.nomRefUtilisateur;
	}

	public void setNomRefUtilisateur(String nomRefUtilisateur) {
		this.nomRefUtilisateur = nomRefUtilisateur;
	}

	public String getPasswUtilisateur() {
		return this.passwUtilisateur;
	}

	public void setPasswUtilisateur(String passwUtilisateur) {
		this.passwUtilisateur = passwUtilisateur;
	}

	public RefTier getRefTier() {
		return this.refTier;
	}

	public void setRefTier(RefTier refTier) {
		this.refTier = refTier;
	}

	public RefUtilisateur(long idUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
	}

	public long getIdRefTiers() {
		return idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

}