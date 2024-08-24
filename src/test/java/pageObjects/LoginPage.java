package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
//	Constructore
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
//	Locator
	
	@FindBy(xpath="//input[@name='email']")
	WebElement Login_Email_Faild;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement Login_Password_Filed;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement Login_page_LoginBtn;
	
	public void LoginEmailAddress(String email) {
		Login_Email_Faild.sendKeys(email);
	}
	
	public void LoginPassword(String password) {
		Login_Password_Filed.sendKeys(password);
	}
	
	public void ClickLoginPage() {
		Login_page_LoginBtn.click();
	}

}
