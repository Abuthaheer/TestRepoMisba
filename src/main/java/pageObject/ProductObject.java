package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductObject extends BaseClass {
	
	public ProductObject() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='icon-twitter']")
	private WebElement btnTweet;
	
	@FindBy(xpath="//i[@class='icon-facebook']")
	private WebElement btnShare;
	
	
	@FindBy(xpath="//div[@id='short_description_content']/p")
	private WebElement textDescription;
	
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement dropdown;
	
	@FindBy(xpath="//iframe[@class='fancybox-iframe']")
	private WebElement frameOfFirstImage;
	
	
	public WebElement buttontweet() {
		return btnTweet;
		
	}
	
	public WebElement buttonShare() {
		
		return btnShare;
	}
	
	public int lengthofDescription() {
		isElementVisible(textDescription);
		String text=textDescription.getText();
		int length=text.length();
		return length;
	}
	
	public String checkUrl(String size) {
		SwitchtoFrame(frameOfFirstImage);
		textDescription.click();
		return selectFromDropDown(dropdown,size);
		
	}
	
	public String getLastChar() {		
		String url=getURL();
		char [] arr=url.toCharArray();
		char lastchar = 0;		 
		 int x=arr.length-1;
		 lastchar=arr[x];		 
		 return Character.toString(lastchar);
		 
	}
	
	

}
