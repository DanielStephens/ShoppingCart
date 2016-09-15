package com.shop.shoppingcart.model;

import com.shop.shoppingcart.interfaces.CollectorStrategy;
import com.shop.shoppingcart.interfaces.GetStrategy;

public class BaseCollectorStrategy<T, U extends GetStrategy<T>> implements CollectorStrategy<T, U> {

	@Override
	public T get(T current, U newObject) {
		return current;
	}

}
