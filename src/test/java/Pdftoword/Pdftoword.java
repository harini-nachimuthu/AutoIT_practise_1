package Pdftoword;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pdftoword {
	protected static String url="https://www.ilovepdf.com/pdf_to_word";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
			  WebElement selectfiles=driver.findElement(By.id("pickfiles"));
			  selectfiles.click();
			  
			  Thread.sleep(2000);
			  
			  String path="\"C:\\AutoIT_file\\pdftoword.exe\"";
			  ProcessBuilder builder=new ProcessBuilder(path);
			  builder.start();
			  
			  Thread.sleep(2000);
			  
			  WebElement convertword=driver.findElement(By.id("processTaskTextBtn"));
			  convertword.click();
			  
			  WebElement final1=driver.findElement(By.xpath("//h1[.='Your PDF has been converted to an editable WORD document']"));
			  String value=final1.getText();
			  if(value.equals("Your PDF has been converted to an editable WORD document")) {
				  System.out.println("Yes pdf converted to document...");
			  }else {
				  System.out.println("No pdf not converted to document...");
			  }
			  
			  Thread.sleep(2000);
			  
			  WebElement download=driver.findElement(By.id("pickfiles"));
			  download.click();
			  
			  Thread.sleep(2000);
			  
			  String path1="\"C:\\AutoIT_file\\downloadword.exe\"";
			  ProcessBuilder builder1=new ProcessBuilder(path1);
			  builder1.start();
			  
			  Thread.sleep(2000);
  }
  @BeforeSuite
  public void beforeSuite() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @BeforeClass
  public void classess() {
	  driver.get(url);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }

}
