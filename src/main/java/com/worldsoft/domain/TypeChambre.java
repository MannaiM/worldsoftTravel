package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_CHAMBRE database table.
 * 
 */
@Entity
@Table(name="TYPE_CHAMBRE")
@NamedQuery(name="TypeChambre.findAll", query="SELECT t FROM TypeChambre t")
public class TypeChambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeChambrePK id;

	@Column(name="ABRV_CHAMBRE")
	private String abrvChambre;

	@Column(name="L_TYPE_CHM")
	private String lTypeChm;
	
	@Column(name="TYPE")
	private String typeChm;
	
	

	public String getTypeChm() {
		return typeChm;
	}

	public void setTypeChm(String typeChm) {
		this.typeChm = typeChm;
	}

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

	public TypeChambre() {
	}

	public TypeChambrePK getId() {
		return this.id;
	}

	public void setId(TypeChambrePK id) {
		this.id = id;
	}

	public String getAbrvChambre() {
		return this.abrvChambre;
	}

	public void setAbrvChambre(String abrvChambre) {
		this.abrvChambre = abrvChambre;
	}

	public String getLTypeChm() {
		return this.lTypeChm;
	}

	public void setLTypeChm(String lTypeChm) {
		this.lTypeChm = lTypeChm;
	}

	
	


	
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}