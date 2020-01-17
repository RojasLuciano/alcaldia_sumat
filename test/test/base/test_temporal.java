package test.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.DB_SUMAT;
import page.Home;
import page.Login;
import pages.Autoliquidaciones.Autoliquidaciones;
import pages.Contribuyente.AdministracionDeContribuyentes;
import pages.Contribuyente.AsociarUnContribuyente;

public class test_temporal extends BaseTest{
	//v25693931 simat123
	
	
	 /**
	  * Generar autoliquidacion_IYC
	  */
	@Test(enabled=false)
	public void autoliquidacion_IYC(){
		DB_SUMAT DB = new DB_SUMAT();
		DB.connect();
		Login login = new Login(driver);
		login.goSumatHome();
		login.completeUserName("v25693931"); 
		login.completePassword("simat123");
		Home home = login.login_returnHome(); 
		Autoliquidaciones adc = home.autoliquidaciones("Generar planilla de autoliquidación");		
		DB.eliminarplanilla(adc.GenerarAutoliquidacion_IYC("930802"));
		
		
	
	}
		
	 
	 /**
	  * Generar autoliquidacion_JAL
	  */
	@Test(enabled=true)
	public void autoliquidacion_JAL(){ 
		
		DB_SUMAT DB = new DB_SUMAT();
		DB.connect();
		Login login = new Login(driver);
		login.goSumatHome();
		login.completeUserName("v25693931"); 
		login.completePassword("simat123");
		Home home = login.login_returnHome(); 
		Autoliquidaciones adc = home.autoliquidaciones("Generar planilla de autoliquidación");		
		DB.eliminarplanilla(adc.GenerarAutoliquidacion_JAL("000024"));
		
		
	
	}
	@Test
	public void testdb() {
		DB_SUMAT DB = new DB_SUMAT();
		DB.connect();
		DB.eliminarplanilla("930802");
	}
	
	
	
	
	
	
	 /**
	  * Generar autoliquidacion_INM
	  */
	@Test(enabled=false)
	public void autoliquidacion_INM(){
		DB_SUMAT DB = new DB_SUMAT();
		Login login = new Login(driver);
		login.goSumatHome();
		login.completeUserName("v25693931"); 
		login.completePassword("simat123");
		Home home = login.login_returnHome(); 
		Autoliquidaciones adc = home.autoliquidaciones("Generar planilla de autoliquidación");	
		DB.connect();
		DB.eliminarplanilla(adc.GenerarAutoliquidacion_INM("801177"));
		
		
	
	}
	

	
	
@Test(enabled=false)
public void temporal1() {
	Login login = new Login(driver);
	login.goSumatHome();
	login.completeUserName("v37933047");
	login.completePassword("excle2020");
	Home home = login.login_returnHome();
	AdministracionDeContribuyentes adc = home.administracionDeContribuyentes("Administración de Contribuyentes");
	AsociarUnContribuyente ac =  adc.nuevo_contribuyente();
	DB_SUMAT db = new DB_SUMAT();
	db.connect();
	ac.Completar(db.GenerarUsuariosNoAsociados());

	ac.PorfavorVerificarLosDatos();
	
 } 

 


 









}
