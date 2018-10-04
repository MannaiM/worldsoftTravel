package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Supplement;
import com.worldsoft.domain.TypeChambre;

@LocalBean
@Stateless

public class SupplementServices {
	@PersistenceContext
	EntityManager em;

	public void addSupplement(Supplement supplement) {
		em.persist(supplement);
	}

	public void editSupplement(Supplement supplement) {
		em.merge(supplement);
	}

	public Supplement findSupplement(long idSupp) {
		return (Supplement) em.createQuery("select u from Supplement u where u.id.idSupp =:p2")
				.setParameter("p2", idSupp).getResultList();
	}

	public void deletSupplement(Supplement supplement) {
		em.remove(em.merge(supplement));
	}

	public List<Supplement> findAllSupplement() {
		Query query = em.createQuery("select u from Supplement u");
		return query.getResultList();
	}


}
