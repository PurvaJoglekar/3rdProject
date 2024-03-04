package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.AdvancedSearch;
import pageElements.CreateAccount;
import pageElements.Homepage;
import pageElements.Login;
import pageElements.MenPage;
import pageElements.NotesPage;
import pageElements.PaymentPage;
import pageElements.Sale;
import pageElements.SearchTerms;
import pageElements.TrainingPage;
import pageElements.WhatsNewPage;
import pageElements.WomenPage;

public class BaseTest {

	WebDriver driver;
	@BeforeTest
	public void InitializeBrowser() throws IOException {
		driver= new ChromeDriver();
		String url= "https://magento.softwaretestingboard.com/";
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void tc_1_validateHomePage() {
		Homepage homepage= new Homepage(driver);
		homepage.validatehomepage();
	}
	@Test(priority=2)
	public void tc_2_createAccount() {
		CreateAccount ca= new CreateAccount(driver);
		ca.createAccountLink();
		ca.enterName("Purva","Joglekar");
		ca.enterCredentials("purva1@gmail.com","Purva@1234567");
		ca.createAccount();		
	}
	@Test(priority=3)
	public void tc_3_myAccount() {
		CreateAccount ca= new CreateAccount(driver);
		ca.verifyMyAccount();
	}
	@Test(priority=4)
	public void tc_4_LoginValidCredentials() {
		Login login= new Login(driver);
		login.SignOut();
		login.clickSignupLink();
		login.validCredentials("purva123@gmail.com", "Purva@123");
	}
	@Test(priority=5)
	public void tc_5_LoginValidCredentials() {
		Login login= new Login(driver);
		login.SignOut();
		login.invalidCredentials("p@rediffmail.com", "p@123456");
	}
	@Test(priority=6)
	public void tc_6_LogOut() {
		Login login= new Login(driver);
		login.SignOut();
	}
	@Test(priority=7)
	public void tc_7_ValidateWhatsnew() {
		WhatsNewPage whatsnew= new WhatsNewPage(driver);
		whatsnew.clickWhatsNew();
		
	}
	@Test(priority=8)
	public void tc_8_ValidateviewSwitchMode() throws IOException {
		WhatsNewPage whatsnew= new WhatsNewPage(driver);
		whatsnew.clickjacketsLink();
		whatsnew.viewMode();
		
	}
	@Test(priority=9)
	public void tc_9_SortOption() {
		WhatsNewPage whatsnew= new WhatsNewPage(driver);
		whatsnew.sort();
		
		whatsnew.sortByPosition();
		whatsnew.sortByProductName();
		whatsnew.sortByPrice();
	}
	@Test(priority=10)
	public void tc_10_LumaslatestText() {
		WhatsNewPage whatsnew= new WhatsNewPage(driver);
		whatsnew.LumaslatestText();
	}
	@Test(priority=11)
	public void tc_11_WomenPage() {
	WomenPage wp= new WomenPage(driver);
	wp.clickWomenLink();
	wp.addJacketToCart();
	}
	@Test(priority=12)
	public void tc_12_CompareProducts() throws Exception {
		WomenPage wp= new WomenPage(driver);
		wp.compareJackets();
	}
	@Test(priority=13)
	public void tc_13_MenPage() {
		MenPage mp= new MenPage(driver);
		mp.clickMenLink();
		mp.addTeeToWishlist();
	}
	@Test(priority=14)
	public void tc_14_SearchProduct() {
		Homepage hp= new Homepage(driver);
		hp.HoodieList();
		
	}
	@Test(priority=15)
	public void tc_15_AddWatchToCart() {
		Homepage hp= new Homepage(driver);
		hp.searchWatch();
		hp.address();
		PaymentPage p=new PaymentPage(driver);
		p.applydiscount();
		
	}
	@Test(priority=16)
	public void tc_16_RemoveFromCart() {
		Homepage hp= new Homepage(driver);
		hp.removeFromcart();
	}
	@Test(priority=17)
	public void tc_17_SalePage() {
		Sale s= new Sale(driver);
		s.verifySalePage();
	}
	@Test(priority=18)
	public void tc_18_verifyDiscount() {
		Sale s= new Sale(driver);
		s.verifyDiscountedPrice();
		
	}
	@Test(priority=19)
	public void tc_19_Payment() {
		PaymentPage p=new PaymentPage(driver);
		p.applydiscount();
	}
	
	@Test(priority=19)
	public void tc_19_trainingPage() {
		TrainingPage tp= new TrainingPage(driver);
		tp.traininglink();
		
	}
	@Test(priority=20)
	public void tc_20_SctrollPage() {
		TrainingPage tp= new TrainingPage(driver);
		tp.usingArrowBtn();
	}
	@Test(priority=21)
	public void tc_21_NotesPage() {
		NotesPage np= new NotesPage(driver);
		np.clickSubscribe();
		
	}
	@Test(priority=22)
	public void tc_22_WriteForUs()
	{
		NotesPage np= new NotesPage(driver);
		np.writeForUs();
	}
	@Test(priority=23)
	public void tc_23_SearchTerms() {
		SearchTerms st= new SearchTerms(driver);
		st.searchterms();
	}
	
	@Test(priority=24)
	public void tc_24_advanceSearch() {
		AdvancedSearch a= new AdvancedSearch(driver);
		a.advSearch();
	}
	@Test(priority=25)
	public void tc_25_CreateAccAfterCheckout() {
		WomenPage wp= new WomenPage(driver);
		wp.createAccountAfterCheckout();
		
	}
	
	
	
}
