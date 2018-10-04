package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Avion;
import com.worldsoft.domain.RefTier;
import com.worldsoft.domain.RefUser;
import com.worldsoft.domain.RefUtilisateur;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.UserModel;
import com.worldsoft.model.UtilisateurModel;

@LocalBean
@Stateless
public class RefUtilisateurServices {

	@PersistenceContext
	EntityManager em;

	public void addRefutilisateur(RefUtilisateur refutilisateur) {
		em.persist(refutilisateur);
	}

	public void editRefutilisateur(RefUtilisateur refutilisateur) {
		em.merge(refutilisateur);
	}

	public RefUtilisateur findRefutilisateur(long id) {
		return em.find(RefUtilisateur.class, id);
	}

	public void deletRefutilisateur(RefUtilisateur refutilisateur) {
		em.remove(em.merge(refutilisateur));
	}

	public List<String> findAllRefTier() {
		Query query = em.createQuery("select u.adrTiers from RefTier u");
		return query.getResultList();
	}

	public void addRefUtilisateur(UtilisateurModel utilis) {

		System.out.println("Utilisateur " + utilis);

		RefUtilisateur refU = new RefUtilisateur();
		long maxIdu = 0;

		try {
			maxIdu = (long) em.createQuery("select max(a.idUtilisateur) from RefUtilisateur a ").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(maxIdu);
		maxIdu++;
		System.out.println(maxIdu + "new");

		refU.setIdUtilisateur(maxIdu);
		refU.setLogUtilisateur(utilis.getLogUtilisateur());
		refU.setNomRefUtilisateur(utilis.getNomRefUtilisateur());
		refU.setPasswUtilisateur(utilis.getPasswUtilisateur());
		refU.setIdRefTiers(utilis.getIdRefTiers());
		// try{
		// RefTier refTier = new RefTier();
		// refTier.setIdRefTiers(utilis.getIdRefTiers());
		// refU.setRefTier(refTier); }
		// catch (Exception e) {
		// RefTier refTier = new RefTier();
		// refTier.setIdRefTiers(1);
		// refU.setRefTier(refTier);
		// System.out.println("pas de ref user");
		//
		// }
		//
		em.persist(refU);

	}

	public void deleteUtilis(long idUtilis) {

		em.createQuery("delete from RefUtilisateur p where p.idUtilisateur =:idUtilis")
				.setParameter("idUtilis", idUtilis).executeUpdate();
		System.out.println(idUtilis);
	}

	public List<UtilisateurModel> findAllUtilisateur() {

		Query query = em.createQuery( // new UtilisateurModel(idRefTiers,
										// idUtilisateur, nomRefUtilisateur,
										// logUtilisateur, passwUtilisateur)
				"select new com.worldsoft.model.UtilisateurModel(u.refTier.idRefTiers ,u.idUtilisateur ,u.nomRefUtilisateur ,u.logUtilisateur ,u.passwUtilisateur)from RefUtilisateur u ");
		return query.getResultList();

	}

	public List<UtilisateurModel> findUtilisbyTier(String refT) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.UtilisateurModel( u.refTier.idRefTiers ,u.idUtilisateur ,u.nomRefUtilisateur ,u.logUtilisateur ,u.passwUtilisateur )from RefUtilisateur u  where u.refTier.idRefTiers =:refT")
				.setParameter("refT", Long.parseLong(refT));
		return query.getResultList();

	}

}
