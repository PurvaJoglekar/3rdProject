package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.AbstractMethods;

public class Login extends AbstractMethods{
	WebDriver driver;
	public Login(WebDriver driver)
	{super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(linkText="Sign In") WebElement SignIn;
	@FindBy(id="email") WebElement emailid;
	@FindBy(id="pass") WebElement pass;
	@FindBy(id="send2")WebElement signInBtn;
	@FindBy(xpath="//div[@class='sections nav-sections']/child::div/child::div[4]/child::ul/child::li[2]/child::span/child::button") WebElement dropdown;
	@FindBy(xpath="//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]") WebElement signOut;
	@FindBy(xpath="//div[contains(@data-bind,'html: $parent')]") WebElement errormsg;
	public void clickSignupLink() {
		SignIn.click();
	}
	public void validCredentials(String email, String pword) {
		emailid.sendKeys(email);
		pass.sendKeys(pword);
		signInBtn.click();
	}
	public void SignOut() {
		
		implicitlyWaitMethod();
		dropdown.click();
		signOut.click();
	}
	public void invalidCredentials(String invalidemail, String invalidpword) {
		implicitlyWaitMethod();
		emailid.sendKeys(invalidemail);
		pass.sendKeys(invalidpword);
		signInBtn.click();
		System.out.println(errormsg.getText());
	}
	}
