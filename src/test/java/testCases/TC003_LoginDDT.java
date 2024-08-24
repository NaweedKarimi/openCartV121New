package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid ---> login success--> test passed----> logout
 * Data is valid ---> login failed --> test failed
 * 
 * Data is invalid --> login success -->test failed logout
 * Data is invalid --> login failed ---> test passed
 */

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "Logindata", dataProviderClass=DataProviders.class, groups="datadriven")    //	if data provider is in other class we need two parameter (detaProvider="name", dataProviderClass=DataProvider.class)
	public void TC003_LoginDDT(String email, String password, String exp) {

		logger.info("TC003 started.....");

		try {
			HomePage hp = new HomePage(driver);
			hp.ClickMyaccount();
			hp.ClickLoginBtn();

//	login page
			LoginPage l = new LoginPage(driver);
			l.LoginEmailAddress(email);
			l.LoginPassword(password);
			l.ClickLoginPage();

//	MyAccountPage

			MyAccountPage ac = new MyAccountPage(driver);
			boolean target = ac.is_MyAccountExist();

			if (exp.equalsIgnoreCase("Valid")) {
				if (target == true) {
					ac.logout_Btn();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (target == true) {
					ac.logout_Btn();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC003 finished....");
	}
}
