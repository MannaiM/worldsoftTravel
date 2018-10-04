package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.ejb.AvionServices;
import com.worldsoft.ejb.VolServices;
import com.worldsoft.model.ArrangementModel;
import com.worldsoft.model.classVolModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class ClassVolBean {
	@Inject
	VolServices volServices;
	@Inject
	AvionServices avionServices;
	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("ajtCV", new classVolModel())
		.setProperty("avions", avionServices.findAllAvion());}
	@Get
	@NGReturn(model = "ajouterClassVM")
	public String ajouterClassV(classVolModel ajtCV) {
		System.out.println(ajtCV.getIdAv());
		try {
			volServices.addClassV(ajtCV);   
			return "Class Vol ajouté";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Get
	@NGReturn(model = "classVols")
	public List<classVolModel> findClassVolByAvion(String avion) {
		return volServices.findClassVolByAvion(avion);
	}
	@Get
	@NGReturn(model = "classVols")
	public List<classVolModel> deleteClassVol(long idClassV, long idAvion) {
		volServices.deleteClassVol(idClassV, idAvion);
		return volServices.findClassVolByAvion(idAvion+"");
	}
	@Get
	@NGReturn(model = "editClassVM")
	public String editClass(classVolModel ClassV) {
		System.out.println("id av"+ClassV.getIdAv()+"idCv"+ ClassV.getIdClassVol());
		try {
			volServices.editClassV(ClassV);
			return "Classe Vol Modifiée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
