package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	public static  WebDriver driver;
	
	public static By searchBar = By.xpath("//input[@type=\"search\"]");
	public static By acceptCookieButton = By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]");
	
	public Homepage(WebDriver driver)
	{
		Homepage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Homepage AcceptCookie()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieButton));
		driver.findElement(acceptCookieButton).click();
		return this;	
	}
	
	public Homepage EnterDataInSearchBar(String data)
	{
		driver.findElement(searchBar).sendKeys(data);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		return this;
	}
	
}
