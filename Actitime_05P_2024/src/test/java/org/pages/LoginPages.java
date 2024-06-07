package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.utilies.GenericUtility;


public class LoginPages extends GenericUtility  {
//WebElemtents
	private WebDriver driver;
	@FindBy(id="")
	private WebElement uNameTxtField;
	
	@FindBy(css=".textField.pwdfield")
	private WebElement pwdTxtField;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepLoggedInCheckBox;
	
	@FindBy(id="#loginButton>div")
	private WebElement loginBtn;
	
	@FindBy(id="#logoContainer img")
	private List<WebElement> loginLogos;
	
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	@FindBy(css="content.selected.tt>div:first-child")
	private WebElement TimeTrackTab;
	
	public LoginPages(WebDriver driver) {
		PageFactory.initElements(driver, LoginPages.class);
	}
	
	public boolean isUserNameFieldDisplyed() {
//	boolean flag = uNameTxtField.isDisplayed();
	//	return flag;
		return isElementDisplayed(driver, uNameTxtField);
	}
	public boolean isPasswordFieldDisplyed(){
		return isElementDisplayed(driver, pwdTxtField);
		
	}
	public boolean keepLoggedInCheckBoxDisplyed(){
		return isElementDisplayed(driver, keepLoggedInCheckBox);
	}
	public boolean LoginButtonDisplyed(){
		return isElementDisplayed(driver, loginBtn);
	}
	public boolean LoginLogosDisplyed() {
		for(int i =0;i<2;i++) {
			try {
				if(isElementDisplayed(driver,loginLogos.get(i))) {
					return false;
				}
				}catch(Exception e) {
					return false;
				}
			}
		return true;
		}
	public void enterUserName(String uName) {
		uNameTxtField.sendKeys(uName);
	}
		public void enterPassword(String pwd) {
			pwdTxtField.sendKeys(pwd);

	}
		public void clickOnloginBtn() {
			loginBtn.click();
			Reporter.log("Clicked on login button");
			waitForVisibilityByEle(driver, 0, logoutLink);
		}
		public boolean isTimeTrackTabDisplyed(String pwd) {
			return isElementDisplayed(driver, TimeTrackTab ) ;

	}
		public String getLoginPageTitle() {
			return driver.getTitle();
		}
	public String getLoginURL() {
		return driver.getCurrentUrl();
	}
	public Dashboardpages dologin(String uName,String pwd) {
		enterUserName("uName");
		enterPassword("pwd");
		clickOnloginBtn();
		return new Dashboardpages (driver);
	}
	}

	

