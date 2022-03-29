package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class flightTicket {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        List<WebElement> Options=driver.findElements(By.cssSelector("#travelOptions"));
        for(int i=0;i<Options.size();i++){
            String radio=Options.get(i).getText();
            System.out.println(radio);
            if(radio.contains("One Way")){
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
                driver.findElement(By.xpath("//a[@text='Vijayawada (VGA)']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
                driver.findElement(By.xpath("(//a[@text='Jabalpur (JLR)'])[2]")).click();
                driver.findElement(By.id("divpaxinfo")).click();
                int j=1;
                while(j<4){
                    driver.findElement(By.id("hrefIncAdt")).click();
                }
                Select dropdown=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
                dropdown.selectByValue("AED");
            }
            else{

            }
        }
        driver.close();


    }
}
