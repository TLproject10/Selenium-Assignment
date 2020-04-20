package tt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author Amit
 *
 */
public class SeleniumAssignment 
{

	WebDriver driver;
	
	/**
	 * preconditions
	 */
	@BeforeClass
	public void preCondition()
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/**
	 * check Duplicate values In Dropdown
	 */
	@Test(priority=1)
	public void checkDuplicateInDropdown()
	{
		driver.get("https://www.facebook.com/");
		WebElement ele = driver.findElement(By.xpath("//select[@id='month']"));
		Select sel=new Select(ele);
		List<WebElement> allEle = sel.getOptions();
		HashSet value=new HashSet(allEle);
		
		Assert.assertEquals(allEle.size(),value.size());
		System.out.println("duplicate value in dropdown is verified");	
	}
	
	/**
	 * Check Sorted Formet In Dropdown
	 */
	@Test(priority=2)
	public void CheckSortedFormetInDropdown()
	{

		driver.get("https://www.facebook.com/");
		WebElement ele=driver.findElement(By.xpath("//select[@id='month']"));
		
		Select sel=new Select(ele);
		
		List<WebElement> allEle = sel.getOptions();
		
		ArrayList unsortedElements=new ArrayList();
		ArrayList sortedElements=new ArrayList();
		for(WebElement el:allEle)
		{
			sortedElements.add(el.getText());
			unsortedElements.add(el.getText());
		}
		
		Collections.sort(sortedElements);
     	Assert.assertEquals(sortedElements,unsortedElements);
		
    	System.out.println(" dropdown elements is sorted");
	}
	
	

	/**
	 * Check Dropdown Contain All Element
	 */
	@Test(priority=3)
	public void CheckDropdownContainAllElement()
	{

		driver.get("https://www.facebook.com/");
		WebElement ele=driver.findElement(By.xpath("//select[@id='month']"));
		
		Select sel=new Select(ele);
		
		List<WebElement> allEle = sel.getOptions();
		
		ArrayList actualValues=new ArrayList();
		actualValues.add("Month");
		actualValues.add("Jan");
		actualValues.add("Feb");
		actualValues.add("Mar");
		actualValues.add("Apr");
		actualValues.add("May");
		actualValues.add("Jun");
		actualValues.add("Jul");
		actualValues.add("Aug");
		actualValues.add("Sept");
		actualValues.add("Oct");
		actualValues.add("Nov");
		actualValues.add("Dec");
		
     	for(int i=0;i<allEle.size();i++) 
		{
			Assert.assertEquals(allEle.get(i).getText(),actualValues.get(i));
		}
    	System.out.println("dropdown has all elements is verfied");
	}
}
