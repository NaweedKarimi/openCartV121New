package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	
//	Constractor
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
//	Locators
	
	@FindBy(xpath = "(//span[normalize-space()='My Account'])[1]")
	WebElement My_Account_Btn;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register_Btn;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement login_Btn;
	
	public void ClickMyaccount() {
		My_Account_Btn.click();
	}
	
	public void Click_RegisterationBtn() {
		Register_Btn.click();
	}
	
	public void ClickLoginBtn() {
		login_Btn.click();
	}
	

}
