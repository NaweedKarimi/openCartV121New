package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups={"Sanity","Master"})
	public void  verify_Login() {
		logger.info("-----Starting TC_002_LoginTest");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.ClickMyaccount();
		hp.ClickLoginBtn();;
		
//		login page
		LoginPage l= new LoginPage(driver);
		l.LoginEmailAddress(p.getProperty("email"));
		l.LoginPassword(p.getProperty("password"));
		l.ClickLoginPage();
		
//		MyAccountPage
		
		MyAccountPage ac= new MyAccountPage(driver);
		boolean target=ac.is_MyAccountExist();
		Assert.assertEquals(target, true);
		
		logger.info("-----Finished TC_002_LoginTest----");
		} catch (Exception e) {
			Assert.fail();
		}
		
		
	}

	
	
}
