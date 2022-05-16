package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BaseClass {

	@FindBy(xpath = "//a[@title='Women']")
	private WebElement Women;

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
	private WebElement Dresses;

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]/a[@title='T-shirts']")
	private WebElement Tshirts;
	
	@FindBy(id="newsletter-input")
	private WebElement newsletter;
	
	@FindBy(xpath="//button[@name='submitNewsletter']")
	private WebElement button;
	
	@FindBy(xpath="//div[@id='columns']/p")
	private WebElement message;
	
	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	
	

	public boolean isWomendisplayed() {
		boolean value = elementFound(Women);
		return value;

	}

	public boolean isDressesdisplyed() {
		boolean value2 = elementFound(Dresses);
		return value2;

	}
	public boolean isTshirtsdisplayed() {
		boolean value3 = elementFound(Tshirts);
		return value3;
		
	}
	public void navigateWomen() {
		Women.click();
		
	}
	public void navigateDresses() {
		Dresses.click();
		
	}
	public void navigateTshirts() {
		Tshirts.click();
		
	}
	public void newsletter(String gmail) {
		setText(newsletter, gmail);
		button.click();
				
	}
	
	public String getnewsletter()
	{
		String msg=message.getText();
		return msg;
		
	}
	
	
}
