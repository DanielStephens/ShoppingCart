package com.shop.shoppingcart.model.items;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.shop.shoppingcart.interfaces.FoodItem;

public class Food implements FoodItem {

	private final BigDecimal price;
	private final String name;
	
	private Food(BigDecimal price, String name){
		this.price = price;
		this.name = name;
	}
	
	public static FoodItem apples(){
		return new Food(new BigDecimal("0.85"), "Apples");
	}
	
	public static FoodItem milk(){
		return new Food(new BigDecimal("1"), "Milk");
	}
	
	public static FoodItem bread(){
		return new Food(new BigDecimal("0.5"), "Bread");
	}
	
	public static Collection<FoodItem> parse(String[] names){
		Collection<FoodItem> items = new ArrayList<>();
		for(String name : names){
			items.add(Food.parse(name));
		}
		return items;
	}
	
	public static FoodItem parse(String name){
		String lowerName = name.toLowerCase();
		try {
			return (Food) Food.class.getMethod(lowerName, null).invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
		
		return Food.apples();
	}
	
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
}
