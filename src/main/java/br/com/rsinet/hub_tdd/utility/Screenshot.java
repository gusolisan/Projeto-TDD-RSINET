package br.com.rsinet.hub_tdd.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void printScreen(String nomeDoArquivoImagem, WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C:\\Users\\g.santos\\eclipse-workspace\\ProjetoTDD\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\screenshotsDosTestes\\Cenario de Cadastro\\";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".jpg"));
	}
}