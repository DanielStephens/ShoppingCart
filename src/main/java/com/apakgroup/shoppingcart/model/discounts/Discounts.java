package com.apakgroup.shoppingcart.model.discounts;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import com.apakgroup.shoppingcart.interfaces.Discount;
import com.apakgroup.shoppingcart.interfaces.DiscountStrategy;
import com.apakgroup.shoppingcart.interfaces.FoodItem;

public class Discounts {
	private Discounts(){
		
	}
	
	public static Discount items(Collection<FoodItem> foodItems){
		return new BaseDiscount(foodItems);
	}
	
	public static Discount items(FoodItem... foodItems){
		return new BaseDiscount(Arrays.asList(foodItems));
	}
	
//	public static Discount compose(Discount... discounts){
//		GroupDiscount groupDiscount = new GroupDiscount();
//		for(Discount discount : discounts){
//			groupDiscount.addDiscount(discount);
//		}
//		return groupDiscount;
//	}

	public static BigDecimal getDiscount(Collection<FoodItem> foodItems,
			Collection<Discount> discounts) {
		BigDecimal total = BigDecimal.ZERO;
		for(Discount discount : discounts){
			total = total.add(discount.getSaving(foodItems));
		}
		return total;
	}

	public static String getDiscounts(Collection<FoodItem> foodItems,
			Collection<Discount> discounts) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Discount discount : discounts){
			stringBuilder.append(discount.getFormattedString(foodItems));
		}
		String string = stringBuilder.toString();
		return string.substring(0, Math.max(0, string.length()-1));
	}
}
