package pages.Contribuyente;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import page.BasePage;

public class AsociarUnContribuyente extends BasePage {

	private String Button_Asociar = "BTN_ENTER";
	private String Button_Cancelar = "BTN_CANCEL";
	private String RIF_documento = "_CONDOC";
	private String RIF_verificador = "_CONDIGVER";
	private String mensajeExitoBy = "HEADER_TRN3";

	public AsociarUnContribuyente(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private Select getSelect() {
		return new Select(driver.findElement(By.name("_DOCCOD")));
	}

	public void SelectVisible(String text) {
		getSelect().selectByVisibleText(text);
	}

	/**
	 * Recibe un Objeto Contribuyente y utiliza sus atributos para asociarlo.
	 * 
	 * @param nuevo_contribuyente
	 */
	public void Completar(Contribuyente nuevo_contribuyente) {
		SelectVisible(nuevo_contribuyente.getDoc_tipo());
		FindWebElementBy_name(RIF_documento).sendKeys(nuevo_contribuyente.getDoc_doc());
		FindWebElementBy_name(RIF_verificador).sendKeys(nuevo_contribuyente.getDoc_ver());
		FindWebElementBy_name(Button_Asociar).click();
		FindWebElementBy_name(Button_Asociar).click();
	}

	public void PorfavorVerificarLosDatos() {
		
		WebElement table = FindWebElementBy_ID("TABLE1");
		WebElement tr = table.findElement(By.tagName("tr"));
		WebElement td = tr.findElement(By.tagName("td"));
		String aviso = td.getText();
		if (td.isDisplayed()) {
			FindWebElementBy_name(Button_Asociar).click();
			System.out.println("Elemento porfavor encontrado");
		}

	}

}// final