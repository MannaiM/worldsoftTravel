package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RESERVATION database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_RESERV")
	private Date dateReserv;

	@Column(name="L_RESR")
	private String lResr;

	private BigDecimal prix;

	//bi-directional many-to-one association to RefTier
	@ManyToOne
	@JoinColumn(name="ID_REF_TIERS", insertable = false, updatable = false)
	private RefTier refTier;

	public Reservation() {
	}

	public ReservationPK getId() {
		return this.id;
	}

	public void setId(ReservationPK id) {
		this.id = id;
	}

	public Date getDateReserv() {
		return this.dateReserv;
	}

	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}

	public String getLResr() {
		return this.lResr;
	}

	public void setLResr(String lResr) {
		this.lResr = lResr;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public RefTier getRefTier() {
		return this.refTier;
	}

	public void setRefTier(RefTier refTier) {
		this.refTier = refTier;
	}

}