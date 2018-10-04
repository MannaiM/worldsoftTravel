package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CLASS_VOL database table.
 * 
 */
@Embeddable
public class ClassVolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_AVION", insertable=false, updatable=false)
	private long idAvion;

	@Column(name="ID_CLASS_VOL")
	private long idClassVol;

	public ClassVolPK() {
	}
	public long getIdAvion() {
		return this.idAvion;
	}
	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}
	public long getIdClassVol() {
		return this.idClassVol;
	}
	public void setIdClassVol(long idClassVol) {
		this.idClassVol = idClassVol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClassVolPK)) {
			return false;
		}
		ClassVolPK castOther = (ClassVolPK)other;
		return 
			(this.idAvion == castOther.idAvion)
			&& (this.idClassVol == castOther.idClassVol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idAvion ^ (this.idAvion >>> 32)));
		hash = hash * prime + ((int) (this.idClassVol ^ (this.idClassVol >>> 32)));
		
		return hash;
	}
	public ClassVolPK(long idAvion, long idClassVol) {
		super();
		this.idAvion = idAvion;
		this.idClassVol = idClassVol;
	}
	
}