package Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import Pages.Homepage;
import Pages.productListPage;
import Pages.wishListPage;

public class Task extends TestBase{	
	
	@Test
	public static void Verify() throws IOException
	{
		
	Homepage home = new Homepage(driver);
	productListPage product = new productListPage(driver);
	wishListPage wish = new wishListPage(driver);
	
	
	home.AcceptCookie()								// accepting cookies pop up
	.EnterDataInSearchBar("Mobel");					// entering mobel keyword in the search bar
	wait(20);										// implemented Wait 
	
	
	product.clickOnLoginHereButton()				// Click on login here button
	.clickonCrossIcon()								// Click on cross icon displayed login popup
	.clickOnAddToWhishListIcon()					// click on Heart icon
	.Login()										// Enter credentials and login
	.clickOnWishListIcon()							// Click on wish list icon in the header
	.VerifyProductIsAddedToWishList();				// verify product is added in the wish list
	
	
	ScreenCapture();								// Take screenshot of the added product in the wish list
	
	wish.RemoveProductFromWishList()				// Remove product from the wish list
	.VerifyProductIsRemoved();						// verify product is removed from the wish list
	
}
}