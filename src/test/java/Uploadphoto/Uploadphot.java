package Uploadphoto;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
	
public class Uploadphot {
	protected static String url="https://www.filemail.com/share/upload-file";
	WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException {
	
	  WebElement title=driver.findElement(By.id("FilemailSubjectURL"));
	  title.sendKeys("AutoIt title");
	  WebElement message=driver.findElement(By.id("FilemailMessageToURL"));
	  message.sendKeys("AutoIt message box");
	  
	  WebElement add=driver.findElement(By.id("addBtn"));
	  add.click();
	  Thread.sleep(2000);
	  String path="\"C:\\AutoIT_file\\fileupload.exe\"";
	  Thread.sleep(2000);
	  ProcessBuilder builder=new ProcessBuilder(path);
	  builder.start();
	  WebElement send=driver.findElement(By.id("sendBtn"));
	  send.click();
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
