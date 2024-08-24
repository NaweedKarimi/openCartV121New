package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

//	This is the parent of all classes and contains all common methods
//	and all class extends from baseClass

	public static WebDriver driver;
	public Logger logger; // we need to import logger object log4j
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regressions", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
//		loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("excution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilites = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				capabilites.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("Mac")) {
				capabilites.setPlatform(Platform.MAC);
			} else {
				System.out.println("Not matching Operating system");
			}

			if (br.equalsIgnoreCase("chrome")) {
				capabilites.setBrowserName("Chrome");
			} else if (br.equalsIgnoreCase("edge")) {
				capabilites.setBrowserName("MicrosoftEdge");
			} else {
				System.out.println("Invalid browser...");
			}

			driver = new RemoteWebDriver(new URL("http://172.16.40.152:4444/wd/hub"), capabilites);

		}
		if (p.getProperty("excution_env").equalsIgnoreCase("local")) {

			if (br.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (br.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (br.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid browser....");
			}
		}

		driver = new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/");  now we can read from properties file
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "Sanity", "Regressions", "Master" })
	public void tearDown() {
		driver.close();
	}

//	Creating user defind method to generate random data from RamdomStringUtils class 
//	belong to Apache Apache Commone libarary 

//	1 Random String method
	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String NumericRandom() {
		String generateInteger = RandomStringUtils.randomNumeric(8);
		return generateInteger;
	}

	public String RandomAlphaNumberic() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		String generateInteger = RandomStringUtils.randomNumeric(8);
		return (generateString + "@" + generateInteger);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // time stamp

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}