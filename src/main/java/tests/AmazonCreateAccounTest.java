package tests;
import java.sql.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.AmazonHomePage;

import SetUp.Generic_methods;

public class AmazonCreateAccounTest extends Generic_methods {
	AmazonHomePage oAmazonHomePage;
	SoftAssert softassert;
	Connection con;
	public String name;
	public String email;
	public String passw;
	@BeforeSuite
	public void setUpBrowser() throws Exception{
		String browserType=getVal("browser");
		setBrowserType(browserType);	
		String env=getVal("envirnment");
		if(env.equalsIgnoreCase("PROD")){
			String url=getVal("ProdUrl");
			getUrl(url, 50);
		}
		else if(env.equalsIgnoreCase("stage")){
			String url=getVal("StageUrl");
			getUrl(url, 50);
		}else{
			System.out.println("Please check url and environment ");
		}
			
	}
	@Test(priority=1,enabled=true)
	public void validateHomePage() throws Exception{
		String expected=getVal("homePageTitle");
		String actual=getPageTitle();
		softassert=new SoftAssert();
		softassert.assertEquals(actual, expected);
	}
	@Test(priority=2,enabled=true)
	public void creatAcc(){
		oAmazonHomePage=new AmazonHomePage(driver);
		clickElement(oAmazonHomePage.signIn);
		boolean val=isDisplayed(oAmazonHomePage.SinginPage);
		Assert.assertTrue(val, "Sign in");
		clickElement(oAmazonHomePage.creatAcc);
		try{
			Thread.sleep(5000);
			//get user test data from MySql database
			String dburl=getVal("dBUrl");
			String userName=getVal("uname");
			String pass=getVal("pass");
			
			String query="SELECT first_Name,email_address, password from students.information where id=101;";
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(dburl, userName,pass);
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(query);
			
			rs.next();
			
			name=rs.getString(1);
			email=rs.getString(2);
			passw=rs.getString(3);
			Thread.sleep(5000);
			//get data from database and set this value into name
			oAmazonHomePage.name.sendKeys(name);
			Thread.sleep(2000);
			oAmazonHomePage.email.sendKeys(email);
			Thread.sleep(2000);
			oAmazonHomePage.password.sendKeys(passw);
			Thread.sleep(2000);
			oAmazonHomePage.repassword.sendKeys(passw);
			Thread.sleep(2000);
		    closeBrowser();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
