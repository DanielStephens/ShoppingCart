package com.shop.shoppingcart.interfaces;

public interface CollectorStrategy<T, U extends GetStrategy<T>> {
	
	T get(T current, U newObject);

}
