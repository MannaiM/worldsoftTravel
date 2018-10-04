package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ARRANGEMENT database table.
 * 
 */
@Embeddable
public class ArrangementPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;

	@Column(name="ID_ARRANGEMENT")
	private long idArrangement;

	
	
	
	public ArrangementPK(long idHotel, long idArrangement) {
		super();
		this.idHotel = idHotel;
		this.idArrangement = idArrangement;
	}
	public ArrangementPK() {
	}
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdArrangement() {
		return this.idArrangement;
	}
	public void setIdArrangement(long idArrangement) {
		this.idArrangement = idArrangement;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ArrangementPK)) {
			return false;
		}
		ArrangementPK castOther = (ArrangementPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idArrangement == castOther.idArrangement);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idArrangement ^ (this.idArrangement >>> 32)));
		
		return hash;
	}
}