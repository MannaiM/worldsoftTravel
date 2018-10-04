package com.worldsoft.ngbeans;

import javax.inject.Inject;

import com.worldsoft.domain.Arrangement;
import com.worldsoft.ejb.ArrangementServices;

import angularBeans.api.AngularBean;

@AngularBean

public class ArrangementBean {
	
	@Inject
	ArrangementServices  arrangementServices;
	public String AjouterArrangement(String abrvArrangement){
	Arrangement arrangement = new Arrangement();
	//arrangement.setId(1);
	arrangement.setAbrvArrangement("kkkkkkkkk");
	arrangementServices.addArrangement(arrangement);
	//System.out.println(arrangementServices.findAllArrangement());
	
	return "le nouveau arrangement est " + abrvArrangement + " from AngularBeans !";
}
}