package net.kzn.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dto.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>(); 
	
	static {
		
		Category category = new Category();
		
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This iss some description for television!");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//second category
		
		category = new Category();
		
		// adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This iss some description for Mobile!");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		category = new Category();
		
		// adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This iss some description for Laptop!");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);

	}
	
	
	@Override
	public List<Category> list() {
		return categories;
	}


	@Override
	public Category get(int id) {
		
		// enchaned for loop
		for(Category category : categories) {
			if(category.getId() == id) return category;
		}
		
		
		return null;
	}


	@Override
	@Transactional
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

	
}
