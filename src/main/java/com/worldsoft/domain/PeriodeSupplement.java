package com.worldsoft.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the PERIODE_SUPPLEMENT database table.
 * 
 */
@Entity
@Table(name = "PERIODE_SUPPLEMENT")
@NamedQuery(name = "PeriodeSupplement.findAll", query = "SELECT p FROM PeriodeSupplement p")
public class PeriodeSupplement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeriodeSupplementPK id;

	private String actif;

	@Column(name = "PRIX_SUPP")
	private BigDecimal prixSupp;

	// bi-directional many-to-one association to Jour
	@ManyToOne
	@JoinColumn(name = "ID_JOUR", insertable = false, updatable = false)
	private Jour jour;

	// bi-directional many-to-one association to Periode
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_PERIODE", referencedColumnName = "ID_PERIODE", insertable = false, updatable = false) })
	private Periode periode;

	// bi-directional many-to-one association to Supplement
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_SUPP", referencedColumnName = "ID_SUPP", insertable = false, updatable = false) })
	private Supplement supplement;

	public PeriodeSupplement() {
	}

	public PeriodeSupplementPK getId() {
		return this.id;
	}

	public void setId(PeriodeSupplementPK id) {
		this.id = id;
	}

	public String getActif() {
		return this.actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}

	public BigDecimal getPrixSupp() {
		return this.prixSupp;
	}

	public void setPrixSupp(BigDecimal prixSupp) {
		this.prixSupp = prixSupp;
	}

	public Jour getJour() {
		return this.jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	public Periode getPeriode() {
		return this.periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Supplement getSupplement() {
		return this.supplement;
	}

	public void setSupplement(Supplement supplement) {
		this.supplement = supplement;
	}

}