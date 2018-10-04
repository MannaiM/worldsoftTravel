package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AVION database table.
 * 
 */
@Entity
@NamedQuery(name="Avion.findAll", query="SELECT a FROM Avion a")
public class Avion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AVION")
	private long idAvion;

	@Column(name="ABRV_AVION")
	private String abrvAvion;

	private String airline;

	@Column(name="NOM_AVION")
	private String nomAvion;

	@Column(name="TYPE_AVION")
	private String typeAvion;

	//bi-directional many-to-one association to ClassVol
	@OneToMany(mappedBy="avion")
	private List<ClassVol> classVols;

	//bi-directional many-to-one association to MvmentPrix
	
	public Avion() {
	}

	public long getIdAvion() {
		return this.idAvion;
	}

	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}

	public String getAbrvAvion() {
		return this.abrvAvion;
	}

	public void setAbrvAvion(String abrvAvion) {
		this.abrvAvion = abrvAvion;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNomAvion() {
		return this.nomAvion;
	}

	public void setNomAvion(String nomAvion) {
		this.nomAvion = nomAvion;
	}

	public String getTypeAvion() {
		return this.typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public List<ClassVol> getClassVols() {
		return this.classVols;
	}

	public void setClassVols(List<ClassVol> classVols) {
		this.classVols = classVols;
	}

	public ClassVol addClassVol(ClassVol classVol) {
		getClassVols().add(classVol);
		classVol.setAvion(this);

		return classVol;
	}

	public ClassVol removeClassVol(ClassVol classVol) {
		getClassVols().remove(classVol);
		classVol.setAvion(null);

		return classVol;
		
	}

}