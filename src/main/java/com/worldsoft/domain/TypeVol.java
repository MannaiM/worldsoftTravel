package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TYPE_VOL database table.
 * 
 */
@Entity
@Table(name="TYPE_VOL")
@NamedQuery(name="TypeVol.findAll", query="SELECT t FROM TypeVol t")
public class TypeVol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TYPE_VOL")
	private long idTypeVol;

	@Column(name="ABRV_VOL")
	private BigDecimal abrvVol;

	@Column(name="CATEG_VOL")
	private String categVol;

	@Column(name="L_VOL")
	private String lVol;

	
	public TypeVol() {
	}

	public long getIdTypeVol() {
		return this.idTypeVol;
	}

	public void setIdTypeVol(long idTypeVol) {
		this.idTypeVol = idTypeVol;
	}

	public BigDecimal getAbrvVol() {
		return this.abrvVol;
	}

	public void setAbrvVol(BigDecimal abrvVol) {
		this.abrvVol = abrvVol;
	}

	public String getCategVol() {
		return this.categVol;
	}

	public void setCategVol(String categVol) {
		this.categVol = categVol;
	}

	public String getLVol() {
		return this.lVol;
	}

	public void setLVol(String lVol) {
		this.lVol = lVol;
	}

	
	
}