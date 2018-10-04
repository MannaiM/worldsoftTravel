package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REDUCTION database table.
 * 
 */
@Embeddable
public class ReductionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;

	@Column(name="ID_PERIODE", insertable=false, updatable=false)
	private long idPeriode;

	@Column(name="ID_REDUCTION")
	private long idReduction;

	public ReductionPK() {
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
	public long getIdReduction() {
		return this.idReduction;
	}
	public void setIdReduction(long idReduction) {
		this.idReduction = idReduction;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReductionPK)) {
			return false;
		}
		ReductionPK castOther = (ReductionPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idPeriode == castOther.idPeriode)
			&& (this.idReduction == castOther.idReduction);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idPeriode ^ (this.idPeriode >>> 32)));
		hash = hash * prime + ((int) (this.idReduction ^ (this.idReduction >>> 32)));
		
		return hash;
	}
}