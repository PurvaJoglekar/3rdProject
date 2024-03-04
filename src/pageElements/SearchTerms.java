package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTerms {
	WebDriver driver;
	public SearchTerms(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Search Terms']") WebElement searchTermsLink;
	public void searchterms() {
		searchTermsLink.click();
		String title= driver.getTitle();
		System.out.println(title);
	}
}
