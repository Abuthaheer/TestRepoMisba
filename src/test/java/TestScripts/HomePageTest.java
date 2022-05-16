package TestScripts;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObject.HomePageObject;

public class HomePageTest {
	HomePageObject home;

	
	int random = new Random().nextInt(30000); 
	public HomePageTest() {
		home = new HomePageObject();

	}
		

	@Test
	public void checkTabs() {

		Assert.assertTrue(home.isWomendisplayed());
		Assert.assertTrue(home.isDressesdisplyed());
		Assert.assertTrue(home.isTshirtsdisplayed());
	}

	@Test
	public void isWomenTabNavigated() {
		home.navigateWomen();
		String title = home.getTitlte();
		Assert.assertTrue(title.contains("Women"));

	}

	@Test
	public void isDressesTabNavigated() {
		home.navigateDresses();
		String title = home.getTitlte();
		Assert.assertTrue(title.contains("Dresses"));

	}
	
	@Test
	public void isTshirtsTabNavigated() {
		home.navigateTshirts();
		String title = home.getTitlte();
		Assert.assertTrue(title.contains("T-shirts"));

	}
	
	@BeforeClass
	@Parameters({"gmail"})
	public void isObtainSuccessMsg(String gmail)
	{
		home.newsletter(gmail + random + "@gmail.com");
		Assert.assertTrue(home.getnewsletter().contains("You have successfully subscribed to this newsletter"));
	}
	
	
	

}