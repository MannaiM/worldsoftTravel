package com.worldsoft.model;

import java.util.Date;

public class DtDebutFinPeriode {

	private Date dtDebut;
	private Date dtFin;

	public DtDebutFinPeriode(Date dtDebut, Date dtFin) {
		super();
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Date getDtFin() {
		return dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

}
