package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pages.Autoliquidaciones.Autoliquidaciones;
import pages.Contribuyente.AdministracionDeContribuyentes;

public class Home extends BasePage {

	public Home(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Generar una Liquidación de Tasa")
	private By generarUnaLiquidacionDeTasa;
	private By pruebaIssue = By.name("ENTENDIDO");

	
	public AdministracionDeContribuyentes administracionDeContribuyentes(String txt) {
		if (lista_de_opciones(txt)) {
			return new AdministracionDeContribuyentes(driver);
		}
		return null;
	}
	
	public Autoliquidaciones autoliquidaciones(String txt) {
		if (lista_de_opciones(txt)) {
			return new Autoliquidaciones(driver);
		}
		return null;
	}
	 
	private void moverHasta(WebElement we) {
		Actions firstAction = new Actions(driver);
		waitElement(we);

		firstAction.moveToElement(we).perform();
	}

	private boolean lista_de_opciones(String txt) {
		WebElement div = FindWebElementBy_className("ddsmoothmenu");
		List<WebElement> li = div.findElements(By.tagName("li"));
		for (WebElement e : li) {
			List<WebElement> a = driver.findElements(By.tagName("a"));
			for (WebElement b : a) {
				moverHasta(b);
				if (b.getText().equalsIgnoreCase(txt)) {
					b.click();
					return true;
				}
			}
		} 
		return false;
	}
	
	
}// final
