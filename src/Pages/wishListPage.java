package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wishListPage {
	public static  WebDriver driver;
	public static By RemoveIcon = By.xpath("//button[@class=\"blockListProduct__delete qaBlockListProduct__delete\"]");
	public static By WishListNoInfo = By.xpath("//div[@class=\"wishlistNoProducts__info\"]");
	
	public wishListPage(WebDriver driver)
	{
		wishListPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public wishListPage RemoveProductFromWishList() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RemoveIcon));
		driver.findElement(RemoveIcon).click();
		return this;	
	}
	
	public wishListPage VerifyProductIsRemoved() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(WishListNoInfo));
		driver.findElement(WishListNoInfo).click();
		return this;
	}
}
