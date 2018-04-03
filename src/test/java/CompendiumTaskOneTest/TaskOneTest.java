package CompendiumTaskOneTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CompendiumTaskOne.TaskOneBasicHtml;

public class TaskOneTest extends TaskOneBasicHtml {

	public TaskOneTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		
	}

	@Test(priority=1)
	public void getDataTest(){
		getData();
	}
	
	@Test(priority=2)
	public void verifyAfterClickTest() {
		String title = verifyAfterClick();
		System.out.println(title);
		Assert.assertEquals(title, "Processed Form Details");
	}
	
	@Test(priority=3)
	public void backToHomePageTest(){
		backToHomePage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
