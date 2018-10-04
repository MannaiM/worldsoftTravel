package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ROLE_FONCTION database table.
 * 
 */
@Entity
@Table(name="ROLE_FONCTION")
@NamedQuery(name="RoleFonction.findAll", query="SELECT r FROM RoleFonction r")
public class RoleFonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoleFonctionPK id;

	@Column(name="ACTIF_FONCT")
	private String actifFonct;

	//bi-directional many-to-one association to RefFonction
	@ManyToOne
	@JoinColumn(name="ID_FONCTION", insertable = false, updatable = false)
	private RefFonction refFonction;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ID_ROLE", insertable = false, updatable = false)
	private Role role;

	public RoleFonction() {
	}

	public RoleFonctionPK getId() {
		return this.id;
	}

	public void setId(RoleFonctionPK id) {
		this.id = id;
	}

	public String getActifFonct() {
		return this.actifFonct;
	}

	public void setActifFonct(String actifFonct) {
		this.actifFonct = actifFonct;
	}

	public RefFonction getRefFonction() {
		return this.refFonction;
	}

	public void setRefFonction(RefFonction refFonction) {
		this.refFonction = refFonction;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}