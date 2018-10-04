package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ARRANGEMENT database table.
 * 
 */
@Entity
@Table(name = "ARRANGEMENT")
@NamedQuery(name="Arrangement.findAll", query="SELECT a FROM Arrangement a")
public class Arrangement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArrangementPK id;

	@Column(name="ABRV_ARRANGEMENT")
	private String abrvArrangement;

	@Column(name="L_ARRANGEMENT")
	private String lArrangement;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

	//bi-directional many-to-one association to MvmentPrix
	

	public Arrangement() {
	}

	public ArrangementPK getId() {
		return this.id;
	}

	public void setId(ArrangementPK id) {
		this.id = id;
	}

	public String getAbrvArrangement() {
		return this.abrvArrangement;
	}

	public void setAbrvArrangement(String abrvArrangement) {
		this.abrvArrangement = abrvArrangement;
	}

	public String getLArrangement() {
		return this.lArrangement;
	}

	public void setLArrangement(String lArrangement) {
		this.lArrangement = lArrangement;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
}