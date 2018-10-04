package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLASS_VOL database table.
 * 
 */
@Entity
@Table(name="CLASS_VOL")
@NamedQuery(name="ClassVol.findAll", query="SELECT c FROM ClassVol c")
public class ClassVol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClassVolPK id;

	@Column(name="ABRV_CLASS")
	private String abrvClass;

	@Column(name="L_CLASS")
	private String lClass;

	//bi-directional many-to-one association to Avion
	@ManyToOne
	@JoinColumn(name="ID_AVION", insertable = false, updatable = false)
	private Avion avion;

	//bi-directional many-to-one association to MvmentPrix
	

	public ClassVol() {
	}

	public ClassVolPK getId() {
		return this.id;
	}

	public void setId(ClassVolPK id) {
		this.id = id;
	}

	public String getAbrvClass() {
		return this.abrvClass;
	}

	public void setAbrvClass(String abrvClass) {
		this.abrvClass = abrvClass;
	}

	public String getLClass() {
		return this.lClass;
	}

	public void setLClass(String lClass) {
		this.lClass = lClass;
	}

	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	

	
	}

