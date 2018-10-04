package com.worldsoft.model;

import java.math.BigDecimal;
import java.util.Date;

public class ReservationModel {
	private long idRefTiers;
	private long idReserv;
	private Date dateReserv;
	private String lResr;
	private BigDecimal prix;
	public long getIdRefTiers() {
		return idRefTiers;
	}
	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}
	public long getIdReserv() {
		return idReserv;
	}
	public void setIdReserv(long idReserv) {
		this.idReserv = idReserv;
	}
	public Date getDateReserv() {
		return dateReserv;
	}
	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}
	public String getlResr() {
		return lResr;
	}
	public void setlResr(String lResr) {
		this.lResr = lResr;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public ReservationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationModel(long idRefTiers, long idReserv, Date dateReserv, String lResr, BigDecimal prix) {
		super();
		this.idRefTiers = idRefTiers;
		this.idReserv = idReserv;
		this.dateReserv = dateReserv;
		this.lResr = lResr;
		this.prix = prix;
	}
	
}
