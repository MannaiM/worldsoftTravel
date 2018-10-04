package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESERVATION database table.
 * 
 */
@Embeddable
public class ReservationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_REF_TIERS", insertable=false, updatable=false)
	private long idRefTiers;

	@Column(name="ID_RESERV")
	private long idReserv;

	public ReservationPK() {
	}
	public long getIdRefTiers() {
		return this.idRefTiers;
	}
	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}
	public long getIdReserv() {
		return this.idReserv;
	}
	public void setIdReserv(long idReserv) {
		this.idReserv = idReserv;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservationPK)) {
			return false;
		}
		ReservationPK castOther = (ReservationPK)other;
		return 
			(this.idRefTiers == castOther.idRefTiers)
			&& (this.idReserv == castOther.idReserv);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idRefTiers ^ (this.idRefTiers >>> 32)));
		hash = hash * prime + ((int) (this.idReserv ^ (this.idReserv >>> 32)));
		
		return hash;
	}
}