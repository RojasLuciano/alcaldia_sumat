package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pages.Contribuyente.AdministracionDeContribuyentes;

public class Login extends BasePage {

	private String campoID = "_DOCUMENTO";
	private String campoPASSWORD = "_USERPASSWORD";
	private String botonINGRESAR = "LOGIN2";
	private String url = "http://simattemp.ex-cle.com/simat_web_test/servlet/hlogin";
	private String FailedLogin = "span[text()='El Usuario se encuentra bloqueado.']";
	String opcion_del_menu;

	public Login(WebDriver driver) {
		super(driver);
	}

	public void goSumatHome() {
		driver.get(url);
	}

	public void completeUserName(String name) {
		FindWebElementBy_name(campoID).sendKeys(name);
	}

	public void completePassword(String password) {
	FindWebElementBy_name(password).sendKeys(password);
	}

	public Home login_returnHome() {
		FindWebElementBy_name(botonINGRESAR).click();
		return new Home(driver);
	}

	public String getActualURL() {
		return driver.getCurrentUrl();
	}

	public String get_failedLogin() {
		FindWebElementBy_name(FailedLogin);
		return "true";
	}




}
