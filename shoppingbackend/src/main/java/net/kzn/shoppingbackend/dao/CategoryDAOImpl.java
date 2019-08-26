package net.kzn.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>(); 
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM  Category WHERE active = :active"; 
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}


	/**
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}


	@Override
	public boolean add(Category category) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
