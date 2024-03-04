package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotesPage {
	
	WebDriver driver;
	public NotesPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Subscribe']") WebElement SubscribeBtn;
	@FindBy(id="mce-EMAIL") WebElement emailTextbox;
	@FindBy(id="mce-FNAME") WebElement fnameTextbox;
	@FindBy(id="mce-LNAME") WebElement lnameTextbox;
	@FindBy(id="mc-embedded-subscribe") WebElement subscribeBtn;
	@FindBy(id="mce-success-response") WebElement successmsg;
	@FindBy(xpath="//span[text()='Write For Us']") WebElement Writeforus;
	public void clickSubscribe() {
		SubscribeBtn.click();
		emailTextbox.sendKeys("purva@gmail.com");
		fnameTextbox.sendKeys("purva");
		lnameTextbox.sendKeys("j");
		subscribeBtn.click();
		System.out.println(successmsg.getText());
	}
	public void writeForUs() {
		Writeforus.click();
		String title= driver.getTitle();
		System.out.println(title);
	}
}
