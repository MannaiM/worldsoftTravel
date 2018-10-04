package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SUPPLEMENT database table.
 * 
 */
@Embeddable
public class SupplementPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;

	@Column(name="ID_SUPP")
	private long idSupp;

	public SupplementPK() {
	}
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdSupp() {
		return this.idSupp;
	}
	public void setIdSupp(long idSupp) {
		this.idSupp = idSupp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SupplementPK)) {
			return false;
		}
		SupplementPK castOther = (SupplementPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idSupp == castOther.idSupp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idSupp ^ (this.idSupp >>> 32)));
		
		return hash;
	}
}