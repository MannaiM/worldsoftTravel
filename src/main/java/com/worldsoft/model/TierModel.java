package com.worldsoft.model;

import java.math.BigDecimal;

public class TierModel {
	private long idRefTiers;

	private String resSocial;
	private String adrTiers;
	private String emailClient;
	private BigDecimal mobTiers;
	private String siteTiers;
	private String tiersActif;
	private BigDecimal telTiers;
	
	

	public TierModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TierModel(long idRefTiers, String resSocial) {
		super();
		this.idRefTiers = idRefTiers;
		this.resSocial = resSocial;
	}

	public long getIdRefTiers() {
		return idRefTiers;
	}

	public void setIdRefTiers(long idRefTiers) {
		this.idRefTiers = idRefTiers;
	}

	public String getResSocial() {
		return resSocial;
	}

	public void setResSocial(String resSocial) {
		this.resSocial = resSocial;
	}
	

	public String getAdrTiers() {
		return adrTiers;
	}

	public void setAdrTiers(String adrTiers) {
		this.adrTiers = adrTiers;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public BigDecimal getMobTiers() {
		return mobTiers;
	}

	public void setMobTiers(BigDecimal mobTiers) {
		this.mobTiers = mobTiers;
	}

	public String getSiteTiers() {
		return siteTiers;
	}

	public void setSiteTiers(String siteTiers) {
		this.siteTiers = siteTiers;
	}

	public String getTiersActif() {
		return tiersActif;
	}

	public void setTiersActif(String tiersActif) {
		this.tiersActif = tiersActif;
	}

	public BigDecimal getTelTiers() {
		return telTiers;
	}

	public void setTelTiers(BigDecimal telTiers) {
		this.telTiers = telTiers;
	}

	public TierModel(long idRefTiers, String resSocial, String adrTiers, String emailClient, BigDecimal mobTiers,
			String siteTiers, String tiersActif, BigDecimal telTiers) {
		super();
		this.idRefTiers = idRefTiers;
		this.resSocial = resSocial;
		this.adrTiers = adrTiers;
		this.emailClient = emailClient;
		this.mobTiers = mobTiers;
		this.siteTiers = siteTiers;
		this.tiersActif = tiersActif;
		this.telTiers = telTiers;
	}
	
	
}
