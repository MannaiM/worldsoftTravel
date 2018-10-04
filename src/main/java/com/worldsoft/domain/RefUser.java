package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the REF_USERS database table.
 * 
 */
@Entity
@Table(name = "REF_USERS")
@NamedQuery(name = "RefUser.findAll", query = "SELECT r FROM RefUser r")
public class RefUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USERS")
	private long idUsers;

	@Column(name = "NOM_USER")
	private String nomUser;

	@Column(name = "USER_LOGIN")
	private String userLogin;

	@Column(name = "USER_PWD")
	private String userPwd;

	public RefUser(long idUsers) {
		super();
		this.idUsers = idUsers;
	}

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "ID_ROLE")
	private Role role;

	public RefUser() {
	}

	public long getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(long idUsers) {
		this.idUsers = idUsers;
	}

	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}