package pageElements;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class WhatsNewPage extends AbstractMethods{
	WebDriver driver;
	public WhatsNewPage(WebDriver driver)
	{super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
@FindBy(id="ui-id-3") WebElement WhatsNewLink;
@FindBy(linkText="Jackets") WebElement jacketsLink;
@FindBy(xpath="//div[@id='authenticationPopup']/following-sibling::div[1]/child::div/child::strong[2]/following-sibling::a") WebElement listview;
@FindBy(xpath="//div[@id='authenticationPopup'][1]/following-sibling::div[1]/div[@class='toolbar-sorter sorter'][1]/child::select")	WebElement sortBtn;
@FindBy(xpath="//div[@id='authenticationPopup'][1]/following-sibling::div[1]/div[@class='toolbar-sorter sorter'][1]/child::select/child::option")  List<WebElement> sortOptions;
	@FindBy(xpath="//h2[contains(text(),\"Luma's Latest\")]") WebElement LumasLatestText;

	public void clickWhatsNew() {
		implicitlyWaitMethod();
		WhatsNewLink.click();
		String title= driver.getTitle();
		System.out.println(title);
		}
	public void clickjacketsLink() {
		jacketsLink.click();
	}
	public void viewMode() throws IOException {
		implicitlyWaitMethod();
		TakesScreenshot sc= (TakesScreenshot) driver;
		File src1= sc.getScreenshotAs(OutputType.FILE);
		File dest1=new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 3- Automation\\gridview.jpeg");
		FileHandler.copy(src1, dest1);
		System.out.println("Screenshot of grid view Taken");
		
		listview.click();
		File src2= sc.getScreenshotAs(OutputType.FILE);
		File dest2=new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 3- Automation\\listview.jpeg");
		FileHandler.copy(src2, dest2);
		System.out.println("Screenshot of list view Taken");
	}
	public void sort() {
		sortBtn.isEnabled();
		
	}
	public List<WebElement> sortByPosition(){
		System.out.println("=======sortByPosition=======");
		for(WebElement position:sortOptions) {
			System.out.println("Products- "+position.getText());
		}
		return sortOptions;
	}
	public List<WebElement> sortByProductName(){
		System.out.println("=======sortByPosition=======");
		for(WebElement productname:sortOptions) {
			System.out.println("Products- "+productname.getText());
		}
		return sortOptions;
	}
	public List<WebElement> sortByPrice(){
		System.out.println("=======sortByPosition=======");
		for(WebElement price:sortOptions) {
			System.out.println("Products- "+price.getText());
		}
		return sortOptions;
	}
	
	public void LumaslatestText() {
		System.out.println(LumasLatestText.getText());
	}
}
