package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.DressesObject;
import pageObject.HomePageObject;

public class DressesTest {
	
	
	DressesObject dressobj;
	HomePageObject home=new HomePageObject();
	public DressesTest() {
		dressobj=new DressesObject();
	}
	@Test
	public void isProductCountMatched() {
		home.navigateDresses();
		Assert.assertTrue(dressobj.getProductsCountFromHeader()==dressobj.getTextFromHeaderString());
	}
	
	@Test
	public void isProductAddedSuccessfully() {
		home.navigateDresses();
		Assert.assertTrue(dressobj.addToCart().contains("Product successfully added to your shopping cart"));
		
	}

}
