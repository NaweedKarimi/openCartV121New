package testCases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regressions","Master"})
	public void verify_Account_Registration() {
		
		
		logger.info("***Starting TC001_AccountRegistrationTest....");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.ClickMyaccount();
		
		logger.info("***Clicking on My Acount link....");
		hp.Click_RegisterationBtn();
		logger.info("***Clicking on Registration link....");
		
		
		AccountRegistrationPage ac= new AccountRegistrationPage(driver);
		logger.info("***Customer details added....");
		
		ac.setuserName(randomString().toLowerCase());			// I add random to set user name to generate
		ac.setlastName(randomString());
		ac.setEmail(randomString()+"@gmail.com");
		ac.TelphoneNumber(NumericRandom());
		
		String password=RandomAlphaNumberic();
		ac.setPassword(password);
		ac.confirmPassword(password);
		ac.Click_Privacy_check();
		ac.Click_ContinueBtn();
		String confirmation_Message=ac.Account_Success_Message();
		
		logger.info("***Validating expected Messages....");
		
		Assert.assertEquals(confirmation_Message,"Your Account Has Been Created!");
		
		
		} catch(Exception e) {
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("***Finished TC001_AccountRegistrationTest....");
		
	}
	

	

	

}
