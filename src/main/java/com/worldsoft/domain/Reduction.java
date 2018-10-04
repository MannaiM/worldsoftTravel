package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the REDUCTION database table.
 * 
 */
@Entity
@NamedQuery(name = "Reduction.findAll", query = "SELECT r FROM Reduction r")
public class Reduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReductionPK id;

	@Column(name = "ABRV_REDUCTION")
	private String abrvReduction;

	@Column(name = "ACTIF_REDUCTION")
	private String actifReduction;

	@Column(name = "FLAG_SERV")
	private String flagServ;

	@Column(name = "L_REDUCTION")
	private String lReduction;

	@Column(name = "ID_HOTEL", insertable = false, updatable = false)
	private long idHotel;

	@Column(name = "ID_PERIODE", insertable = false, updatable = false)
	private long idPeriode;

	// bi-directional many-to-one association to Periode
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false),
			@JoinColumn(name = "ID_PERIODE", referencedColumnName = "ID_PERIODE", insertable = false, updatable = false) })
	private Periode periode;

	public Reduction() {
	}

	public ReductionPK getId() {
		return this.id;
	}

	public void setId(ReductionPK id) {
		this.id = id;
	}

	public String getAbrvReduction() {
		return this.abrvReduction;
	}

	public void setAbrvReduction(String abrvReduction) {
		this.abrvReduction = abrvReduction;
	}

	public String getActifReduction() {
		return this.actifReduction;
	}

	public void setActifReduction(String actifReduction) {
		this.actifReduction = actifReduction;
	}

	public String getFlagServ() {
		return this.flagServ;
	}

	public void setFlagServ(String flagServ) {
		this.flagServ = flagServ;
	}

	public String getLReduction() {
		return this.lReduction;
	}

	public void setLReduction(String lReduction) {
		this.lReduction = lReduction;
	}

	public Periode getPeriode() {
		return this.periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public String getlReduction() {
		return lReduction;
	}

	public void setlReduction(String lReduction) {
		this.lReduction = lReduction;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public long getIdPeriode() {
		return idPeriode;
	}

	public void setIdPeriode(long idPeriode) {
		this.idPeriode = idPeriode;
	}

}