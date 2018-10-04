package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.ArrangementServices;
import com.worldsoft.ejb.HotelServices;
import com.worldsoft.ejb.JourServices;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.PeriodeServices;
import com.worldsoft.ejb.TypeChambreServices;
import com.worldsoft.ejb.VolServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.TypeChambreModel;
import com.worldsoft.model.classVolModel;
import com.worldsoft.model.mvtPrixHotelModel;
import com.worldsoft.model.mvtPrixSejourModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;
@AngularBean
public class MvmntPrixSejourBean {
	@Inject
	MvmentPrixServices mvmntPrixServices;
	@Inject
	VolServices volServices;
	@Inject
	HotelServices hotelServices;

	@Inject
	TypeChambreServices typeChambreServices;

	@Inject
	ArrangementServices arrangementservices;

	@Inject
	JourServices jourservices;

	@Inject
	PeriodeServices periodeServices;

	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("mvtS", new mvtPrixSejourModel())
				.setProperty("category", hotelServices.findCategoriHotel())
				.setProperty("jours", jourservices.findAllJour());
	}
	
	
	
	@Get
	@NGReturn(model = "message")
	public String ajoutermvmntSejour(mvtPrixSejourModel mvtS) {
		System.out.println(mvtS.getPrixVente());
		try {
			mvmntPrixServices.addMvmentPrixSejour(mvtS); //addMvmentPrixSejour (mvtS);
			return "Séjour ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "hotels")
	public List<HotelModel> findHotelByCategoryermvmnt(String category) {
		return hotelServices.findHotelByCategoriHotel(category);
	}

	@Get
	@NGReturn(model = "periodes")
	public List<PeriodeModel> findPeriodeByHotel(String hotel) {
		return periodeServices.findPeriodeByHotel(hotel);
	}

	@Get
	@NGReturn(model = "arrangements")
	public List<ArrangementModel> findArrangementByHotel(String hotel) {
		return arrangementservices.findArrangementByHotel(hotel);
	}

	@Get
	@NGReturn(model = "typeChambres")
	public List<TypeChambreModel> findTypeChambreByHotel(String hotel) {
		return typeChambreServices.findTypeChambreByHotel(hotel);
	}
	@Get
	@NGReturn(model = "classVols")
	public List<classVolModel> findclassVolByAvion(String avion) {
		return volServices.findclassVolByAvion(avion);
	}

}
