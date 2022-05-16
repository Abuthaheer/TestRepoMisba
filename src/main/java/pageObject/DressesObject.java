package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DressesObject extends BaseClass {

	public DressesObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='layered_id_attribute_group_1']/a")
	private WebElement sizeS;

	@FindBy(xpath = "//label[@for='layered_id_attribute_group_3']/a")
	private WebElement sizeL;
	@FindBy(xpath = "//label[@for='layered_id_attribute_group_2']/a")
	private WebElement sizeM;

	@FindBy(xpath = "//span[@class='heading-counter']")
	private WebElement countHeading;
	
	@FindBys(@FindBy(xpath = "//a[@class='product_img_link']"))
	private List<WebElement> lstAllProducts;
	@FindBy(xpath="//ul/li[1]/div[@class='product-container']/div/div/a[@class='product_img_link']/img")
	private WebElement firstImage;

	
	/*
	 * @FindBy(xpath="") private WebElement image1;
	 * 
	 * @FindBy(xpath="") private WebElement image2;
	 * 
	 * @FindBy(xpath="") private WebElement image3;
	 * 
	 * @FindBy(xpath="") private WebElement image4;
	 * 
	 * @FindBy(xpath="") private WebElement image5;
	 * 
	 * @FindAll(xpath="//a[@class='product_img_link']", value = { @FindBy })
	 * List<WebElement> list;
	 */
	
	@FindBy(xpath="//div[@class='button-container']/a[@data-id-product='3']")
	private WebElement btnaddToCart;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']/span")
	private WebElement closeButton;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
	private WebElement message;
	
	
	
	public int getTextFromHeaderString() {	
		
		String digit = "";
		String element = countHeading.getText();
		char[] arr = element.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				digit = digit + arr[i];

			}
		}

		return Integer.parseInt(digit);

	}
	
	public int getProductsCountFromHeader() {
		return lstAllProducts.size();
	}

	public String addToCart() {
		scrollToElement(firstImage);
		mouseHover(firstImage);
		btnaddToCart.click();
		Explicitlywait().until(ExpectedConditions.visibilityOf(message));
		String msg=message.getText();
		closeButton.click();
		return msg;
		
		
	}
	public WebElement productFirstImage() {
		return firstImage;
	}
}
