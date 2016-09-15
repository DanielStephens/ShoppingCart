package com.apakgroup.shoppingcart.interfaces;

import java.math.BigDecimal;
import java.util.Collection;

public interface DiscountStrategy {
	BigDecimal getReduction(Collection<FoodItem> foodItems);
}
