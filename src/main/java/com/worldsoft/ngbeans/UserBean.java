package com.worldsoft.ngbeans;

import java.util.List;

import javax.inject.Inject;

import com.worldsoft.domain.MvmentPrix;
import com.worldsoft.domain.RefUser;
import com.worldsoft.ejb.MvmentPrixServices;
import com.worldsoft.ejb.RefUserServices;
import com.worldsoft.ejb.RoleServices;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.UserModel;

import angularBeans.api.AngularBean;
import angularBeans.api.NGPostConstruct;
import angularBeans.api.NGReturn;
import angularBeans.api.http.Get;
import angularBeans.util.ModelQuery;

@AngularBean
public class UserBean {
	@Inject
	RefUserServices refUserServices;

	@Inject
	RoleServices roleService;

	@Inject
	ModelQuery modelQuery;

	@NGPostConstruct
	public void init() {
		modelQuery.setProperty("user", new RefUser())
		.setProperty("users", refUserServices.findAllUser())
		.setProperty("roles", roleService.findIDNameRole());
	}

	@Get
	@NGReturn(model = "ajouteruserM")
	public String ajouteruser(RefUser user) {
		System.out.println(user.getNomUser());
		try {
			refUserServices.addRefUser(user);
			return "utilisateur ajouté";
		} catch (Exception e) {
			return null;
		}
	}
	@Get
	@NGReturn(model = "users")
	public List<UserModel> deleteUser(long idUser) {
		refUserServices.deleteUser(idUser);
		return refUserServices.findAllUser();
	}
}
