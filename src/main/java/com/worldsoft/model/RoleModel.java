package com.worldsoft.model;

public class RoleModel {
	private long idRol;
	private String lRol;
	private String abrvRol;

	public RoleModel(long idRol, String lRol) {
		super();
		this.idRol = idRol;
		this.lRol = lRol;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getlRol() {
		return lRol;
	}

	public void setlRol(String lRol) {
		this.lRol = lRol;
	}

	public String getAbrvRol() {
		return abrvRol;
	}

	public void setAbrvRol(String abrvRol) {
		this.abrvRol = abrvRol;
	}

}
