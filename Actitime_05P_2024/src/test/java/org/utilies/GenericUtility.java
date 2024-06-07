package org.utilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtility {
	
	
		

	public boolean isElementDisplayed(WebDriver driver, WebElement ele) {

		return true;
	}

	public void clickByAction(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.click().perform();
	}


	public void waitForFrameToSwitchByEle(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	public void waitForFrameToSwitchByObj(WebDriver driver, int time, By byObj) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(byObj));

	}

	public boolean isAleartPresent(WebDriver driver, int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public void selectByText(WebElement ddEle, String Text) {
		Select sel = new Select(ddEle);
		sel.selectByVisibleText(Text);
	}

	public void selectByvalue(WebElement ddEle, String value) {
		Select sel = new Select(ddEle);
		sel.selectByValue(value);
	}

	public void selectByText(WebElement ddEle, int index) {
		Select sel = new Select(ddEle);
		sel.selectByIndex(index);
	}

	public List<String> getAllSelectedOptionsText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		List<String> ar = new ArrayList<String>();
		for (int i = 0; i < sel.getAllSelectedOptions().size(); i++) {
			ar.add(sel.getAllSelectedOptions().get(i).getText());

		}
		return ar;
	}

	// wRITE REAMAING SELECT CLASS METHOD
	public List<String> getAllDDlOptionsText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		List<String> ar = new ArrayList<String>();
		for (int i = 0; i < sel.getOptions().size(); i++) {
			ar.add(sel.getOptions().get(i).getText());

		}
		return ar;
	}

	public List<String> getAllDDllOptionsText(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		List<String> ar = new ArrayList<String>();
		List<WebElement> allOptions = sel.getOptions();
		for (int i = 0; i < sel.getOptions().size(); i++) {
			ar.add(sel.getOptions().get(i).getText());
//	 or
			WebElement ele = allOptions.get(i);
			String str = ele.getText();
			ar.add(str);
		}
		return ar;
	}

	public String getDDLSelctedOption(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		return sel.getFirstSelectedOption().getText();

	}

	public int getDDLDataCount(WebElement ddlEle) {
		Select sel = new Select(ddlEle);
		return sel.getOptions().size();

	}

	public int getNumOfListData(List<WebElement> allEles) {

		return allEles.size();
	}

	public List<String> getAllTextOfList(List<WebElement> allEles) {
		ArrayList<String> ar = new ArrayList<String>();
		for (int i = 0; i < allEles.size(); i++) {
			ar.add(allEles.get(i).getText());
		}
		return ar;
	}

	public void scrollByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click;", ele);

	}

	public void ScrolByPageDown(WebDriver driver, int numofScroll) {
		for (int i = 1; i <= numofScroll; i++)
			;

		WebElement ele = driver.findElement(By.tagName("html"));
		ele.sendKeys(Keys.PAGE_DOWN);
	}

	public void waitForURLContains(WebDriver driver, int time, String partialURL) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(partialURL));
	}

	public void waitForTitleIs(WebDriver driver, int time, String exactTitle) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.titleContains(exactTitle));

	}

	public void waitForTitleContains(WebDriver driver, int time, String partialTitle) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.titleContains(partialTitle));

	}

	public void waitForVisibilityByObject(WebDriver driver, int time, By byObj) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(15));
		wt.until(ExpectedConditions.visibilityOfElementLocated(byObj));
	}

	public void waitForVisibilityByObjectType(WebDriver driver, int time, String type, String expression) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(15));

		if (type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(expression))));
		} else if (type.equalsIgnoreCase("class")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(expression))));
		} else if (type.equalsIgnoreCase("css")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(expression))));
		} else if (type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(expression))));
		}
	}

	// can be used to page object
	public void waitForVisibilityByEle(WebDriver driver, int time, WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForVisibiltyByType(WebDriver driver, int time, String type, String expression) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		if (type.equalsIgnoreCase("id")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(expression))));
		} else if (type.equalsIgnoreCase("class")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(expression))));
		} else if (type.equalsIgnoreCase("css")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(expression))));
		} else if (type.equalsIgnoreCase("xpath")) {
			wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(expression))));
		}
	}

	public WebDriver startUp(String bName, String url) {
		WebDriver driver = null;

		if (bName.equalsIgnoreCase("ch")) {

			// driver =new ChromeDriver();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--Start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if (bName.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--Start-maximized");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);

		} else if (bName.equalsIgnoreCase("ff")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--Start-maximized");
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);

		} else {
			System.out.println("Invalid browser name...!");
		}
		// driver.manage().window().maximize();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;

	}
	}


