package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.AvionServices;
import com.worldsoft.ejb.JourServices;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.VolServices;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.PeriodeModel;
import com.worldsoft.model.classVolModel;
import com.worldsoft.model.mvtPrixHotelModel;
import com.worldsoft.model.mvtPrixVolModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class MvmntPrixVolBean {
	@Inject
	VolServices volServices;
	
	@Inject
	MvmentPrixServices mvmntPrixServices;
	@Inject
	AvionServices avionServices;
	@Inject
	ModelQuery modelQuery;
	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("mvtV", new mvtPrixVolModel())
		
		.setProperty("airline", avionServices.findAir())
		.setProperty("avions", avionServices.findAllavions())
		.setProperty("idsegs", mvmntPrixServices.findAllidSeg())
		.setProperty("numVs", mvmntPrixServices.findAllnumVol());
		
		//.setProperty("avions", avionServices.findAllAvion());
		
		//.setProperty("classVols", volServices.findAllClassVol());
}
	
	
	@Get
	@NGReturn(model = "ajoutermvmntVolM")
	public String ajoutermvmntVol(mvtPrixVolModel mvtV) {
		System.out.println(mvtV);
		System.out.println(mvtV.getPrixVente());
		try {
			mvmntPrixServices.addMvmentPrixVol(mvtV); 
			return "Vol ajouté";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
	@Get
	@NGReturn(model = "classVols")
	public List<classVolModel> findclassVolByAvion(String avion) {
		return volServices.findclassVolByAvion(avion);
	}
	
	@Get
	@NGReturn(model = "mvtPrixVs")
	public List<mvtPrixVolModel>findAllMvmentPrixVol(String avion) {
		return mvmntPrixServices.findAllMvmentPrixVol(avion);
				
	}
	@Get
	@NGReturn(model = "mvtPrixVs")
	public List<mvtPrixVolModel> deletemvtV(long idPrix, long idAvion) {
		mvmntPrixServices.deletemvtV(idPrix, idAvion);
		return mvmntPrixServices.findAllMvmentPrixVol(idAvion+"");
	}
	@Get
	@NGReturn(model = "Avions")
	public List<AvionModel> findAllavionsByAir(String airline) {
		return avionServices.findAllavionsByAir(airline);
	}

	@Get
	@NGReturn(model = "editmvtVM")
	public String editMvtPrixV(mvtPrixVolModel mvtV) {
		System.out.println(mvtV.getIdPrix());
		try {
			mvmntPrixServices.editMvtPrixV(mvtV);
			return "Modification terminée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Get
	@NGReturn(model = "mvtPrixVs")
	public List<mvtPrixVolModel> findAllbyseg(String idSeg) {
		return mvmntPrixServices.findAllbyseg(idSeg);
	}
	@Get
	@NGReturn(model = "mvtPrixVs")
	public List<mvtPrixVolModel> findAllbynumVol(String numV) {
		return mvmntPrixServices.findAllbynumVol(numV);
	}
	
//	@Get
//	@NGReturn(model = "mvtPrixVs")
//	public List<mvtPrixVolModel> deletemvtV(String idprix, String idAvion) {
//		mvmntPrixServices.deletemvtH(idprix );
//		return mvmntPrixServices.findAllMvmentPrixVol(idAvion);
//	}
	
}