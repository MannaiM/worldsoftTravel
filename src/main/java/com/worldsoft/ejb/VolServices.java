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
import com.worldsoft.domain.ClassVol;
import com.worldsoft.domain.ClassVolPK;
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.Periode;
import com.worldsoft.domain.PeriodePK;
import com.worldsoft.domain.TypeChambrePK;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.classVolModel;

@LocalBean
@Stateless
public class VolServices {
	@PersistenceContext
	EntityManager em;

	public void addVol(ClassVol classVol) {
		em.persist(classVol);
	}

	public void editVol(ClassVol classVol) {
		em.merge(classVol);
	}

	public ClassVol findclassVol(ClassVolPK id) {
		return em.find(ClassVol.class, id);
	}

	public void deletClassVol(ClassVol classVol) {
		em.remove(em.merge(classVol));
	}

	public List<String> findAllClassVol() {
		Query query = em.createQuery("select new com.worldsoft.model.classVolModel(u.id.idClassVol u.abrvClass) from ClassVol u");
		return query.getResultList();
	}

	public List<classVolModel> findclassVolByAvion(String avion) {
		System.out.println("Avion " + avion);
		Query query = em.createQuery("select new com.worldsoft.model.classVolModel( u.id.idClassVol ,u.lClass) "
				+ "from ClassVol u where u.id.idAvion =:avion").setParameter("avion", Long.parseLong(avion));
		return query.getResultList();
	}
	
	
	public void addClassV(classVolModel ajtCV) {	
		System.out.println(ajtCV);
		ClassVol classVol = new ClassVol();
		long maxIdCV = 0;

		try {
			maxIdCV = (long) em
					.createQuery("select max(c.id.idClassVol) from ClassVol c where c.id.idAvion=:idavion")
			//where c.id.idAvion=:idavion
					.setParameter("idavion",Long.parseLong(ajtCV.getIdAv())).getSingleResult();
		} catch (Exception e) {
		}
		maxIdCV++;
		System.out.println(maxIdCV);
	
//		Avion avion = new Avion();
//		avion.setIdAvion(Long.parseLong(ajtCV.getIdAv()));
//		classVol.setAvion(avion);
		//ClassVolPK classVolPK = new ClassVolPK(Integer.parseInt(ajtCV.getIdAv()), maxIdCV);

		ClassVolPK classVolPK = new ClassVolPK(Long.parseLong(ajtCV.getIdAv()),maxIdCV);
		classVol.setId(classVolPK);
		 classVol.setId(classVolPK);
		 
		 System.out.println("pk insererrrrrr"+maxIdCV);
		classVol.setAbrvClass(ajtCV.getNomClass());
		classVol.setLClass(ajtCV.getLblClass());
	

		em.persist(classVol);
		
	}
	public List<classVolModel> findClassVolByAvion(String avion) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.classVolModel(u.id.idAvion ,u.abrvClass,u.lClass)from ClassVol u where u.id.idAvion =:idavion")
				.setParameter("idavion", Long.parseLong(avion));
		return query.getResultList();

	}

	public void deleteClassVol(long idClassV, long idAvion) {
		 
		em.createQuery("delete from ClassVol c where c.id.idClassVol =:idClassV and c.id.idAvion=:idAvion")
				.setParameter("idClassV", idClassV).setParameter("idAvion", idAvion).executeUpdate();
		System.out.println(idClassV + " et  " + idAvion);
	}
	public void editClassV(classVolModel ajtCV) {
		System.out.println("classe Vol "+ ajtCV);
		ClassVol ClassVol =new ClassVol();
		
		ClassVol.setAbrvClass(ajtCV.getNomClass());
		
		ClassVol.setLClass(ajtCV.getLblClass());
		ClassVolPK classVolPK = new ClassVolPK(Integer.parseInt(ajtCV.getIdAv()), ajtCV.getIdClassVol());
		ClassVol.setId(classVolPK);

		em.merge(ClassVol);

	}
}
