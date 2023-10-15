package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_userLoginId")
	WebElement mailBox;
	
	@FindBy(xpath="//input[@id='id_password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='btn login-button btn-submit btn-small']")
	WebElement signInButton;
	
	@FindBy(xpath = "//span[contains(text(),'Remember me')]")
	WebElement checkBox;
	
	@FindBy(className="ui-message-contents")
	WebElement errorMessage;
	
	@FindBy(xpath ="(//a[@class='profile-link'])[1]")
	WebElement profileButton;
	
	public void enterMailandPass(String s, String p) {
		mailBox.sendKeys(s);
		password.sendKeys(p);
	}
	
	public void SignIn() {
		signInButton.click();
	}
	
	public void clickCheckBox() {
		checkBox.click();
	}
	
	public void errorspan() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-message-contents")));
		File src = errorMessage.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\manjunath.db\\Documents\\manju\\netflixerror.png"));
		
	}
	
	public void profileClick() throws InterruptedException {
		profileButton.click();
		Thread.sleep(5000);
		
	}
	
	public void alertclose() {
		Alert art = driver.switchTo().alert();
		System.out.println(art.getText());
		art.dismiss();
	}

}
