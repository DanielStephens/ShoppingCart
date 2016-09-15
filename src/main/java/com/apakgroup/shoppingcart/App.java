package com.apakgroup.shoppingcart;

import java.util.Arrays;
import java.util.Collection;

import com.apakgroup.shoppingcart.interfaces.Discount;
import com.apakgroup.shoppingcart.interfaces.FoodItem;
import com.apakgroup.shoppingcart.model.Basket;
import com.apakgroup.shoppingcart.model.discounts.Discounts;
import com.apakgroup.shoppingcart.model.items.Food;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String... args )
    {
    	Collection<FoodItem> foodItems = Food.parse(args);
    	
        FoodItem apples = Food.apples();
        FoodItem bread = Food.bread();
        FoodItem milk = Food.milk();
        
        Discount appleDiscount = Discounts.items(apples).by("0.1").withName("Save 10% on apples");
        Discount breadDiscount = Discounts.items(milk, bread).by("0.5").withName("Half price bread");
    	
    	Basket basket = Basket.makeBaslet().withItems(foodItems).withDiscounts(appleDiscount, breadDiscount);
    	
    	System.out.println("//////////////////////////////");
    	System.out.println(basket.getSubtotal());
    	System.out.println(basket.getDiscounts());
    	System.out.println(basket.getTotal());
    	System.out.println("//////////////////////////////");
    }
}
