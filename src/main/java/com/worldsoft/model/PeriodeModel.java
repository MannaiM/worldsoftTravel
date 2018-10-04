package com.worldsoft.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PeriodeModel {

	private long idP;
	private String nomP;
	private String lblP;
	private String dtDeb;
	private String dtFin;
	private String idHotel;
	private String close;

	public long getIdP() {
		return idP;
	}

	public void setIdP(long idP) {
		this.idP = idP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public PeriodeModel(long idP, String nomP) {
		super();
		this.idP = idP;
		this.nomP = nomP;
	}

	public String getLblP() {
		return lblP;
	}

	public void setLblP(String lblP) {
		this.lblP = lblP;
	}

	public String getDtDeb() {
		return dtDeb;
	}

	public void setDtDeb(String dtDeb) {
		this.dtDeb = dtDeb;
	}

	public String getDtFin() {
		return dtFin;
	}

	public void setDtFin(String dtFin) {
		this.dtFin = dtFin;
	}

	public PeriodeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public PeriodeModel(long idP, String nomP, String lblP) {
		super();
		this.idP = idP;
		this.nomP = nomP;
		this.lblP = lblP;
	}

	public PeriodeModel(long idP, String nomP, String lblP, Date dtDeb, Date dtFin , Long idHotel ,String close) {
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.idP = idP;
		this.nomP = nomP;
		this.lblP = lblP;
		this.dtDeb = dateFormat.format(dtDeb);
		this.dtFin = dateFormat.format(dtFin);
		this.idHotel = idHotel+"";
        this.close = close;
	}
}
