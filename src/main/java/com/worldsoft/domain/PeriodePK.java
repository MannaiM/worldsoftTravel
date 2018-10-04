package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERIODE database table.
 * 
 */
@Embeddable
public class PeriodePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;

	@Column(name="ID_PERIODE")
	private long idPeriode;

	public PeriodePK() {
	}
	public long getIdHotel() {
		return this.idHotel;
	}
	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	public long getIdPeriode() {
		return this.idPeriode;
	}
	public void setIdPeriode(long idPeriode) {
		this.idPeriode = idPeriode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeriodePK)) {
			return false;
		}
		PeriodePK castOther = (PeriodePK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idPeriode == castOther.idPeriode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPeriode ^ (this.idPeriode >>> 32)));
		
		return hash;
	}
	public PeriodePK(long idHotel, long idPeriode) {
		super();
		this.idHotel = idHotel;
		this.idPeriode = idPeriode;
	}
	
}