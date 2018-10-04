package com.worldsoft.model;

import java.math.BigDecimal;
import java.util.List;

public class mvtPrixHotelModel {
	private List<String> jours;
	private List<String> arrangements;
	private List<String> typeChambres;
	private String idHotel;
	private String idPeriode;
	private String prixVente;
	private String marge;
	private String prixAchat;
	private String nbreChm;
	private BigDecimal idPrix;
	private String idArrangement;
	private String idChm;


	

	@Override
	public String toString() {
		return "mvtPrixHotelModel [jours=" + jours + ", arrangements=" + arrangements + ", typeChambres=" + typeChambres
				+ ", idHotel=" + idHotel + ", idPeriode=" + idPeriode + ", prixVente=" + prixVente + ", marge=" + marge
				+ ", prixAchat=" + prixAchat + ", nbreChm=" + nbreChm + ", idPrix=" + idPrix + ", idArrangement="
				+ idArrangement + ", idChm=" + idChm + "]";
	}

	public mvtPrixHotelModel() {
		super();
	}

	public List<String> getJours() {
		return jours;
	}

	public void setJours(List<String> jours) {
		this.jours = jours;
	}

	public List<String> getArrangements() {
		return arrangements;
	}

	public void setArrangements(List<String> arrangements) {
		this.arrangements = arrangements;
	}

	public List<String> getTypeChambres() {
		return typeChambres;
	}

	public void setTypeChambres(List<String> typeChambres) {
		this.typeChambres = typeChambres;
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdPeriode() {
		return idPeriode;
	}

	public void setIdPeriode(String idPeriode) {
		this.idPeriode = idPeriode;
	}

	public String getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(String prixAchat) {
		this.prixAchat = prixAchat;
	}

	public String getMarge() {
		return marge;
	}

	public void setMarge(String marge) {
		this.marge = marge;
	}

	public String getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(String prixVente) {
		this.prixVente = prixVente;
	}

	public String getNbreChm() {
		return nbreChm;
	}

	public void setNbreChm(String nbreChm) {
		this.nbreChm = nbreChm;
	}

	public mvtPrixHotelModel(List<String> jours, List<String> arrangements, List<String> typeChambres, String idHotel,
			String idPeriode, String prixVente, String marge, String prixAchat, String nbreChm) {
		super();
		this.jours = jours;
		this.arrangements = arrangements;
		this.typeChambres = typeChambres;
		this.idHotel = idHotel;
		this.idPeriode = idPeriode;
		this.prixVente = prixVente;
		this.marge = marge;
		this.prixAchat = prixAchat;
		this.nbreChm = nbreChm;
		
		
	}


	public String getIdChm() {
		return idChm;
	}

	public void setIdChm(String idChm) {
		this.idChm = idChm;
	}

	public mvtPrixHotelModel( long idPeriode, BigDecimal prixVente, BigDecimal marge, BigDecimal prixAchat,
			BigDecimal nbreChm, BigDecimal idPrix, long idArrangement, long idChm) {
		super();
		
		this.idPeriode = idPeriode+"";
		this.prixVente = prixVente+"";
		this.marge = marge.toString();
		this.prixAchat = prixAchat+"";
		this.nbreChm = nbreChm.toString();
		this.idPrix=idPrix;
		this.idArrangement=idArrangement+"";
		this.idChm = idChm+"";
	}

	public String getIdArrangement() {
		return idArrangement;
	}

	public void setIdArrangement(String idArrangement) {
		this.idArrangement = idArrangement;
	}

	public BigDecimal getIdPrix() {
		return idPrix;
	}

	public void setIdPrix(BigDecimal idPrix) {
		this.idPrix = idPrix;
	}

	public mvtPrixHotelModel(List<String> jours, String idHotel, String idPeriode, BigDecimal idPrix) {
		super();
		this.jours = jours;
		this.idHotel = idHotel;
		this.idPeriode = idPeriode;
		this.idPrix = idPrix;
	}
	
	

}
