package com.worldsoft.model;

import java.util.Date;
import java.util.List;

public class mvtPrixSejourModel {
	private String  idavion;
	private String prixVente;
	private String marge;
	private String prixAchat;
	private List<String> jours;
	private List<String> classVols;
	private Character actifPrix;
	private Date dateRes;
	private String dep;
	private String arr;
	
	private List<String> arrangements;
	private List<String> typeChambres;
	private String idHotel;
	private String idPeriode;
	private String nbreChm;
	private String numVol;
	private String horrairedepart;
	private String dureeVol;
	private String idVolSegment;
	private String escale;
	private String payDest;
	private String villDest;
	private Long nbrP;
	private Long idClassVol;
	

	public mvtPrixSejourModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(String prixVente) {
		this.prixVente = prixVente;
	}


	public String getIdavion() {
		return idavion;
	}


	public void setIdavion(String idavion) {
		this.idavion = idavion;
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


	public List<String> getJours() {
		return jours;
	}


	public void setJours(List<String> jours) {
		this.jours = jours;
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


	public Date getDateRes() {
		return dateRes;
	}


	public void setDateRes(Date dateRes) {
		this.dateRes = dateRes;
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


	public String getNbreChm() {
		return nbreChm;
	}


	public void setNbreChm(String nbreChm) {
		this.nbreChm = nbreChm;
	}
	


	public String getNumVol() {
		return numVol;
	}


	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}


	public String getHorrairedepart() {
		return horrairedepart;
	}


	public void setHorrairedepart(String horrairedepart) {
		this.horrairedepart = horrairedepart;
	}


	public String getDureeVol() {
		return dureeVol;
	}


	public void setDureeVol(String dureeVol) {
		this.dureeVol = dureeVol;
	}


	public String getIdVolSegment() {
		return idVolSegment;
	}


	public void setIdVolSegment(String idVolSegment) {
		this.idVolSegment = idVolSegment;
	}


	public String getEscale() {
		return escale;
	}


	public void setEscale(String escale) {
		this.escale = escale;
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


	public mvtPrixSejourModel(String idavion, String prixVente, String marge, String prixAchat, List<String> jours,
			List<String> classVols, Character actifPrix, Date dateRes, String dep, String arr,
			List<String> arrangements, List<String> typeChambres, String idHotel, String idPeriode, String nbreChm) {
		super();
		this.idavion = idavion;
		this.prixVente = prixVente;
		this.marge = marge;
		this.prixAchat = prixAchat;
		this.jours = jours;
		this.classVols = classVols;
		this.actifPrix = actifPrix;
		this.dateRes = dateRes;
		this.dep = dep;
		this.arr = arr;
		this.arrangements = arrangements;
		this.typeChambres = typeChambres;
		this.idHotel = idHotel;
		this.idPeriode = idPeriode;
		this.nbreChm = nbreChm;
	}
	

}
