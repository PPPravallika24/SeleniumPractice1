package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class flightTicket {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        List<WebElement> Options=driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']"));
        System.out.println(Options);
        for(int i=0;i<Options.size();i++){
            if(Options.contains("OneWay")){
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
                driver.findElement(By.xpath("//a[@text='Vijayawada (VGA)']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
                driver.findElement(By.xpath("(//a[@text='Jabalpur (JLR)'])[2]")).click();



            }
        }
        //driver.close();


    }
}
