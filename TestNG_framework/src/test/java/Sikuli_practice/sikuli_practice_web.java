package Sikuli_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sikuli_practice_web {

	
	
	public static void main(String args[]) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		Screen scr = new Screen();
		//file:///C:/Users/siddu/git/repository8/TestNG_framework/Sikuli_images/email_address_image.png
		Pattern emailadd = new Pattern("C:\\Users\\siddu\\git\\repository8\\TestNG_framework\\Sikuli_images\\email_address_image.png");
		
		scr.wait(5);
		
		scr.type(emailadd,"Sidduprecious2014@gmail.com");
		
		
		
	}
}
