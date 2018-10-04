package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PROMOTION database table.
 * 
 */
@Entity
@NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PROMO")
	private long idPromo;

	@Column(name = "ABRV_PROMOTION")
	private String abrvPromotion;

	@Column(name = "FLAG_SERV")
	private String flagServ;

	@Column(name = "L_PROM")
	private String lProm;

	@Column(name = "ID_HOTEL", insertable = false, updatable = false)
	private long idHotel;

	@Column(name = "ID_CHM")
	private long idChm;

	// bi-directional many-to-one association to Jour
	@ManyToOne
	@JoinColumn(name = "ID_JOUR", insertable = false, updatable = false)
	private Jour jour;

	// bi-directional many-to-one association to TypeChambre
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "ID_CHM", referencedColumnName = "ID_CHM", insertable = false, updatable = false),
			@JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", insertable = false, updatable = false) })
	private TypeChambre typeChambre;

	public Promotion() {
	}

	public long getIdPromo() {
		return this.idPromo;
	}

	public void setIdPromo(long idPromo) {
		this.idPromo = idPromo;
	}

	public String getAbrvPromotion() {
		return this.abrvPromotion;
	}

	public void setAbrvPromotion(String abrvPromotion) {
		this.abrvPromotion = abrvPromotion;
	}

	public String getFlagServ() {
		return this.flagServ;
	}

	public void setFlagServ(String flagServ) {
		this.flagServ = flagServ;
	}

	public String getLProm() {
		return this.lProm;
	}

	public void setLProm(String lProm) {
		this.lProm = lProm;
	}

	public Jour getJour() {
		return this.jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	public TypeChambre getTypeChambre() {
		return this.typeChambre;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	public String getlProm() {
		return lProm;
	}

	public void setlProm(String lProm) {
		this.lProm = lProm;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public long getIdChm() {
		return idChm;
	}

	public void setIdChm(long idChm) {
		this.idChm = idChm;
	}

}