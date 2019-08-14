package Pages;

import org.openqa.selenium.By;

import BasePackage.DriverClass;

public class ProductRegister extends DriverClass{
	public By LoginEmailId = By.id("loginId");
	public By LoginPasswordId = By.id("loginId");
	public By LoginButton = By.id("doLogin");
	public By OtherAppButton = By.id("otherApp");
	public By POSButton = By.id("hmmaLayoutForm:posAppMenuItems:0:doFinishPosAppMenu");
	public By MonthlySubScriptioButton = By.id("doHmma090A3");
	public By ProductRegister = By.id("ticket_kbn_subscription");
	public By ProductNameTextBox = By.id("goodsName");
	public By UnlimitedOption = By.id("subscriptionUsageCountFlag0");
	public By Times99Option = By.id("subscriptionUsageCountFlag1");
	public By Times99textField = By.id("usageFrequency");
	public By TotalUsageCount = By.xpath("(//span[text()='合計回数'])[1]//following::td[1]");
	public By TotalTreamentTime = By.xpath("(//span[text()='合計回数'])[1]//following::td[2]");
    public By TotalPrice = By.xpath("(//span[text()='合計回数'])[1]//following::td[3]");
	public By AddTicketButton = By.xpath("//a[@class='btn btn_5c ml5']");
	
}
