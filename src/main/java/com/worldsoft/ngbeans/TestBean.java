package com.worldsoft.ngbeans;

import javax.inject.Inject;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.ejb.MvmentPrixServices;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class TestBean {
	@Inject
	ModelQuery modelQuery;

	@Inject
	MvmentPrixServices mvmntPrixServices;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("mvtV", new MvmentPrix());
	}

	@Get
	@NGReturn(model = "message")
	public String ajoutermvmnt2() {
		try {
			mvmntPrixServices.addMvmentPrix2();
			return "vol ajoutée";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
