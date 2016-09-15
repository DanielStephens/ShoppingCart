package com.shop.shoppingcart.interfaces;

import java.math.BigDecimal;
import java.util.Collection;

import com.shop.shoppingcart.model.discounts.BaseDiscount;

public interface Discount {
	BigDecimal getSaving(Collection<FoodItem> foodItems);
	
	String getFormattedString(Collection<FoodItem> foodItems);
	
	String getName();

	Discount by(BigDecimal saving);
	
	Discount by(String saving);

	Discount withName(String name);
}
