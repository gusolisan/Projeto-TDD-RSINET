package br.com.rsinet.hub_tdd.utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver = null;
	private static Logger log = Logger.getLogger("DriverFactory");

	public static WebDriver driverInit() {
		if (driver == null) {
			driver = new ChromeDriver();
			log.info("Driver criado");

			driver.get(Constant.url);
			log.info("Navegador inicializado com o site https://www.advantageonlineshopping.com/#/");

			driver.manage().window().maximize();
			log.info("Navegador maximizado");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.info("Comando de espera ImplicityWait inicializado");
		}
		return driver;
	}

	public static void driverQuit() {
		if (driver != null) {
			driver.quit();
			log.info("Driver encerrado");
		}
		driver = null;
	}
}
