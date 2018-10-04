package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.HotelServices;
import com.worldsoft.ejb.TypeChambreServices;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.TypeChambreModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class AjouterTypeChmBean {
	@Inject
	HotelServices hotelServices;
	@Inject
	TypeChambreServices typeChambreServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("ajtTypeC", new TypeChambreModel())
		.setProperty("hotels", hotelServices.findAllHotel());}
	@Get
	@NGReturn(model = "ajouterTCM")
	public String ajouterTC(TypeChambreModel ajtTypeC) {
		System.out.println(ajtTypeC.getIdTCham());
		try {
			typeChambreServices.addTypeChmabreH(ajtTypeC);   
			return "type chambre ajouté";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "typeChambres")
	public List<TypeChambreModel> findAllTypeChambreByHotel(String hotel) {
		return typeChambreServices.findAllTypeChambreByHotel(hotel);
	}
	@Get
	@NGReturn(model = "typeChambres")
	public List<TypeChambreModel> deleteTypeChambre(long idChm, long idHotel) {
		typeChambreServices.deleteTypeChambre(idChm, idHotel);
		return typeChambreServices.findAllTypeChambreByHotel(idHotel + "");
	}
	
}
