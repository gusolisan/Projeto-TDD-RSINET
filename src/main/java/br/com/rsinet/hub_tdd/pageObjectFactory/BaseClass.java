package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static boolean bResult;

	public BaseClass(WebDriver driver) {
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}
}
