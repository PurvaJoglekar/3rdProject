package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sale {
	WebDriver driver;
	public Sale(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Sale']") WebElement SaleLink;
	@FindBy(linkText="Pants") WebElement pantsLink;
	@FindBy(xpath="//a[text()='Cronus Yoga Pant '][1]") WebElement yogapantlink;
	@FindBy(xpath="//span[text()='Size']/parent::div/child::div/div[3]") WebElement yogapantsize;
	@FindBy(id="option-label-color-93-item-49") WebElement pantcolour;
	@FindBy(id="product-addtocart-button") WebElement addToCartBtn;
	@FindBy(xpath="//a[@class='action showcart']/span[text()='My Cart'][1]") WebElement cartBtn;
	@FindBy(xpath="//span[@class='minicart-price']/span[text()='$48.00'][1]") WebElement priceBeforeDiscount;
	@FindBy(id="top-cart-btn-checkout") WebElement checkout;
	@FindBy(xpath="//span[text()='$43.40'][1]")WebElement priceAfterDiscount;
	
	public void verifySalePage() {
		
	Login log= new Login(driver);
	log.clickSignupLink();
	log.validCredentials("purva123@gmail.com", "purva@123");
	
	SaleLink.click();
	String title= driver.getTitle();
	System.out.println(title);
	
	}

	public void verifyDiscountedPrice() {
		pantsLink.click();
		Actions a= new Actions (driver);
		a.scrollToElement(yogapantlink).build().perform();
		yogapantlink.click();
		yogapantsize.click();
		pantcolour.click();
		addToCartBtn.click();
		cartBtn.click();
		System.out.println("Price before discount is- ");
		System.out.print(priceBeforeDiscount.getText());
		checkout.click();
		
		PaymentPage p=new PaymentPage(driver);
		p.applydiscount();
		
		System.out.println("Price after discount is- ");
		System.out.print(priceAfterDiscount.getText());
		
	}
}
