package com.apakgroup.shoppingcart.model;

import java.util.ArrayList;
import java.util.Collection;

import com.apakgroup.shoppingcart.interfaces.CollectorStrategy;
import com.apakgroup.shoppingcart.interfaces.GetStrategy;

public class Collect<T, U extends GetStrategy<T>> {
	private CollectorStrategy<T, U> strategy;
	private final Collection<U> collection;
	
	private Collect(){
		this.strategy = createBaseStrategy();
		this.collection = new ArrayList<>();
	}
	
	public static <T, U extends GetStrategy<T>> Collect from(Collection<U> collection){
		Collect collect = new Collect<T, U>();
		collect.collection.addAll(collection);
		return collect;
	}
	
	public Collect withStrategy(CollectorStrategy<T, U> strategy){
		this.strategy = strategy;
		return this;
	}
	
	private CollectorStrategy<T, U> createBaseStrategy(){
		return new BaseCollectorStrategy<T, U>();
	}
	
	public T collect(){
		T t = null;
		for(U u : collection){
			t = strategy.get(t, u);
		}
		return t;
	}
}
