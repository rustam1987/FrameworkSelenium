package SetUp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Generic_methods {
	public  WebDriver driver;
	
	public  void setBrowserType(String browser){
		
	if(browser.equalsIgnoreCase("chrome")){
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"\\browserDriver\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();	
		driver.manage().window().maximize();
	}
	else if(browser.equalsIgnoreCase("ie")){
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", dir+"\\browserDriver\\IEDriverServer_x64_3.6.0\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}
	else{
		System.out.println("Please check browser type");
		
	}

	}
	public void getUrl(String url, int timeOutWait){
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(timeOutWait, TimeUnit.SECONDS);
	}
	public String getVal(String propertyVal) throws Exception{
		String dr=System.getProperty("user.dir");
		
		File pl=new File(dr+"\\Config.poperties");
		FileInputStream st=new FileInputStream(pl);
		Properties pr=new Properties();
		pr.load(st);
		return pr.getProperty(propertyVal);
	
	}
	public boolean isDisplayed(WebElement element){
		if(element.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
		
	
	}
	
	public boolean pageContain(String text){
		if(driver.getPageSource().contains(text)){
			return true;
		}
		else{
			return false;
		}
		
	}
	public void closeBrowser(){
		driver.close();
	}
	public String getPageTitle(){
		return driver.getTitle();
		
	}
	public void clickElement(WebElement element){
		element.click();
	}
	public void navigateBack() throws Exception{
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
	}
	
}
