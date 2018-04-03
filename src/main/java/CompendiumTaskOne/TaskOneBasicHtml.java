package CompendiumTaskOne;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskOneBasicHtml {
	public static WebDriver driver;

	// For Launching browser
	public TaskOneBasicHtml() {
		System.setProperty("webdriver.chrome.driver", "Path of the Chrome file");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://compendiumdev.co.uk/selenium/basic_html_form.html");
	}

	// To enter data in the form
	public static void getData()  {
		driver.findElement(By.name("username")).sendKeys("Tom");
		driver.findElement(By.name("password")).sendKeys("Dumitru");
		driver.findElement(By.name("comments")).clear();
		driver.findElement(By.name("comments")).sendKeys("Nothing as such");
		driver.findElement(By.name("filename")).sendKeys("Path of the file to upload");
		driver.findElement(By.xpath("//*[@value='cb3']")).click();
		List<WebElement> checkboxItems = driver.findElements(By.xpath("//*[@type='checkbox']"));
		checkboxItems.get(0).click();
		Boolean radioValue = driver.findElement(By.xpath("//*[@value='rd2']")).isSelected();
		if (radioValue.equals(true)) {
			driver.findElement(By.xpath("//*[@value='rd1']")).click();
		}
		// For Multiple Select Values
		Select selectItem = new Select(driver.findElement(By.xpath("//*[@name='multipleselect[]']")));
		selectItem.deselectByIndex(3);
		selectItem.selectByIndex(2);

		// For Dropdown
		Select dropdownItem = new Select(driver.findElement(By.xpath("//*[@name='dropdown']")));
		dropdownItem.selectByIndex(3);

		driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

	public static String verifyAfterClick() {
		// Go back to the main form
		String titleOfThePage = driver.getTitle();
		return titleOfThePage;
	}
	
	public static void backToHomePage() {
		driver.navigate().back();
	}
}
