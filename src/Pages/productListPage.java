package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productListPage {
	public static  WebDriver driver;
	
	public static By AddToWishListIcon = By.xpath("(//div[@data-testid=\"wishlist-icon\"])[1]");
	public static By LoginHereButton = By.xpath("//button[@data-testid=\"login-button\"]");
	public static By CrossIcon = By.xpath("//button[@data-identifier=\"LOGIN_AND_REGISTER\"]");
	public static By LoginRegisterButton = By.xpath("//button[@data-testid=\"login_reg_switch_btn\"]");
	public static By Email = By.xpath("//input[@name=\"email\"]");
	public static By Password = By.xpath("//input[@name=\"password\"]");
	public static By LoginButton = By.xpath("//button[@type=\"submit\"]");
	public static By wishListCounter = By.xpath("//span[@data-testid=\"wishlist-counter\"]");
	public static By wishListIcon = By.xpath("(//span[@class=\"IconsButtonTray__MenuIconWrapper-sc-1k6jcrl-1 ktRzWe\"])[3]");
	
	public productListPage(WebDriver driver)
	{
		productListPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public productListPage clickOnAddToWhishListIcon()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddToWishListIcon));
		driver.findElement(AddToWishListIcon).click();
		return this;
	}
	
	public productListPage clickOnLoginHereButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginHereButton));
		driver.findElement(LoginHereButton).click();
		return this;
	}
	
	public productListPage clickonCrossIcon() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CrossIcon));
		driver.findElement(CrossIcon).click();
		return this;
	}
	
	public productListPage Login()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginRegisterButton));
		driver.findElement(LoginRegisterButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		driver.findElement(Email).sendKeys(Config.Configuration.userName);
		driver.findElement(Password).sendKeys(Config.Configuration.password);
		driver.findElement(LoginButton).click();
		return this;
	}
	
	public productListPage VerifyProductIsAddedToWishList()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wishListCounter));
		driver.findElement(wishListCounter).isDisplayed();
		return this;
	}
	
	public productListPage clickOnWishListIcon()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(wishListIcon));
		driver.findElement(wishListIcon).click();
		return this;
	}
}
