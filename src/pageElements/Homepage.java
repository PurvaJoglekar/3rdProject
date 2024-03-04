package pageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.AbstractMethods;

public class Homepage extends AbstractMethods{

		WebDriver driver;
		public Homepage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
	}
		
		public void validatehomepage() {
			String title= driver.getTitle();
			System.out.println("Title of homepage is "+title);
		}
		
		@FindBy(id="search") WebElement searchtab;
		@FindBy(xpath="//strong[@class=\"product name product-item-name\"]/a") List<WebElement> HoodieList;
		@FindBy(xpath="//a[contains(text(),\"Dash Digital Watch \")]") WebElement dashDigitalWatch;
		@FindBy(id="product-addtocart-button") WebElement addWatchTocart;
		@FindBy(xpath="//a[@class='action showcart']") WebElement cartBtn;
		@FindBy(id="top-cart-btn-checkout") WebElement checkout;
		@FindBy(id="email") WebElement emailid;
		@FindBy(name="firstname") WebElement firstname;
		@FindBy(name="lastname") WebElement lastname;
		@FindBy(name="company") WebElement company;
		@FindBy(name="street[0]") WebElement street0;
		@FindBy(name="street[1]") WebElement street1;
		@FindBy(name="street[2]") WebElement street2;
		@FindBy(name="city") WebElement city;
		@FindBy(name="region_id") WebElement region;
		@FindBy(name="country_id") WebElement country;
		@FindBy(name="postcode")WebElement zipcode;
		@FindBy(name="ko_unique_1")WebElement shippingmethodradiobtn;
		@FindBy(name="telephone")WebElement phoneNo;
		@FindBy(xpath="//span[text()='Next']")WebElement nextBtn;
		@FindBy(xpath="//span[text()='Remove']") WebElement remove;
		
		public void searchProduct() {
			implicitlyWaitMethod();
			searchtab.sendKeys("Hoodie");
		}
		public List<WebElement> HoodieList(){
			for(WebElement hoodie:HoodieList) {
				System.out.println("Hoodie List- "+hoodie.getText());
			}
			return HoodieList;
		}
		public void searchWatch() {
			implicitlyWaitMethod();
			searchtab.sendKeys("Watch");
			Actions a = new Actions(driver);
			a.scrollToElement(dashDigitalWatch).build().perform();
			a.moveToElement(dashDigitalWatch).build().perform();
			dashDigitalWatch.click();
			addWatchTocart.click();
			a.scrollToElement(cartBtn);
			cartBtn.click();
			checkout.click();
			
		}
		public void removeFromcart() {
			remove.click();
		}
		
		public void address() {
			implicitlyWaitMethod();
			emailid.sendKeys("purva123@gmail.com");
				
			firstname.sendKeys("Purva");
			lastname.sendKeys("j");
			company.sendKeys("ABC");
			street0.sendKeys("lane1");
			street1.sendKeys("abc colony");
			street2.sendKeys("Pune");
			city.sendKeys("Pune");
			
			Select s= new Select (country);
			s.selectByVisibleText("India");
			
			Select s1= new Select (region);
			s1.selectByVisibleText("Maharashtra");
			zipcode.sendKeys("123456");
			phoneNo.sendKeys("1230456789");
			shippingmethodradiobtn.click();
			nextBtn.click();
		}
		
		
		
		
		
		
}
