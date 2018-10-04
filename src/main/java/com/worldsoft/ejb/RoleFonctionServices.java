package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.RoleFonction;
import com.worldsoft.domain.TypeChambre;

@LocalBean
@Stateless

public class RoleFonctionServices {
		@PersistenceContext
		EntityManager em;

		public void addRoleFonction(RoleFonction roleFonction) {
			em.persist(roleFonction);
		}

		public void editRoleFonction(RoleFonction roleFonction) {
			em.merge(roleFonction);
		}

		public RoleFonction findRoleFonction(long idFonction) {
			return (RoleFonction) em.createQuery("select u from RoleFonction u where u.id.idFonction =:p1")
					.setParameter("p1", idFonction).getResultList();
		}

		public void deletRoleFonction(RoleFonction roleFonction) {
			em.remove(em.merge(roleFonction));
		}

		public List<RoleFonction> findAllRoleFonction() {
			Query query = em.createQuery("select u from RoleFonction u");
			return query.getResultList();
		}

}
