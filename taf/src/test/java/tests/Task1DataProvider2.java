package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class Task1DataProvider2 extends TestBase
{
	HomePage homeObject ;


	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
				{"UAE" , "LITE","5.4","CLASSIC","10.9","PREMIUM","16.3"},
				{"Jordan" , "LITE","2.7","CLASSIC","5.2","PREMIUM","8"},
				{"Yemen" ,"LITE","2.4","CLASSIC","4.8","PREMIUM","7.2"}
		};
	}

	@Test(priority=1,dataProvider="testData")
	public void UserCanRegisterSuccssfully(String country, String plan1 , String price1 , String plan2, String price2,String plan3, String price3 ) {
		homeObject = new HomePage(getDriver());
		getDriver().navigate().to("https://subscribe.jawwy.tv" + "/eg-en");
	 	homeObject.OpenCountry(country);
		Assert.assertTrue(homeObject.Validation_name_lite_plan().contains(plan1));
		Assert.assertTrue(homeObject.Validation_name_lite_currency().contains(price1));

		Assert.assertTrue(homeObject.Validation_name_classic_plan().contains(plan2));
		Assert.assertTrue(homeObject.Validation_name_classic_currency().contains(price2));

		Assert.assertTrue(homeObject.Validation_name_premium_plan().contains(plan3));
		Assert.assertTrue(homeObject.Validation_name_premium_currency().contains(price3));

	}

}
