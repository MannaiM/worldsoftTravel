package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HOTEL database table.
 * 
 */
@Entity
@Table(name = "Hotel")
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HOTEL")
	private long idHotel;

	@Column(name="ABRV_HOTEL")
	private String abrvHotel;

	@Column(name="ADRE_HOTEL")
	private String adreHotel;

	@Column(name="NOM_HOTEL")
	private String nomHotel;
	@Column(name="PAYS")
	private String pays;

	@Column(name="VILLE_HOTEL")
	private String villeHotel;
	
	@Column(name="CATEGORIE")
	private String categorie;
	

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Hotel() {
	}

	public long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public String getAbrvHotel() {
		return this.abrvHotel;
	}

	public void setAbrvHotel(String abrvHotel) {
		this.abrvHotel = abrvHotel;
	}

	public String getAdreHotel() {
		return this.adreHotel;
	}

	public void setAdreHotel(String adreHotel) {
		this.adreHotel = adreHotel;
	}

	public String getNomHotel() {
		return this.nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVilleHotel() {
		return this.villeHotel;
	}

	public void setVilleHotel(String villeHotel) {
		this.villeHotel = villeHotel;
	}

	
	


}