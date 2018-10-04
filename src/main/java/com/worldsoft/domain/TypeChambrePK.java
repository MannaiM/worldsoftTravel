package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TYPE_CHAMBRE database table.
 * 
 */
@Embeddable
public class TypeChambrePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;
   
	@Column(name="ID_CHM")
	private long idChm;

	public TypeChambrePK() {
	}
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdChm() {
		return this.idChm;
	}
	public void setIdChm(long idChm) {
		this.idChm = idChm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TypeChambrePK)) {
			return false;
		}
		TypeChambrePK castOther = (TypeChambrePK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idChm == castOther.idChm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idChm ^ (this.idChm >>> 32)));
		
		return hash;
	}
	public TypeChambrePK(long idHotel, long idChm) {
		super();
		this.idHotel = idHotel;
		this.idChm = idChm;
	}
}