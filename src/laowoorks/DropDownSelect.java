package laowoorks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {
	
	static WebDriver driver;
	
	public static void takeScreenShots() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String myDate = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileFormat = "Img"+myDate+".png";
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Selenium_Testing\\Screenshots\\"+fileFormat);
		FileUtils.copyFile(src, des);
	}

	public static void  delay() throws InterruptedException {

		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		String path = "\\Driver\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		//1. Select training program using Index
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select sel1 = new Select(drop1);
		sel1.selectByIndex(3);
		delay();

		//2. Select training program using Text
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select sel2 = new Select(drop2);
		sel2.selectByVisibleText("Selenium");
		delay();

		//3. Select training program using Value
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select sel3 = new Select(drop3);
		sel3.selectByValue("2");
		delay();

		//4. Get the number of drop down options
		WebElement drop4 = driver.findElement(By.className("dropdown"));
		Select sel4 = new Select(drop4);
		List<WebElement> opData = sel4.getOptions();
		int size = opData.size();
		System.out.println("Total drop down in Web element list:"+size);
		delay();

		//5. You can also use sendKeys to select
		WebElement drop5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		drop5.sendKeys("Selenium");
		delay();

		//6. Select your programs - multiple select
		WebElement drop6 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
		Select mBox = new Select(drop6);
		mBox.selectByIndex(1);
		mBox.selectByIndex(3);
		delay();
		
		delay();
		takeScreenShots();
		delay();
		//7. Select Apple and then Orange, get first selected Option
		driver.get("https://letcode.in/dropdowns");

		WebElement kdrop1 = driver.findElement(By.id("fruits"));
		Select sc1 = new Select(kdrop1);
		sc1.selectByVisibleText("Apple");
		delay();
		sc1.selectByVisibleText("Orange");
		WebElement firstSel = sc1.getFirstSelectedOption();
		System.out.println("First selected final: "+firstSel.getText());
		delay();
		//8. Multiple select
		WebElement kdrop2 = driver.findElement(By.id("superheros"));
		Select sc2 = new Select(kdrop2);
		boolean isMul = sc2.isMultiple();
		System.out.println("Multiple select or not: "+isMul);
		System.out.println("**********Multiple******************");
		System.out.println("List of values in a drop down");
		List<WebElement> op1 = sc2.getOptions();
		for(WebElement i:op1) {
			System.out.println(i.getText());
		}
		System.out.println("List of selected values in adrop down");
		sc2.selectByValue("bt");
		sc2.selectByValue("im");
		sc2.selectByValue("gr");
		List<WebElement> allSel1 = sc2.getAllSelectedOptions();
		for(WebElement i:allSel1) {
			System.out.println(i.getText());
		}
		delay();

		//9.Select last value in drop down
		WebElement kdrop3 = driver.findElement(By.id("lang"));
		Select sc3 = new Select(kdrop3);
		System.out.println("Print all options");
		List<WebElement> op2 = sc3.getOptions();
		for(WebElement i:op2) {
			System.out.println(i.getText());
		}
		int sizeK1 = op2.size();
		sc3.selectByIndex(sizeK1-1);
		delay();

		//10. Select by value and print it
		WebElement kdrop4 = driver.findElement(By.id("country"));
		Select sc4 = new Select(kdrop4);
		sc4.selectByVisibleText("India");
		WebElement firstSel1 = sc4.getFirstSelectedOption();
		System.out.println(firstSel1.getText());

		delay();

		sc2.deselectByValue("gr");
		System.out.println("After deselect:");
		List<WebElement> allSel5 = sc2.getAllSelectedOptions();
		for(WebElement i:allSel5) {
			System.out.println(i.getText());
		}

		takeScreenShots();
		delay();
		driver.close();
	}

}
