package com.worldsoft.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the REF_TIERS database table.
 * 
 */
@Entity
@Table(name="REF_TIERS")
@NamedQuery(name="RefTier.findAll", query="SELECT r FROM RefTier r")
public class RefTier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_REF_TIERS")
	private long idRefTiers;

	@Column(name="ADR_TIERS")
	private String adrTiers;

	@Column(name="EMAIL_CLIENT")
	private String emailClient;

	@Column(name="MOB_TIERS")
	private BigDecimal mobTiers;

	@Column(name="RES_SOCIAL")
	private String resSocial;

	@Column(name="SITE_TIERS")
	private String siteTiers;

	@Column(name="TEL_TIERS")
	private BigDecimal telTiers;

	@Column(name="TIERS_ACTIF")
	private String tiersActif;

	
	public RefTier() {
	}

	public RefTier(long idRefTiers) {
		super();
		this.idRefTiers = idRefTiers;
	}

	public long getIdRefTiers() {
		return this.idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public String getAdrTiers() {
		return this.adrTiers;
	}

	public void setAdrTiers(String adrTiers) {
		this.adrTiers = adrTiers;
	}

	public String getEmailClient() {
		return this.emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public BigDecimal getMobTiers() {
		return this.mobTiers;
	}

	public void setMobTiers(BigDecimal mobTiers) {
		this.mobTiers = mobTiers;
	}

	public String getResSocial() {
		return this.resSocial;
	}

	public void setResSocial(String resSocial) {
		this.resSocial = resSocial;
	}

	public String getSiteTiers() {
		return this.siteTiers;
	}

	public void setSiteTiers(String siteTiers) {
		this.siteTiers = siteTiers;
	}

	public BigDecimal getTelTiers() {
		return this.telTiers;
	}

	public void setTelTiers(BigDecimal telTiers) {
		this.telTiers = telTiers;
	}

	public String getTiersActif() {
		return this.tiersActif;
	}

	public void setTiersActif(String tiersActif) {
		this.tiersActif = tiersActif;
	}

	



	

}