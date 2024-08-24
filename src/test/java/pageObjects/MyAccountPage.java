package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement MyAccount_Message;
	
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement Logout_Btn;
	
	
	public boolean is_MyAccountExist() {
		try {
		return MyAccount_Message.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
	
	public void logout_Btn() {
		Logout_Btn.click();
	}

}
