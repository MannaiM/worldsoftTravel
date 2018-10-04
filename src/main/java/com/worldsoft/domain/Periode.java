package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERIODE database table.
 * 
 */
@Entity
@NamedQuery(name="Periode.findAll", query="SELECT p FROM Periode p")
public class Periode implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PeriodePK id;

	@Column(name="ABRV_PERIODE")
	private String abrvPeriode;

	private String closed;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_DEBUT")
	private Date dtDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIN")
	private Date dtFin;

	@Column(name="L_PERIODE")
	private String lPeriode;

	
	
	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

	

	public Periode() {
	}

	public PeriodePK getId() {
		return this.id;
	}

	public void setId(PeriodePK id) {
		this.id = id;
	}

	public String getAbrvPeriode() {
		return this.abrvPeriode;
	}

	public void setAbrvPeriode(String abrvPeriode) {
		this.abrvPeriode = abrvPeriode;
	}

	public String getClosed() {
		return this.closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public Date getDtDebut() {
		return this.dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Date getDtFin() {
		return this.dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

	public String getLPeriode() {
		return this.lPeriode;
	}

	public void setLPeriode(String lPeriode) {
		this.lPeriode = lPeriode;
	}

	

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}




}