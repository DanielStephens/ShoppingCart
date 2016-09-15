package com.shop.shoppingcart.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.shop.shoppingcart.interfaces.Discount;
import com.shop.shoppingcart.interfaces.FoodItem;
import com.shop.shoppingcart.interfaces.IBasket;
import com.shop.shoppingcart.model.discounts.Discounts;

public class Basket implements IBasket {
	private final Collection<FoodItem> foodItems;
	private final Collection<Discount> discounts;
	
	protected Basket(){
		foodItems = new ArrayList<>();
		discounts = new ArrayList<>();
	}
	
	public static Basket makeBaslet(){
		return new Basket();
	}
	
	public Basket withItems(FoodItem... foodItems){
		this.foodItems.clear();
		this.foodItems.addAll(Arrays.asList(foodItems));
		return this;
	}
	
	public Basket withItems(Collection<FoodItem> foodItems){
		this.foodItems.clear();
		this.foodItems.addAll(foodItems);
		return this;
	}
	
	public Basket withDiscounts(Discount... discounts){
		this.discounts.clear();
		this.discounts.addAll(Arrays.asList(discounts));
		return this;
	}
	
	public Basket withDiscounts(Collection<Discount> discounts){
		this.discounts.clear();
		this.discounts.addAll(discounts);
		return this;
	}

	@Override
	public BigDecimal getTotal() {
		return getPrivateSubtotal().subtract(getDiscount()).setScale(2, RoundingMode.DOWN);
	}

	private BigDecimal getDiscount() {
		return Discounts.getDiscount(foodItems, discounts);
	}
	
	public String getDiscounts() {
		return Discounts.getDiscounts(foodItems, discounts);
	}
	
	private BigDecimal getPrivateSubtotal() {
		BigDecimal total = BigDecimal.ZERO;
		for(FoodItem foodItem : foodItems){
			total = total.add(foodItem.getPrice());
		}
		return total;
	}

	@Override
	public BigDecimal getSubtotal() {
		return getPrivateSubtotal().setScale(2, RoundingMode.DOWN);
	}
}
