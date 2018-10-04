package com.worldsoft.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Avion;
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.TypeChambre;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.RoleModel;

@LocalBean
@Stateless
public class HotelServices {
	@PersistenceContext
	EntityManager em;

	public void addHotel(Hotel hotel) {
		em.persist(hotel);
	}

	public void editRefTier(Hotel hotel) {
		em.merge(hotel);
	}

	public Hotel findHotel(long id) {
		return em.find(Hotel.class, id);
	}

	public void deletHotel(Hotel hotel) {
		em.remove(em.merge(hotel));
	}

	public List<String> findAllHotel() {
		Query query = em.createQuery("select new com.worldsoft.model.HotelModel( u.idHotel ,u.abrvHotel) from Hotel u");
		return query.getResultList();
	}

	public List<HotelModel> findCategoriHotel() {
		Query query = em.createQuery("select distinct new com.worldsoft.model.HotelModel(u.categorie) from Hotel u");
		return query.getResultList();
	}
	
	

	public List<HotelModel> findHotels() {
		//HotelModel jk= new HotelModel(idHo, nomHo, adr, ville, pays, categorieHotel, abrv)
		
	//	long idHo, String nomHo, String adr, String ville, String pays, String categorieHotel,String abrv
	try{
		Query query = em.createQuery(
				"select new com.worldsoft.model.HotelModel( u.idHotel , u.nomHotel , u.adreHotel , u.villeHotel ,u.pays , u.categorie , u.abrvHotel) from Hotel u");
		return query.getResultList();
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public List<HotelModel> findAllHotelsByCategory(String category) {
	
		Query query = em.createQuery( 
				"select new com.worldsoft.model.HotelModel( u.idHotel , u.nomHotel , u.adreHotel , u.villeHotel ,u.pays  , u.categorie , u.abrvHotel ) from Hotel u where u.categorie =:category")
				.setParameter("category", category);
		return query.getResultList();
	}
public List<HotelModel> findAllHotels() {
		
		Query query = em.createQuery(//new HotelModel(idHo, nomHo, adr, ville, pays, categorieHotel, abrv)
				"select new com.worldsoft.model.HotelModel(u.idHotel , u.nomHotel , u.adreHotel , u.villeHotel ,u.pays , u.categorie , u.abrvHotel) from Hotel u ");
		return query.getResultList();
	}

	public List<HotelModel> findHotelByCategoriHotel(String category) {
		Query query = em
				.createQuery(
						"select distinct new com.worldsoft.model.HotelModel(u.idHotel , u.nomHotel) from Hotel u where u.categorie =:category")
				.setParameter("category", category);
		return query.getResultList();
	}
	
	
	
	public void addHotel1(HotelModel ajtH) {
		Hotel hotel = new Hotel();
		long maxIdHotel = 0;

		try {
			maxIdHotel = (long) em.createQuery("select max(idHotel) from Hotel").getSingleResult();
		} catch (Exception e) {
		}
		maxIdHotel++;
		hotel.setIdHotel(maxIdHotel);
		
		hotel.setNomHotel(ajtH.getNomHo());
		//hotel.setAbrvHotel(ajtH.);
		hotel.setAdreHotel(ajtH.getAdr());
	
		hotel.setCategorie(ajtH.getCategorieHotel());
		hotel.setVilleHotel(ajtH.getVille()); 
		hotel.setPays(ajtH.getPays());
		
		
		em.persist(hotel);
	}
	public void deleteHotel(long idHotel) {
		em.createQuery("delete from Hotel h where h.idHotel =:idHotel ")
				.setParameter("idHotel", idHotel).executeUpdate();
            System.out.println("hotel "+idHotel+" is delete");
            
	}
	
	public void editHotel(HotelModel ajtH) {
		System.out.println("Hotel"+ ajtH);
		Hotel hotel = new Hotel();
		hotel.setAbrvHotel(ajtH.getAbrv());
		hotel.setAdreHotel(ajtH.getAdr());
		hotel.setIdHotel(ajtH.getIdHo());
		hotel.setPays(ajtH.getPays());
		hotel.setVilleHotel(ajtH.getVille());
        hotel.setCategorie(ajtH.getCategorieHotel());
		hotel.setNomHotel(ajtH.getNomHo());
		
		em.merge(hotel);

	}
	
}