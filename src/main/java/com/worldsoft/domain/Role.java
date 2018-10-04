package com.worldsoft.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name = "ROLE")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ROLE")
	private long idRole;

	@Column(name = "ABRV_ROLE")
	private String abrvRole;

	@Column(name = "L_ROLE")
	private String lRole;

	public Role() {
	}

	public long getIdRole() {
		return this.idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getAbrvRole() {
		return this.abrvRole;
	}

	public void setAbrvRole(String abrvRole) {
		this.abrvRole = abrvRole;
	}

	public String getLRole() {
		return this.lRole;
	}

	public void setLRole(String lRole) {
		this.lRole = lRole;
	}

}