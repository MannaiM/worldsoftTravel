package com.worldsoft.model;

public class ReductionModel {

	private String abrvReduction;
	private String actifReduction;
	private String lReduction;
	
	private long idHotel;
	private long idPeriode;
	private long idReduction;
	private String flag;
	
	public String getAbrvReduction() {
		return abrvReduction;
	}
	public void setAbrvReduction(String abrvReduction) {
		this.abrvReduction = abrvReduction;
	}
	public String getActifReduction() {
		return actifReduction;
	}
	public void setActifReduction(String actifReduction) {
		this.actifReduction = actifReduction;
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
	public long getIdReduction() {
		return idReduction;
	}
	public void setIdReduction(long idReduction) {
		this.idReduction = idReduction;
	}
	public ReductionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReductionModel(String abrvReduction, String actifReduction, String lReduction, long idHotel, long idPeriode,
			long idReduction) {
		super();
		this.abrvReduction = abrvReduction;
		this.actifReduction = actifReduction;
		this.lReduction = lReduction;
		this.idHotel = idHotel;
		this.idPeriode = idPeriode;
		this.idReduction = idReduction;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
