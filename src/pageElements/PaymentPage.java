package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class PaymentPage extends AbstractMethods {
	WebDriver driver;
	public PaymentPage(WebDriver driver)
	{super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
	@FindBy(id="billing-address-same-as-shipping-checkmo") WebElement addresscheckBtn;
	@FindBy(xpath="//span[text()='Apply Discount Code']")WebElement applyDiscountCode;
	@FindBy(id="discount-code") WebElement DiscountCodeTextBox;
	@FindBy(xpath="//span[text()='Apply Discount']")WebElement applyDiscountBtn;
	@FindBy(xpath="//span[text()='Place Order']")WebElement PlaceOrderBtn;
	@FindBy(xpath="//span[text()='Thank you for your purchase!']")WebElement purchaseMsg;
	public void applydiscount() {
		implicitlyWaitMethod();
		addresscheckBtn.click();
		applyDiscountCode.click();
		DiscountCodeTextBox.sendKeys("20poff");
		applyDiscountBtn.click();
		PlaceOrderBtn.click();
	}
	public void purchaseMsg() {
		System.out.println(purchaseMsg.getText());
	}
}
