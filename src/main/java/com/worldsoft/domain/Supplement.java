package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUPPLEMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Supplement.findAll", query="SELECT s FROM Supplement s")
public class Supplement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SupplementPK id;

	@Column(name="ABRV_SUPP")
	private String abrvSupp;

	@Column(name="ACTIF_SUPP")
	private String actifSupp;

	@Column(name="L_SUPP")
	private String lSupp;

	

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="ID_HOTEL", insertable = false, updatable = false)
	private Hotel hotel;

	public Supplement() {
	}

	public SupplementPK getId() {
		return this.id;
	}

	public void setId(SupplementPK id) {
		this.id = id;
	}

	public String getAbrvSupp() {
		return this.abrvSupp;
	}

	public void setAbrvSupp(String abrvSupp) {
		this.abrvSupp = abrvSupp;
	}

	public String getActifSupp() {
		return this.actifSupp;
	}

	public void setActifSupp(String actifSupp) {
		this.actifSupp = actifSupp;
	}

	public String getLSupp() {
		return this.lSupp;
	}

	public void setLSupp(String lSupp) {
		this.lSupp = lSupp;
	}


	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}