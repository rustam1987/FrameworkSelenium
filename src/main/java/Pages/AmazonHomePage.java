package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	private WebDriver driver;
	public AmazonHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//*[@id='nav-link-accountList']/span[1]")
	public WebElement signIn;
	
	@FindBy(id="createAccountSubmit")
	public WebElement creatAcc;
	
	@FindBy(xpath="//*[@id='nav-logo']/a[1]/span[1]")
	public WebElement Logo;
	
	@FindBy(xpath="//*[@id='a-page']/div[1]/div[3]/div/div/form/div/div/div/h1")
	public WebElement SinginPage;
	
	@FindBy(id="signInSubmit")
	public WebElement createAcc;
	
	@FindBy(id="ap_customer_name")
	public WebElement name;
	
	@FindBy(id="ap_email")
	public WebElement email;
	
	@FindBy(id="ap_password")
	public WebElement password;
	
	@FindBy(id="ap_password_check")
	public WebElement repassword;
	
	@FindBy(id="continue")
	public WebElement createAccButton;
	
	@FindBy(xpath="//*[@id='a-page']/div[1]/div[5]/div[2]/a[3]")
	public WebElement helpLink;
	
	

}
