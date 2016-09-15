package com.apakgroup.shoppingcart.model;

import com.apakgroup.shoppingcart.interfaces.CollectorStrategy;
import com.apakgroup.shoppingcart.interfaces.GetStrategy;

public class BaseCollectorStrategy<T, U extends GetStrategy<T>> implements CollectorStrategy<T, U> {

	@Override
	public T get(T current, U newObject) {
		return current;
	}

}
