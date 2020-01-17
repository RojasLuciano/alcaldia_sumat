package pages.Autoliquidaciones;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import page.BasePage;

public class Autoliquidaciones extends BasePage{
	
	private String Button_Anterior = "ANTERIOR";
	private String Button_Siguiente ="SIGUIENTE";
	private String Button_Imprimir = "IMPRIMIR";
	private String Button_Finalizar = "FINALIZAR";
	private String IYC_AGREETERMS = "_AGREETERMS";
	
	
	public Autoliquidaciones(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void BuscarCuenta(String txt) {
		FindWebElementBy_name("_PADCOD").click();
		System.out.println(devolver_cadena_cuenta(txt));
		SelectVisible(devolver_cadena_cuenta(txt));	
	}
	
	/**
	 * Generar planilla de autoliquidacion para IYC
	 * @param cuenta
	 */
	public String  GenerarAutoliquidacion_IYC(String cuenta) {
		FindWebElementBy_ID("IYC").click();
		BuscarCuenta(cuenta);
		FindWebElementBy_name(Button_Siguiente).click();
		FindWebElementBy_name(Button_Finalizar).click();
		FindWebElementBy_name(IYC_AGREETERMS).click();
		FindWebElementBy_name(this.Button_Imprimir).click();
		return cuenta;	
	}
	
	

	/**
	 * Generar planilla de autoliquidacion para INM
	 * @param cuenta
	 */
	public String  GenerarAutoliquidacion_INM(String cuenta) {
		FindWebElementBy_ID("INM").click();
		BuscarCuenta(cuenta);
		FindWebElementBy_name(Button_Siguiente).click();
		FindWebElementBy_name(Button_Siguiente).click();
		FindWebElementBy_name(Button_Siguiente).click();
		
		FindWebElementBy_name(this.Button_Imprimir).click();
		return cuenta;
		
	}

	/**
	 * Generar planilla de autoliquidacion para INM
	 * @param cuenta
	 */  
	public String  GenerarAutoliquidacion_JAL(String cuenta) {
		FindWebElementBy_ID("JAL").click();
		BuscarCuenta(cuenta);
		FindWebElementBy_name(Button_Siguiente).click();
		FindWebElementBy_name(Button_Siguiente).click();
		FindWebElementBy_name(Button_Siguiente).click();
		
		FindWebElementBy_name(this.Button_Imprimir).click();
		return cuenta;
		
	}

	
	
	private Select getSelect() {		
		return new Select(driver.findElement(By.name("_PADCOD")));
	}
	
	private void SelectVisible(String text) {
		getSelect().selectByVisibleText(text);
	}
	/**
	 * 	Recibe por parametro una string con la cuenta a buscar
	 * @param cuenta
	 * @return la cuenta completa.
	 * y realiza un scroll hasta la misma.
	 */
	private String devolver_cadena_cuenta(String cuenta) {
		String cadena_completa=null;
		WebElement test = FindWebElementBy_name("_PADCOD");
		List<WebElement> li = test.findElements(By.tagName("option"));
		for(WebElement e : li) {
			if(e.getText().contains(cuenta)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
				cadena_completa = e.getText();
			}
		}
		
		return cadena_completa;
	}
	


	
}//final
