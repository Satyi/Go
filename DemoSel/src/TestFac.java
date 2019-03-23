
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFac {
	
	public static void main(String[]args) throws IOException{
				WebDriver driver;
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				driver = new ChromeDriver();
					driver.get("http://localhost:9000");
					driver.manage().window().maximize();
					// Sonar Test Automation
				WebDriverWait wait=new WebDriverWait(driver,1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[1]/a")));
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[1]/a")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a")));
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[1]/a")));
	WebElement el=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[1]/a"));
	driver.close();
					// Web Services Automation
				/*	WebDriverWait wait=new WebDriverWait(driver,1000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/form[1]/div/table/tbody/tr[1]/th[1]/h4/a")));
					driver.findElement(By.xpath("/html/body/div[1]/div/form[1]/div/table/tbody/tr[1]/th[1]/h4/a")).click();
					driver.switchTo().alert().accept();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/form[1]/div/table/tbody/tr[1]/th[2]/button")));
			driver.findElement(By.xpath("/html/body/div[1]/div/form[1]/div/table/tbody/tr[1]/th[2]/button")).click();
			driver.navigate().back();*/
	//FileInputStream fis = new FileInputStream("F:/project/sonar.xlsx");
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.getSheetAt(0);
	Row row = sheet.getRow(0);
	Cell cell = row.createCell(0);
	cell.setCellValue("Code Smells");
	cell.setCellValue(el.getText());
	FileOutputStream fos = new FileOutputStream("F:/project/sonar.xlsx");
	workbook.write(fos);
	fos.close();
}
}