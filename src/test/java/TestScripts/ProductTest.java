package TestScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.DressesObject;
import pageObject.HomePageObject;
import pageObject.ProductObject;

public class ProductTest {
	HomePageObject homepage = new HomePageObject();
	DressesObject dressobj = new DressesObject();
	ProductObject productobj;

	public ProductTest() {
		productobj = new ProductObject();

	}

	@BeforeMethod
	public void clickFirstImage() {

		homepage.navigateDresses();

		dressobj.productFirstImage().click();
	}

	@Test
	public void isDescriptionlengthgreater() {

		Assert.assertTrue(productobj.lengthofDescription() < 150);
	}

	@Test
	public void isSizeDisplayedInUrl() {

		Assert.assertTrue(productobj.getLastChar().equalsIgnoreCase(productobj.checkUrl("2")));
	}

}
