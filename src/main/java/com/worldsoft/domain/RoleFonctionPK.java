package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ROLE_FONCTION database table.
 * 
 */
@Embeddable
public class RoleFonctionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FONCTION", insertable=false, updatable=false)
	private long idFonction;

	@Column(name="ID_ROLE", insertable=false, updatable=false)
	private long idRole;

	public RoleFonctionPK() {
	}
	public long getIdFonction() {
		return this.idFonction;
	}
	public void setIdFonction(long idFonction) {
		this.idFonction = idFonction;
	}
	public long getIdRole() {
		return this.idRole;
	}
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoleFonctionPK)) {
			return false;
		}
		RoleFonctionPK castOther = (RoleFonctionPK)other;
		return 
			(this.idFonction == castOther.idFonction)
			&& (this.idRole == castOther.idRole);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFonction ^ (this.idFonction >>> 32)));
		hash = hash * prime + ((int) (this.idRole ^ (this.idRole >>> 32)));
		
		return hash;
	}
}