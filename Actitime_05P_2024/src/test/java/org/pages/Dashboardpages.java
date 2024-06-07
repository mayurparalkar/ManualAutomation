package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilies.GenericUtility;


public class Dashboardpages extends GenericUtility{
private WebDriver driver;
///WebElement 
@FindBy(css=".content.selected.tt>div:first-child")
private WebElement timeTrckTab;
@FindBy(css="td[class*='navItem navCell']>a>div:first-child")
private List<WebElement> dashboardtabnames; 

//Constrctor
public  Dashboardpages(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}
public boolean isTimeTrackTabDisplyed() {
	return isElementDisplayed(driver, timeTrckTab);
}
public String getDashboardPageURL() {
	waitForURLContains(driver, 0, "submit_tt.do");
	return driver.getCurrentUrl();
}
public String getDashboardTitleURL() {
	waitForTitleContains(driver, 0,"Enter TIME-Track" );
	return driver.getTitle();
}
public int getDashboardTabsCount() {
	return dashboardtabnames.size();
}
public boolean verifyDashboardtabsDisplyed() {
	for(int i =0;i<4;i++) {
		try {
			if(!isElementDisplayed(driver,dashboardtabnames.get(i))) {
				return false;
			}
			}catch(Exception e) {
				return false;
			}
		}
	return true;
	}
}

