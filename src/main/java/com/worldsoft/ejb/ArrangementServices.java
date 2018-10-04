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
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.RefTier;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;

@LocalBean
@Stateless
public class ArrangementServices {
	@PersistenceContext
	EntityManager em;

	public void addArrangement(Arrangement arrangement) {

		em.persist(arrangement);
	}

	public void editArrangement(Arrangement arrangement) {
		em.merge(arrangement);
	}

	public Arrangement findArrangement(ArrangementPK id) {
		return em.find(Arrangement.class, id);
	}

	public void deletArrangement(Arrangement arrangement) {
		em.remove(em.merge(arrangement));
	}

	public List<ArrangementModel> findAllArrangement() {
		Query query = em.createQuery(
				"select new com.worldsoft.model.ArrangementModel( u.id.idArrangement ,u.lArrangement) from Arrangement u");
		return query.getResultList();
	}

	public List<ArrangementModel> findArrangementByHotel(String hotel) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.ArrangementModel( u.id.idArrangement ,u.abrvArrangement)from Arrangement u where u.id.idHotel =:hotel")
				.setParameter("hotel", Long.parseLong(hotel));
		return query.getResultList();

	}

	public void addArrangementH(ArrangementModel ajtArr) {
		Arrangement arrangement = new Arrangement();
		long maxIdArr = 0;

		try {
			maxIdArr = (long) em
					.createQuery("select max(a.id.idArrangement) from Arrangement a where a.id.idHotel=:idHotel")
					.setParameter("idHotel", Long.parseLong(ajtArr.getIdHotel())).getSingleResult();
		} catch (Exception e) {
		}
		maxIdArr++;
		// select max(idArrangement) from Arrangement where idHotel= :idHotel

		// Hotel hotel = new Hotel();
		// hotel.setIdHotel(Long.parseLong(ajtArr.getIdHotel()));
		// arrangement.setHotel(hotel);

		arrangement.setAbrvArrangement(ajtArr.getNomarr());
		arrangement.setLArrangement(ajtArr.getLabArr());
		ArrangementPK arrangementPK = new ArrangementPK(Integer.parseInt(ajtArr.getIdHotel()), maxIdArr);
		arrangementPK.setIdArrangement(maxIdArr++);
		arrangement.setId(arrangementPK);

		em.persist(arrangement);
	}

	public List<ArrangementModel> findArrangementByHotell(String hotel) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.ArrangementModel(u.id.idArrangement ,u.abrvArrangement,u.lArrangement , u.id.idHotel)from Arrangement u where u.id.idHotel =:hotel")
				.setParameter("hotel", Long.parseLong(hotel));
		return query.getResultList();

	}

	public void deleteArrangement(long idArrangement, long idHotel) {
		em.createQuery("delete from Arrangement p where p.id.idArrangement =:idArrangement and p.id.idHotel=:idHotel")
				.setParameter("idHotel", idHotel).setParameter("idArrangement", idArrangement).executeUpdate();
		System.out.println(idArrangement + "   " + idHotel);
	}
	// public void updateArrangement(long idArrangement, long idHotel) {
	// UPDATE table_name
	// SET column1=value1,column2=value2,...
	// WHERE some_column=some_value;
	// em.createQuery("UPDATE Arrangement SET p.abrvArrangement= where
	// p.id.idArrangement =:idArrangement and p.id.idHotel=:idHotel")
	// .setParameter("idHotel", idHotel).setParameter("idArrangement",
	// idArrangement).executeUpdate();
	// System.out.println(idArrangement+" "+idHotel);
	// }

	public void editArrangementH(ArrangementModel ajtArr) {
		System.out.println("Arrangement "+ ajtArr);
		
		
		Arrangement arrangement = new Arrangement();

		arrangement.setAbrvArrangement(ajtArr.getNomarr());
		arrangement.setLArrangement(ajtArr.getLabArr());
		ArrangementPK arrangementPK = new ArrangementPK(Integer.parseInt(ajtArr.getIdHotel()), ajtArr.getIdarr());
		arrangement.setId(arrangementPK);

		em.merge(arrangement);

	}

}
