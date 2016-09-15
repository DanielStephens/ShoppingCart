package com.apakgroup.shoppingcart;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest{
	
	private static final String apples = "Apples";
	
	private static final String bread = "Milk";
	
	private static final String milk = "Bread";
	
	@Test
    public void testApp(){
    	App.main(apples);
    	
    	App.main(apples, apples, bread, milk);
    }
}
