package pageElements;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import utilities.AbstractMethods;

public class CreateAccount extends AbstractMethods{

	WebDriver driver;
	public CreateAccount(WebDriver driver){
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create an Account')]") WebElement CreateAccountLink;
	@FindBy(id="firstname") WebElement firstname;
	@FindBy(id="lastname") WebElement lastname;
	@FindBy(id="email_address") WebElement email_address;
	@FindBy(id="password") WebElement password;
	@FindBy(id="password-confirmation") WebElement passwordconfirmation;
	@FindBy(xpath="//span[contains(text(),'Create an Account')]") WebElement CreateAccountBtn;
	@FindBy(xpath="//span[text()='My Account']") WebElement MyAccount;
	
	public void createAccountLink() {
		implicitlyWaitMethod();
	CreateAccountLink.click();
	String title= driver.getTitle();
	System.out.println(title);

}
	public void enterName(String fname,String lname) {
		implicitlyWaitMethod();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
	}
	public void enterCredentials(String email,String pword) {
		implicitlyWaitMethod();
		email_address.sendKeys(email);
		password.sendKeys(pword);
		passwordconfirmation.sendKeys(pword);
	}
	public void createAccount() {
		CreateAccountBtn.click();
	}
	public void verifyMyAccount() {
		System.out.println(MyAccount.getText());
	}
	
}