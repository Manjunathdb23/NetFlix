package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageN {
	
	public loginPageN(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
	
	@FindBy(id = "signIn")
	WebElement signInIcon;
	
	public void launch(String s) {
		driver.get(s);
	}
	
	public void clickOnSignIn() {
		signInIcon.click();
	}

}
