package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class driverClass {

	public static WebDriver driver = new ChromeDriver();
	public static ScreenNavigation sn = new ScreenNavigation(driver);
	
}
