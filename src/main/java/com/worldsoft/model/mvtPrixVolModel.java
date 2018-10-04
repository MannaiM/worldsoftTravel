package com.worldsoft.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class mvtPrixVolModel {
	private String idavion;
	private String prixVente;
	private String marge;
	private String prixAchat;
	private List<String> classVols;
	private Character actifPrix;
	private String dateRes;
	private String dep;
	private String arr;
	private String numVol;
	private String horrairedepart;
	private String dureeVol;
	private String idVolSegment;
	private String escale;
	private String payDest;
	private String villDest;
	private Long nbrP;
	private Long idClassVol;
	private BigDecimal idPrix;
	
	public String getIdavion() {
		return idavion;
	}

	public void setIdavion(String idavion) {
		this.idavion = idavion;
	}

	public String getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(String prixVente) {
		this.prixVente = prixVente;
	}

	public String getMarge() {
		return marge;
	}

	public void setMarge(String marge) {
		this.marge = marge;
	}

	public String getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(String prixAchat) {
		this.prixAchat = prixAchat;
	}

	public List<String> getClassVols() {
		return classVols;
	}

	public void setClassVols(List<String> classVols) {
		this.classVols = classVols;
	}

	public Character getActifPrix() {
		return actifPrix;
	}

	public void setActifPrix(Character actifPrix) {
		this.actifPrix = actifPrix;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getNumVol() {
		return numVol;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	@Override
	public String toString() {
		return "mvtPrixVolModel [idavion=" + idavion + ", prixVente=" + prixVente + ", marge=" + marge + ", prixAchat="
				+ prixAchat + ", classVols=" + classVols + ", actifPrix=" + actifPrix + ", dateRes=" + dateRes
				+ ", dep=" + dep + ", arr=" + arr + ", numVol=" + numVol + ", horrairedepart=" + horrairedepart
				+ ", dureeVol=" + dureeVol + ", idVolSegment=" + idVolSegment + ", escale=" + escale + ", payDest="
				+ payDest + ", villDest=" + villDest + ", nbrP=" + nbrP + ", idClassVol=" + idClassVol + "]";
	}

	public String getDureeVol() {
		return dureeVol;
	}

	public void setDureeVol(String dureeVol) {
		this.dureeVol = dureeVol;
	}

	public String getVolSegment() {
		return idVolSegment;
	}

	public void setVolSegment(String idVolSegment) {
		this.idVolSegment = idVolSegment;
	}

	public mvtPrixVolModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEscale() {
		return escale;
	}

	public void setEscale(String escale) {
		this.escale = escale;
	}

	public String getDateRes() {
		return dateRes;
	}

	public void setDateRes(String dateRes) {
		this.dateRes = dateRes;
	}

	public String getHorrairedepart() {
		return horrairedepart;
	}

	public void setHorrairedepart(String horrairedepart) {
		this.horrairedepart = horrairedepart;
	}

	public String getIdVolSegment() {
		return idVolSegment;
	}

	public void setIdVolSegment(String idVolSegment) {
		this.idVolSegment = idVolSegment;
	}

	public String getPayDest() {
		return payDest;
	}

	public void setPayDest(String payDest) {
		this.payDest = payDest;
	}

	public String getVillDest() {
		return villDest;
	}

	public void setVillDest(String villDest) {
		this.villDest = villDest;
	}


	public Long getNbrP() {
		return nbrP;
	}

	public void setNbrP(Long nbrP) {
		this.nbrP = nbrP;
	}

	public Long getIdClassVol() {
		return idClassVol;
	}

	public void setIdClassVol(Long idClassVol) {
		this.idClassVol = idClassVol;
	}

	public mvtPrixVolModel(String idavion, String prixVente, String marge, String prixAchat, List<String> classVols,
			Character actifPrix, String dateRes, String dep, String arr, String numVol, String horrairedepart,
			String dureeVol, String idVolSegment, String escale, String payDest, String villDest, Long nbrP,
			Long idClassVol, BigDecimal idPrix) {
		super();
		this.idavion = idavion;
		this.prixVente = prixVente;
		this.marge = marge;
		this.prixAchat = prixAchat;
		this.classVols = classVols;
		this.actifPrix = actifPrix;
		this.dateRes = dateRes;
		this.dep = dep;
		this.arr = arr;
		this.numVol = numVol;
		this.horrairedepart = horrairedepart;
		this.dureeVol = dureeVol;
		this.idVolSegment = idVolSegment;
		this.escale = escale;
		this.payDest = payDest;
		this.villDest = villDest;
		this.nbrP = nbrP;
		this.idClassVol = idClassVol;
		this.idPrix= idPrix;
	}

	
	public BigDecimal getIdPrix() {
		return idPrix;
	}

	public void setIdPrix(BigDecimal idPrix) {
		this.idPrix = idPrix;
	}

	public mvtPrixVolModel(long idavion, BigDecimal prixVente, BigDecimal marge, BigDecimal prixAchat, Character actifPrix,
			Date dateRes, String dep, String arr, String numVol, String horrairedepart, String dureeVol,
			String idVolSegment, String escale, String payDest, String villDest, BigDecimal nbrP, Long idClassVol,
			BigDecimal idPrix) {
		super();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.idavion = idavion+"";
		this.prixVente = prixVente.toString();
		this.marge = marge.toString();
		this.prixAchat = prixAchat.toString();
		this.actifPrix = actifPrix;
		this.dateRes = dateFormat.format(dateRes);
		this.dep = dep;
		this.arr = arr;
		this.numVol = numVol;
		this.horrairedepart = horrairedepart;
		this.dureeVol = dureeVol;
		this.idVolSegment = idVolSegment;
		this.escale = escale;
		this.payDest = payDest;
		this.villDest = villDest;
		this.nbrP = nbrP.longValue();
		this.idClassVol = idClassVol;
		this.idPrix = idPrix;
	}

	public mvtPrixVolModel(String idVolSegment) {
		super();
		this.idVolSegment = idVolSegment;
	}

	
	
	

}
