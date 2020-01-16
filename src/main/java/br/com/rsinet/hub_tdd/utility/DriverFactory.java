package br.com.rsinet.hub_tdd.utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;
	private static Logger log = Logger.getLogger("DriverFactory");

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			DOMConfigurator.configure("log4j.xml");

			driver = new ChromeDriver();
			log.info("Inicializado o driver do navegador Google Chrome");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("Inicializado comando de espera ImplicityWait");

			driver.manage().window().maximize();
			log.info("Navegador maximizado");

			driver.get(Constant.url);
			log.info("Navegador inicializado com o site https://www.advantageonlineshopping.com/#/");
			return driver;
		} else {
			return driver;
		}
	}

	public static void quitDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}
}
