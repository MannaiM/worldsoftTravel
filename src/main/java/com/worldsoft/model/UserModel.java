package com.worldsoft.model;

public class UserModel {
	private long idUser;
	private String nomUser;
	private String userLogin;
	private String userPwd;
	private String nomRole;
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public UserModel(long idUser, String nomUser, String userLogin, String userPwd, String nomRole) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.userLogin = userLogin;
		this.userPwd = userPwd;
		this.setNomRole(nomRole);
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	
	
}
