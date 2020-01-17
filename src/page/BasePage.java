package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	// Todos los que hereden se llevan este
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public void waitElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/**
	 * Espera a que se cargue la pagina, la visibilidad del elemento y regresa el
	 * mismo en forma de WebElement
	 * 
	 * @param txt
	 * @return
	 */
	public WebElement FindWebElementBy_ID(String txt) {
		WebElement new_web_element = null;
		try {
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;

	}

	public WebElement FindWebElementBy_className(String txt) {
		WebElement new_web_element = null;
		try {
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;

	}

	public WebElement FindWebElementBy_name(String txt) {
		WebElement new_web_element = null;
		try {
			wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			new_web_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(txt)));
			wait.until(ExpectedConditions.visibilityOf(new_web_element));

		} catch (Exception e) {
		}
		return new_web_element;
	} 
 

}