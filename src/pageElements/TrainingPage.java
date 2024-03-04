package pageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingPage {

WebDriver driver;
	
	public TrainingPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Training']") WebElement TrainingLink;
	@FindBy(xpath="//p[text()='Stream free with subscription']") WebElement text;
	@FindBy(linkText="Notes ") WebElement notesLink;
	public void traininglink() {
		TrainingLink.click();
		String title= driver.getTitle();
		System.out.println(title);
	}
	public void usingArrowBtn() {
		try {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		text.isDisplayed();
		notesLink.click();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
}
