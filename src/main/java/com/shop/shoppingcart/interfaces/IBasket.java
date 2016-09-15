package com.shop.shoppingcart.interfaces;

import java.math.BigDecimal;

public interface IBasket {
	
	BigDecimal getSubtotal();
	
	BigDecimal getTotal();
}
