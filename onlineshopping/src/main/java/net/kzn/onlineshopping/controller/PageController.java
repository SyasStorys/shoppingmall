package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/*")
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class); 
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"home", "index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		logger.info("::::::::::::::::홈페이지 진입 ::::::::::::::");
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About US");
		mv.addObject("userClickAbout", true);
		logger.info("::::::::::::::::소개페이지 진입 ::::::::::::::");
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact US");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/**
	 * Methods to load all the products and based on category
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		
		//passing the list of catgories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of catgories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	
	@RequestMapping(value="test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		
		if(greeting == null) {
			greeting = "Hello World";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	
	@RequestMapping(value="test2/{greeting}")
	public ModelAndView test2(@PathVariable("greeting")String greeting) {
		
		if(greeting == null) {
			greeting = "Hello World";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	/**
	 * Viewing a single product
	 */
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();

		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}

}
