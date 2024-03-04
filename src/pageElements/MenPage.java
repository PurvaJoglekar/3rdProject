package pageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class MenPage extends AbstractMethods{
	WebDriver driver;
	
	public MenPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Men") WebElement MenLink;
	@FindBy(linkText="Tees") WebElement TeesLink;
	@FindBy(linkText="Strike Endurance Tee ") WebElement StrikeEnduranceTeeLink;
	@FindBy(xpath="//a[@title='Add to Wish List']") WebElement addToWishlist;;
	@FindBy(xpath="//div[contains(@data-bind,'html: $parent.')]") WebElement addedToWishlistMsg;
	
	
	Login l;
	
	public void clickMenLink() {
		implicitlyWaitMethod();
		l=new Login(driver);
		l.clickSignupLink();
		l.validCredentials("purva123@gmail.com", "Purva@123");
		MenLink.click();
	}
	public void addTeeToWishlist() {
		implicitlyWaitMethod();
		TeesLink.click();
		Actions a = new Actions(driver);
		a.scrollToElement(StrikeEnduranceTeeLink).build().perform();
		a.moveToElement(StrikeEnduranceTeeLink).build().perform();
		addToWishlist.click();
		System.out.println(addedToWishlistMsg.getText());
	}
	
}
