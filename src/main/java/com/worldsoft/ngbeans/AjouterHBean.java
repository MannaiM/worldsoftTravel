package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.HotelServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.TypeChambreModel;
import com.worldsoft.model.mvtPrixHotelModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class AjouterHBean {
	@Inject
	HotelServices hotelServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		String hotel;
		modelQuery.setProperty("ajtH", new HotelModel())
		.setProperty("hotelss", hotelServices.findAllHotels())
		.setProperty("category", hotelServices.findCategoriHotel())
		;}
	@Get
	@NGReturn(model = "ajouterhotelM")
	public String ajouterhotel(HotelModel ajtH) {
		System.out.println(ajtH.getIdHo());
		try {
			hotelServices.addHotel1(ajtH);  
			return "Hotel ajouté";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "Hotels")
	public List<HotelModel> findHotels() {
		return hotelServices.findHotels();
	}
	
	
	@Get
	@NGReturn(model = "hotelsss")
	public List<HotelModel> findAllHotelsByCategory(String category) {
		return hotelServices.findAllHotelsByCategory(category);
	}
	@Get
	@NGReturn(model = "hotelsss")
	public List<HotelModel> deleteHotel (long idHotel) {
		hotelServices.deleteHotel(idHotel);
		return hotelServices.findAllHotels();
	}
	
	
	@Get
	@NGReturn(model = "editHotelM")
	public String editHotel(HotelModel ajtH) {
		System.out.println(ajtH.getIdHo());
		try {
			hotelServices.editHotel(ajtH);
			return "hotel Modifié";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	@Get
//	@NGReturn(model = "hotels")
//	public List<HotelModel> findHotels() {
//		try {
//			hotelServices.findHotels();
//		
//		System.out.println("cccc"+hotelServices.findHotels());
//		return hotelServices.findHotels();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("erreur");
//			return null;
//		
//		
//	}
	
	
//}
}