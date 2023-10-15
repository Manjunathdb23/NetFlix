package classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.ScreenNavigation;
import pages.driverClass;


public class AppScreen extends driverClass {

	//WebDriver driver = new ChromeDriver();
	
	
	@Test(dependsOnMethods = "profileLaunch")
	public void firstNavigation() {
		sn.checkActive();
	}
	
	@Test(dependsOnMethods = "firstNavigation")
	public void moviesTabLaunch() {
		sn.menuBarNaviagation();
	}
	
	@Test(dependsOnMethods = "moviesTabLaunch")
	public void generPick() throws InterruptedException {
		sn.SelectGenre();
		
	}
	
}
