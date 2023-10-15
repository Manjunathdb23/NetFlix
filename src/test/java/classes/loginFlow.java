package classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.ScreenNavigation;
import pages.SignInPage;
import pages.driverClass;
import pages.loginPageN;


public class loginFlow extends driverClass {

	
	loginPageN lp = new loginPageN(driver);
	String s = "https://www.netflix.com/in/";
	SignInPage sp = new SignInPage(driver);
	String Username = "JhonWick@gmail.com";
	String password = "12345678";
	ScreenNavigation sn = new ScreenNavigation(driver);
	 
	
	@Test
	public void checkSignInButton() {
		driver.manage().window().maximize();
		lp.launch(s);
		lp.clickOnSignIn();
	}
	
	//@Test(dependsOnMethods = {"checkSignInButton"}) 
//	public void SignInProcess() throws IOException {
//		sp.enterMailandPass(Username, password);
//		sp.clickCheckBox();
//		sp.SignIn();
//		sp.errorspan();
//	}
	
	@Test
	public void validLogin() {
		sp.enterMailandPass("rohinibahukutumbi98@gmail.com", "cowdog");
		sp.SignIn();
	}
	
	@Test(dependsOnMethods = "validLogin")
	public void profileLaunch() throws InterruptedException {
		sp.profileClick();
	}
	
//	@Test(dependsOnMethods = "profileLaunch")
//	public void alertDismiss() {
//		sp.alertclose();
//	}
	
//	@Test(dependsOnMethods = "profileLaunch")
//	public void firstNavigation() {
//		sn.checkActive();
//	}
}
