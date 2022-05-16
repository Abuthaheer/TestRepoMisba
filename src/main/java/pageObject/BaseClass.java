package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public String browser = "chrome";

	public BaseClass() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\\\Users\\\\Dell\\\\Downloads\\\\chromedriver.exe");
				driver = new ChromeDriver();
			} /*
				 * else if (browser.equals("firefox")) {
				 * System.setProperty("webdriver.gecko.driver", "Firefox Driver Server Path");
				 * driver = new FirefoxDriver(); }
				 */
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}
	
	public void mouseHover(WebElement element) {
		Actions mouse=new Actions(driver);
		mouse.moveToElement(element).build().perform();
		
		
	}
	
	public void scrollThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement e = driver.findElement(By.id("confirm_password_password_2"));
		js.executeScript("window.scrollBy(0,300)");
		

	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}
	
	public void SwitchtoFrame(WebElement element) {
		
		driver.switchTo().frame(element);
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String getALertmsg() {
		Alert a=driver.switchTo().alert();
		String msg=a.getText();
		return msg;
		
	}
	
	public WebDriverWait Explicitlywait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;
	}
	public String getTitlte() {
		return driver.getTitle();
	}	
	public String getURL() {
	    return driver.getCurrentUrl();
	}
	
	public void quitDriver() {
		driver.quit();
	}
}

