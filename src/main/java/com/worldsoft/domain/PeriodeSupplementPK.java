package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PERIODE_SUPPLEMENT database table.
 * 
 */
@Embeddable
public class PeriodeSupplementPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_HOTEL", insertable=false, updatable=false)
	private long idHotel;

	@Column(name="ID_SUPP", insertable=false, updatable=false)
	private long idSupp;

	@Column(name="ID_PERIODE", insertable=false, updatable=false)
	private long idPeriode;

	@Column(name="ID_JOUR", insertable=false, updatable=false)
	private long idJour;

	public PeriodeSupplementPK() {
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
	public long getIdPeriode() {
		return this.idPeriode;
	}
	public void setIdPeriode(long idPeriode) {
		this.idPeriode = idPeriode;
	}
	public long getIdJour() {
		return this.idJour;
	}
	public void setIdJour(long idJour) {
		this.idJour = idJour;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PeriodeSupplementPK)) {
			return false;
		}
		PeriodeSupplementPK castOther = (PeriodeSupplementPK)other;
		return 
			(this.idHotel == castOther.idHotel)
			&& (this.idSupp == castOther.idSupp)
			&& (this.idPeriode == castOther.idPeriode)
			&& (this.idJour == castOther.idJour);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idHotel ^ (this.idHotel >>> 32)));
		hash = hash * prime + ((int) (this.idSupp ^ (this.idSupp >>> 32)));
		hash = hash * prime + ((int) (this.idPeriode ^ (this.idPeriode >>> 32)));
		hash = hash * prime + ((int) (this.idJour ^ (this.idJour >>> 32)));
		
		return hash;
	}
}