package pages.Contribuyente;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.BasePage;

public class AdministracionDeContribuyentes extends BasePage {

	private String Documento_box ="_CONTDOCTPO";
	private String Documento_num = "_CONDOC";
	private String Documento_ver = "_CONDIGVER";
	private String RazonSocial = "_CONRAZSOC";
	private String Denominacion = "_CONDEN";

	private By Button_NuevoContribuyente = By.id("NUEVOCONTRIBUYENTE");
	private By Button_Actualizar = By.id("K2BREFRESH");

	public AdministracionDeContribuyentes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Recibe un TIPO de dni y lo carga en el box de busqueda.
	 * 
	 * @param tipo
	 */
	public void UtilizarFiltroTIPO(String tipo) {
		FindWebElementBy_name(Documento_box).sendKeys(tipo);

	}

	public void UtilizarFiltroDOCUMENTO(String Documento) {
		FindWebElementBy_name(Documento_num).sendKeys(Documento);
	}

	public void UtilizarFiltroRAZONSOCIAL(String RazonSocial) {
		FindWebElementBy_name(this.RazonSocial).sendKeys(RazonSocial);

	}

	public void UtilizarFiltroDenominacion(String denominacion) {
		FindWebElementBy_name(Denominacion).sendKeys(denominacion);
	}

	public void getCeldas(String razonSocial) {
		
		WebElement table = FindWebElementBy_ID("GRID1");
		List<WebElement> tr = table.findElements(By.tagName("tr"));
		for (WebElement r : tr) { 
			List<WebElement> d = r.findElements(By.tagName("td"));
			for (WebElement f : d) {
				if (f.getText().equalsIgnoreCase(razonSocial)) {
					// System.out.println(f.getText());

				}
			}
		}
	}

	public AsociarUnContribuyente nuevo_contribuyente() {
		FindWebElementBy_ID("NUEVOCONTRIBUYENTE").click();
		return new AsociarUnContribuyente(driver);
	}

}//final
