package pageElements;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class WomenPage extends AbstractMethods {

	WebDriver driver;
	
	public WomenPage(WebDriver driver)  {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Women") WebElement womenLink;
	@FindBy(linkText="Jackets") WebElement jacketsLink;
	@FindBy(linkText="JunoJackets") WebElement JunojacketsLink;
	@FindBy(id="option-label-size-143-item-170") WebElement junoJacketSize;
	@FindBy(id="option-label-color-93-item-50") WebElement junoJacketColour;
	@FindBy(id="product-addtocart-button") WebElement addToCartjunoJacket;
	@FindBy(xpath="//div[contains(text(),'You added Juno Jacket to your ')]") WebElement addedToCartmessage;
	@FindBy(xpath="//a[@class='action showcart']") WebElement cartBtn;
	@FindBy(id="btn-minicart-close") WebElement closeCart;
	@FindBy(xpath="//a[contains(text(),'Inez Full Zip Jacket ')]") WebElement inezjacketsLink;
	@FindBy(xpath="//a[@title='Add to Compare']") WebElement jacketToCompare;
	@FindBy(xpath="//a[contains(text(),'Riona Full Zip Jacket ')]") WebElement rionajacketsLink;
	@FindBy(xpath="//a[@class='action compare primary']") WebElement compareBtn;
	@FindBy(xpath="//a[@class='action primary']/span[text()='Create an Account'][1]") WebElement createAccountBtn;
	
	public void clickWomenLink() {
		womenLink.click();
	}
	public void addJacketToCart() {
		implicitlyWaitMethod();
		jacketsLink.click();
		JunojacketsLink.click();
		junoJacketSize.click();
		junoJacketColour.click();
		addToCartjunoJacket.click();
		System.out.println(addedToCartmessage.getText());
		cartBtn.click();
		closeCart.click();
		
	}
	
	public void compareJackets() throws IOException {
		implicitlyWaitMethod();
		jacketsLink.click();
		Actions a = new Actions(driver);
		a.scrollToElement(inezjacketsLink).build().perform();
		a.moveToElement(inezjacketsLink).build().perform();
		jacketToCompare.click();
		a.moveToElement(rionajacketsLink).build().perform();
		jacketToCompare.click();
		a.scrollToElement(compareBtn).build().perform();
		compareBtn.click();
		
		TakesScreenshot sc= (TakesScreenshot) driver;
		File src3= sc.getScreenshotAs(OutputType.FILE);
		File dest3=new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 3- Automation\\gridview.jpeg");
		FileHandler.copy(src3, dest3);
		System.out.println("Screenshot of compare products Taken");
	}
	
	public void createAccountAfterCheckout() {
		implicitlyWaitMethod();
		Homepage hp=new Homepage(driver);
		hp.address();
		PaymentPage p= new PaymentPage(driver);
		p.applydiscount();
		createAccountBtn.click();
		CreateAccount ca= new CreateAccount(driver);
		ca.enterName("purva","k");
		ca.enterCredentials("purva@gmail.com", "123456");
		ca.createAccount();
	}
	
}
