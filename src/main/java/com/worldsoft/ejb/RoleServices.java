package com.worldsoft.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.worldsoft.domain.Avion;
import com.worldsoft.domain.Hotel;
import com.worldsoft.domain.Role;
import com.worldsoft.model.AvionModel;
import com.worldsoft.model.HotelModel;
import com.worldsoft.model.RoleModel;

@LocalBean
@Stateless

public class RoleServices {
	@PersistenceContext
	EntityManager em;

	public void addRole(Role role) {
		em.persist(role);
	}

	public void editRole(Role role) {
		em.merge(role);
	}

	public Role findRole(long idRole) {
		return em.find(Role.class, idRole);
	}

	public void deletRole(Role role) {
		em.remove(em.merge(role));
	}

	public List<Role> findAllRole() {
		Query query = em.createQuery("select u from Role u");
		return query.getResultList();
	}

	public List<RoleModel> findIDNameRole() {
		Query query = em.createQuery("select new com.worldsoft.model.RoleModel(u.idRole, u.lRole) from Role u");
		return query.getResultList();
	}
	public void addRole(RoleModel rol) {
		Role role = new Role();
		long maxIdRol = 0;

		try {
			maxIdRol = (long) em.createQuery("select max(idRole) from Role").getSingleResult();
		} catch (Exception e) {
		}
		maxIdRol++;
		role.setIdRole(maxIdRol);
		
		role.setAbrvRole(rol.getAbrvRol());
		role.setLRole(rol.getlRol());
		
		
		em.persist(role);
	}
	
	public void deleteRole(long idRole) {
		em.createQuery("delete from Role r where r.idRole =:idRole ")
				.setParameter("idRole", idRole).executeUpdate();
            System.out.println(idRole);
	}
	public void editRole(RoleModel rol) {
		System.out.println("Role "+ rol);
		
		
		Role role = new Role();

		role.setLRole(rol.getlRol());
		role.setAbrvRole(rol.getAbrvRol());
		em.merge(role);

	}

}
