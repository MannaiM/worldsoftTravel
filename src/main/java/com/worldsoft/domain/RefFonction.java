package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the REF_FONCTION database table.
 * 
 */
@Entity
@Table(name="REF_FONCTION")
@NamedQuery(name="RefFonction.findAll", query="SELECT r FROM RefFonction r")
public class RefFonction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FONCTION")
	private long idFonction;

	@Column(name="L_FONCTION")
	private String lFonction;

	

	public RefFonction() {
	}

	public long getIdFonction() {
		return this.idFonction;
	}

	public void setIdFonction(long idFonction) {
		this.idFonction = idFonction;
	}

	public String getLFonction() {
		return this.lFonction;
	}

	public void setLFonction(String lFonction) {
		this.lFonction = lFonction;
	}

	

}