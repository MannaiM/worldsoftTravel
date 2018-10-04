package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JOUR database table.
 * 
 */
@Entity
@Table(name = "JOUR")
@NamedQuery(name="Jour.findAll", query="SELECT j FROM Jour j")
public class Jour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JOUR")
	private long idJour;

	@Column(name="NOM_JOUR_")
	private String nomJour;

	@Column(name="NUM_JOUR")
	private BigDecimal numJour;

	

	public Jour() {
	}

	public long getIdJour() {
		return this.idJour;
	}

	public void setIdJour(long idJour) {
		this.idJour = idJour;
	}

	public String getNomJour() {
		return this.nomJour;
	}

	public void setNomJour(String nomJour) {
		this.nomJour = nomJour;
	}

	public BigDecimal getNumJour() {
		return this.numJour;
	}

	public void setNumJour(BigDecimal numJour) {
		this.numJour = numJour;
	}

	




}