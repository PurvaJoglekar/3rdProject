package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearch {
	WebDriver driver;
	public AdvancedSearch(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Advanced Search']") WebElement advsearchLink;
	public void advSearch(){
		advsearchLink.click();
		String title= driver.getTitle();
		System.out.println(title);
		}
}
