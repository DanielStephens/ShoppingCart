package com.shop.shoppingcart.model.discounts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

import com.shop.shoppingcart.interfaces.Discount;
import com.shop.shoppingcart.interfaces.DiscountStrategy;
import com.shop.shoppingcart.interfaces.FoodItem;

public class BaseDiscount implements Discount {
	//private final DiscountStrategy strategy;
	private final Collection<FoodItem> foodItems;
	private BigDecimal saving;
	private String name;
	
	protected BaseDiscount(Collection<FoodItem> foodItems){
		this.foodItems = foodItems;
		this.saving = BigDecimal.ZERO;
		this.name = "Generic Discount";
	}
	
	@Override
	public Discount by(BigDecimal saving){
		this.saving = saving;
		return this;
	}
	
	@Override
	public Discount by(String saving){
		this.saving = new BigDecimal(saving);
		return this;
	}
	
	@Override
	public Discount withName(String name){
		this.name = name;
		return this;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getSaving(Collection<FoodItem> foodItems) {
		BigDecimal saving = BigDecimal.ZERO;
		Collection<FoodItem> items = new ArrayList<>(foodItems);
		while(dumbMethodToAvoidIfStatementWhyAmIWritingThis(items)){
			saving = saving.add(this.saving);
		}
		return saving;
	}
	
	private boolean dumbMethodToAvoidIfStatementWhyAmIWritingThis(Collection<FoodItem> foodItems){
		boolean b = foodItems.containsAll(this.foodItems);
		for(FoodItem item : this.foodItems){
			foodItems.remove(item);
		}
		return b;
	}

	@Override
	public String getFormattedString(Collection<FoodItem> foodItems) {
		String formattedString = "";
		Collection<FoodItem> items = new ArrayList<>(foodItems);
		while(dumbMethodToAvoidIfStatementWhyAmIWritingThis(items)){
			formattedString += this.toString() + "\n";
		}
		return formattedString;
	}
	
	@Override
	public String toString(){
		return name + ": -£" + saving.setScale(2, RoundingMode.DOWN);
	}
}
