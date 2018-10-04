package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.domain.ArrangementPK;
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.TypeChambre;
import com.worldsoft.domain.TypeChambrePK;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.TypeChambreModel;

@LocalBean
@Stateless

public class TypeChambreServices {
	@PersistenceContext
	EntityManager em;

	public void addTypeChambre(TypeChambre typeChambre) {
		em.persist(typeChambre);
	}

	public void editTypeChambre(TypeChambre typeChambre) {
		em.merge(typeChambre);
	}

	public TypeChambre findTypeChambre(long idChambre) {
		return (TypeChambre) em.createQuery("select u from TypeChambre u where u.id.idChm =:p1")
				.setParameter("p1", idChambre).getResultList();
	}

	public void deletTypeChambre(TypeChambre typeChambre) {
		em.remove(em.merge(typeChambre));
	}

	public List<TypeChambreModel> findAllTypeChambre() {
		Query query = em.createQuery("select new com.worldsoft.model.TypeChambreModel( u.id.idChm ,u.lTypeChm)from TypeChambre u");
		return query.getResultList();
	}
	public List<TypeChambreModel> findTypeChambreByHotel(String hotel) {
		Query query = em
				.createQuery(
						"select new com.worldsoft.model.TypeChambreModel( u.id.idChm ,u.abrvChambre)from TypeChambre u where u.id.idHotel =:hotel")
				.setParameter("hotel", Long.parseLong(hotel));
		return query.getResultList();
	}
	

	public void addTypeChmabreH(TypeChambreModel ajtTypeC) {
		TypeChambre typeChambre = new TypeChambre();
		long maxIdTC = 0;

		try {
			maxIdTC = (long) em
					.createQuery("select max(a.id.idChm) from TypeChambre a where a.id.idHotel=:idHotel")
					.setParameter("idHotel", Long.parseLong(ajtTypeC.getIdHotel())).getSingleResult();
		} catch (Exception e) {
		}
		maxIdTC++;
		Hotel hotel = new Hotel();
		hotel.setIdHotel(Long.parseLong(ajtTypeC.getIdHotel()));
		typeChambre.setHotel(hotel);
		typeChambre.setTypeChm(ajtTypeC.getType());
		typeChambre.setAbrvChambre(ajtTypeC.getNomTCham());
     	typeChambre.setLTypeChm(ajtTypeC.getLblTCham());
		TypeChambrePK typeChambrePK = new TypeChambrePK(Integer.parseInt(ajtTypeC.getIdHotel()), maxIdTC);

		typeChambre.setId(typeChambrePK);

		em.persist(typeChambre);
	}
	
	public List<TypeChambreModel> findAllTypeChambreByHotel(String hotel) {
		//TypeChambreModel ml = new TypeChambreModel(idTCham, nomTCham, lblTCham)
		Query query = em.createQuery("select new com.worldsoft.model.TypeChambreModel( u.id.idChm ,u.abrvChambre ,u.lTypeChm)from TypeChambre u where u.id.idHotel=:idhotel")
				.setParameter("idhotel", Long.parseLong(hotel));
		return query.getResultList();
	}
	
	public void deleteTypeChambre(long idChm, long idHotel) {
		em.createQuery("delete from TypeChambre t where t.id.idChm =:idChm and t.id.idHotel=:idHotel")
				.setParameter("idHotel", idHotel).setParameter("idChm", idChm).executeUpdate();
}
	public void editTypeChambre(TypeChambreModel ajtTypeC) {
		
		TypeChambre typeChambre = new TypeChambre();

		typeChambre.setAbrvChambre(ajtTypeC.getNomTCham());
		typeChambre.setLTypeChm(ajtTypeC.getLblTCham());
		TypeChambrePK typeChambrePK = new TypeChambrePK(Integer.parseInt(ajtTypeC.getIdHotel()), ajtTypeC.getIdTCham());
		typeChambre.setId(typeChambrePK);

		em.merge(typeChambre);

	}
}
