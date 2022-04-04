package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EndtoEnd {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        ArrayList<String> creds= (ArrayList<String>) cred(driver);
        driver.findElement(By.name("username")).sendKeys(creds.get(0));
        driver.findElement(By.name("password")).sendKeys(creds.get(1));
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        WebDriverWait w=new WebDriverWait(driver,2);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement Options=driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown= new Select(Options);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();

        WebDriverWait w1=new WebDriverWait(driver,10);
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInBtn")));
        driver.findElement(By.id("signInBtn")).click();
        List<WebElement> prods=driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i=0;i< prods.size();i++){
            prods.get(i).click();
        }

        driver.findElement(By.partialLinkText("Checkout")).click();
        

    }
    public static List<String> cred(WebDriver driver){
        List<WebElement> text=driver.findElements(By.tagName("i"));
        ArrayList<String> name=new ArrayList<String>(2);
        for(int i=0;i< text.size();i++){
            name.add(text.get(i).getText());
            System.out.println(text.get(i).getText());

        }
        return name;
        
        
        
    }
}
