package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}

//Locators

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement First_Name_Filed;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement Last_name_Filed;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email_Filed;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement Telphone_Number_Filed;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password_Filed;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement Confirm_Password;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement Privacy_PolicyBtn;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue_Btn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Account_Success_Message;

//	Action methods

	public void setuserName(String name) {
		First_Name_Filed.sendKeys(name);
	}

	public void setlastName(String lastname) {
		Last_name_Filed.sendKeys(lastname);
	}

	public void setEmail(String email) {
		email_Filed.sendKeys(email);
	}

	public void TelphoneNumber(String phone) {
		Telphone_Number_Filed.sendKeys(phone);
	}

	public void setPassword(String password) {
		password_Filed.sendKeys(password);
	}

	public void confirmPassword(String cpassword) {
		Confirm_Password.sendKeys(cpassword);
	}

	public void Click_Privacy_check() {
		Privacy_PolicyBtn.click();
	}

	public void Click_ContinueBtn() {
		Continue_Btn.click();
	}

	public String Account_Success_Message() {

		try {
			return Account_Success_Message.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
