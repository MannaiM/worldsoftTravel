package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.PeriodeSupplement;
import com.worldsoft.domain.Reservation;

@LocalBean
@Stateless

public class PeriodeSupplementServices {
	@PersistenceContext
	EntityManager em;

	public void addPeriodeSupplement(PeriodeSupplement periodeSupplement) {
		em.persist(periodeSupplement);
	}

	public void editPeriodeSupplement(PeriodeSupplement periodeSupplement) {
		em.merge(periodeSupplement);
	}

	public PeriodeSupplement findPeriodeSupplement(long idSupp) {
		return (PeriodeSupplement) em.createQuery("select u from PeriodeSupplement u where u.id.idSupp =:p1")
				.setParameter("p1", idSupp).getResultList();
	}

	public void deletPeriodeSupplement(PeriodeSupplement periodeSupplement) {
		em.remove(em.merge(periodeSupplement));
	}

	public List<PeriodeSupplement> findAllPeriodeSupplement() {
		Query query = em.createQuery("select u from PeriodeSupplement u");
		return query.getResultList();
	}



}
