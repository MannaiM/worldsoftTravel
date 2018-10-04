package com.worldsoft.model;



public class PromotionModel {
	

	private long idhotel;
	private String idchm;
	private String idjour;
	private long idPromo;
	private String abrvP ;
	private String lablP ;
	private String flag ;

	

	public PromotionModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getIdhotel() {
		return idhotel;
	}



	public void setIdhotel(long idhotel) {
		this.idhotel = idhotel;
	}



	public String getIdchm() {
		return idchm;
	}



	public void setIdchm(String idchm) {
		this.idchm = idchm;
	}



	public String getIdjour() {
		return idjour;
	}



	public void setIdjour(String idjour) {
		this.idjour = idjour;
	}



	public long getIdPromo() {
		return idPromo;
	}



	public void setIdPromo(long idPromo) {
		this.idPromo = idPromo;
	}



	public String getAbrvP() {
		return abrvP;
	}



	public void setAbrvP(String abrvP) {
		this.abrvP = abrvP;
	}



	public String getLablP() {
		return lablP;
	}



	public void setLablP(String lablP) {
		this.lablP = lablP;
	}



	public String getFlag() {
		return flag;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}



	public PromotionModel(long idhotel, String idchm, String idjour, long idPromo, String abrvP) {
		super();
		this.idhotel = idhotel;
		this.idchm = idchm;
		this.idjour = idjour;
		this.idPromo = idPromo;
		this.abrvP = abrvP;
	}
	


	
	
	


	

}
