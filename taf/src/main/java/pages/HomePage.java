package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends PageBase {


	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}


	By countryselect = By.xpath("//a[@class='country']");
	By country_btn = By.xpath("//a[@id='country-btn']");


	//plans//
	public	By name_lite_text = By.id("name-lite");

	public	By name_classic_text = By.id("name-classic");

	public	By name_premium_text = By.id("name-premium");


	//currency//
	public	By currency_lite_text = By.xpath("//div[@id='currency-lite']/b");

	public	By currency_classic_text = By.xpath("//div[@id='currency-classic']/b");

	public	By currency_premium_text = By.xpath("//div[@id='currency-premium']/b");



	public String Validation_name_lite_plan() {

	return 	driver.findElement(name_lite_text).getText();


	}

	public String Validation_name_lite_currency() {

		return 	driver.findElement(currency_lite_text).getText();


	}

	public String Validation_name_classic_plan() {

		return 	driver.findElement(name_classic_text).getText();
	}

	public String Validation_name_classic_currency() {

		return 	driver.findElement(currency_classic_text).getText();
	}



	public String Validation_name_premium_plan() {

		return 	driver.findElement(name_premium_text).getText();
	}

	public String Validation_name_premium_currency() {

		return 	driver.findElement(currency_premium_text).getText();

	}







	public void Selectcountry(String countryName) {

		try {


		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='country ']"));
		System.out.println("Number of elements:" + elements.size());
		for (WebElement choosecountry : elements)
		{
			if (choosecountry.getText().trim().equals(countryName)){
				choosecountry.click();
		 }
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


		public void OpenCountry (String country){


		    waitForElementToApprea(country_btn);
			clickButton(country_btn);
			Selectcountry(country);

		}


	}



