package brpwserlaunnch;

import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateInDropDown {

	public static void main(String[] args) {

		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:\\Users\\ELCOT\\Desktop\\Selenium\\list.htm");
		
		WebElement drop1 = driver.findElement(By.id("automationtools"));
		Select se1 = new Select(drop1);
		List<WebElement> op1 = se1.getOptions();
		System.out.println("Original List:");
		for (WebElement web1 : op1) {
			System.out.println(web1.getText());
		}
		int size1 = op1.size();

		System.out.println("HashMap data:");
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		
		for(int i=0; i<size1; i++) {
			
			if(!(hMap.containsValue(op1.get(i).getText()))) {
				hMap.put(i, op1.get(i).getText());
			}
			else {
				System.out.println("Duplicate values: "+op1.get(i).getText());
			}
		}
		
		System.out.println("Size of list: "+op1.size());
		System.out.println("Size of hashMap: "+hMap.size());
		
		driver.close();
		
		/*System.out.println("Set data:");
		HashSet<String> s1 = new HashSet<String>();
		
		for(int i=0; i<op1.size(); i++) {
			
			s1.add(op1.get(i).getText());
		}
		
		System.out.println(s1.toString());
		
		*/
		
	}


}
