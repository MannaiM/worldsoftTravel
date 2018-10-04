package com.worldsoft.ngbeans;

import java.math.BigDecimal;

import javax.inject.Inject;

import com.worldsoft.domain.RefTier;
import com.worldsoft.ejb.RefTiersServices;

import angularBeans.api.AngularBean;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;

@AngularBean
public class HelloAngularBeans {
	
	@Inject
	RefTiersServices refTiersServices;
	

	@Get
	@NGReturn(model = "message")
	public String sayHello(String name) {
//		RefTier reftier = new RefTier();
//		reftier.setIdRefTiers(1);
//		reftier.setEmailClient("mail@gmail.com");
//		refTiersServices.addRefTier(reftier);

//		RefTier reftier = refTiersServices.findRefTier(1);
//		reftier.setMobTiers(new BigDecimal(12541741));
//		refTiersServices.editRefTier(reftier);
		
//		RefTier reftier = refTiersServices.findRefTier(1);
//		refTiersServices.deletRefTier(reftier);
		
		
		System.out.println(refTiersServices.findAllRefTier());
		
		return "hello " + name + " from AngularBeans !";
        
	}

}
