package br.com.rsinet.hub_tdd.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void printScreen(WebDriver driver, String nomeDoArquivoImagem, String caminhoDeArmazenamento) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = caminhoDeArmazenamento;
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".png"));
	}
}