package com.rest.dao;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.model.Cart;
import com.rest.model.Items;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insertCArt() {
		Cart cart = new Cart();

	    Items item1 = new Items(cart);
	    Items item2 = new Items(cart);
	    Set<Items> itemsSet = new HashSet<Items>();
	    itemsSet.add(item1);
	    itemsSet.add(item2);

	    cart.setItems(itemsSet);
		
	    getCurentSession().save(cart);
	    getCurentSession().save(item1);
	    getCurentSession().save(item2);
	    
	    System.out.println("Cart ID=" + cart.getId());
        System.out.println("item1 ID=" + item1.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());
        System.out.println("item2 ID=" + item2.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());

	}


}
