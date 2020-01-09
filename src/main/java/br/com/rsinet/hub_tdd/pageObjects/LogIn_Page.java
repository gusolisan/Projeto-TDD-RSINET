//package br.com.rsinet.hub_tdd.pageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class LogIn_Page   {
//	private static WebElement element = null;
//
//	public LogIn_Page(WebDriver driver) {
//		super(driver);
//	}
//
//	public static WebElement txtbx_UserName() throws Exception {
//		try {
//			element = driver.findElement(By.id("log"));
//		} catch (Exception e) {
//			throw (e);
//		}
//		return element;
//	}
//
//	public static WebElement txtbx_Password() throws Exception {
//		try {
//			element = driver.findElement(By.id("pwd"));
//		} catch (Exception e) {
//			throw (e);
//		}
//		return element;
//	}
//
//	public static WebElement btn_LogIn() throws Exception {
//		try {
//			element = driver.findElement(By.id("login"));
//		} catch (Exception e) {
//			throw (e);
//		}
//		return element;
//	}
//}
