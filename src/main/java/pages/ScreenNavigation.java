package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScreenNavigation {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//a[@class='current active']")
	WebElement homeButton;
	
	@FindBy(xpath = "//ul[@class='tabbed-primary-navigation']/li[4]")
	WebElement moviesTab;
	
	@FindBy(xpath = "//div[@class='label']")
	WebElement GenerButton;
	
	@FindBy(xpath= "(//div[@class='previewModal--metadatAndControls-container'] //button[@class='color-supplementary hasIcon round ltr-11vo9g5'])[3]")
	WebElement expandButton;
	
	@FindBy(xpath = "(//div[@class='buttonControls--container']/div)[1]")
	WebElement AddToWatchlistButton;
	
	//div[@class='buttonControls--container']/div //button[@aria-label='Remove from My List'])[1]
	@FindBy(xpath = "(//div[@class='buttonControls--container']/div)[1]")
	WebElement RemoveFromWatchlistButton;
	
	@FindBy(xpath="//div[@class='ltr-1rjg9xf'] //div[@class='boxart-size-16x9 boxart-container boxart-rounded']")
	List<WebElement> railContent;
	
	
	public ScreenNavigation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void checkActive() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("signIn")));
        Assert.assertTrue(homeButton.getText().equalsIgnoreCase("Home"));
	}
	
	public void menuBarNaviagation() {
		moviesTab.click();
	}
	
	public void SelectGenre() throws InterruptedException {
		Thread.sleep(4000);
		GenerButton.click();
		List<WebElement> genrename = driver.findElements(By.xpath("//div[@class='sub-menu theme-lakira']/ul/li"));
		for(WebElement ele : genrename) {
			if(ele.getText().contains("Telugu")) {
				ele.click();
				break;
			}
		}
	}
	
	public void selectitem() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> railname = driver.findElements(By.xpath("//div[@class='row-header-title']"));
		System.out.println(railname.size());
		for(WebElement ele : railname) {
			if(ele.getText().contains("Continue Watching for BR")) {
				ele.click();
				break;
			}
		}
	}
	
	public void addToWatchlist() throws InterruptedException {
		Thread.sleep(4000);
		//Frist get the Xpath of the continue watching pop up and then get the elements xpath then combine it using space
		//List<WebElement> railContent = driver.findElements(By.xpath("//div[@class='ltr-1rjg9xf'] //div[@class='boxart-size-16x9 boxart-container boxart-rounded']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ltr-1rjg9xf'] //div[@class='boxart-size-16x9 boxart-container boxart-rounded']")));
		

		System.out.println(railContent.size());
		for(WebElement content : railContent) {
			
			if(content.getText().contains("Stree")) {
				
				Actions a = new Actions(driver); 
				a.moveToElement(content).build().perform();
				Thread.sleep(2000);
				expandButton.click();
				AddToWatchlistButton.click();
				Thread.sleep(2000);
				System.out.println("Content Added Successfully");
//				if(AddToWatchlistButton.isDisplayed()) {
//					Assert.assertTrue(false);
//				}
//				else {
//					System.out.println("Content Added Successfully");
//					RemoveFromWatchlistButton.click();
//					if(RemoveFromWatchlistButton.isDisplayed()) {
//						Assert.assertTrue(false);
//					}
//					else
//					{
//						System.out.println("Content Removed Successfully");
//					}
//				}
				Thread.sleep(2000);
				RemoveFromWatchlistButton.click();
				System.out.println("Content Removed Successfully");
				break;
				
			}
		}
	}

}
