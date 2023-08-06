package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {



	public JavascriptExecutor jse ;
	public Select select ; 
	public Actions action ;

	private static final  int TiMEOUT=10;
	private static final int POLLING=100;

    protected static WebDriver driver;
	private WebDriverWait wait;

	// create constructor 
	public PageBase(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,TiMEOUT,POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,TiMEOUT),this);
	}


	protected void waitForElementToApprea(By locator)
	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	protected static void clickButton(By button)
	{


		driver.findElement(button).click();
	}

	protected static void setTextElementText(By textElement , String value)
	{
		driver.findElement(textElement).sendKeys(value);
	}

//	protected static String getTextElementText(By textElement)
//	{
//	 	return  driver.findElement(textElement).getText();
//	}


	public void scrollToBottom() 
	
	{
		jse.executeScript("scrollBy(0,2500)"); 
	}
	
	public void clearText(By element)
	{

		driver.findElement(element).clear();
	}


}
