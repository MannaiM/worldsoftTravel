package com.worldsoft.model;

import java.util.List;

public class ArrangementModel {
	// private List<String> hotels;

	private long idarr;
	private String nomarr;
	private String labArr;
	private String idHotel;

	public long getIdarr() {
		return idarr;
	}

	public void setIdarr(long idarr) {
		this.idarr = idarr;
	}

	public String getNomarr() {
		return nomarr;
	}

	public void setNomarr(String nomarr) {
		this.nomarr = nomarr;
	}

	public ArrangementModel(long idarr, String nomarr) {
		super();
		this.idarr = idarr;
		this.nomarr = nomarr;
	}

	public String getLabArr() {
		return labArr;
	}

	public void setLabArr(String labArr) {
		this.labArr = labArr;
	}

	public ArrangementModel(long idarr, String nomarr, String labArr, long idHotel) {
		super();
		this.idarr = idarr;
		this.nomarr = nomarr;
		this.labArr = labArr;
		this.idHotel = idHotel + "";
	}

	public ArrangementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ArrangementModel [idarr=" + idarr + ", nomarr=" + nomarr + ", labArr=" + labArr + ", idHotel=" + idHotel
				+ "]";
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

}
