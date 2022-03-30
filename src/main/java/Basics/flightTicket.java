package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;


public class flightTicket {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> country=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        System.out.println(country);
        for(WebElement count:country){
            if(count.getText().equalsIgnoreCase("India")){
                count.click();
                break;
            }
        }


        List<WebElement> Options=driver.findElements(By.cssSelector("#travelOptions"));
        for(int i=0;i<Options.size();i++){
            String radio=Options.get(i).getText();
            System.out.println(radio);
            if(radio.contains("One Way")){
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
                driver.findElement(By.xpath("//a[@text='Vijayawada (VGA)']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
                driver.findElement(By.xpath("(//a[@text='Jabalpur (JLR)'])[2]")).click();
                driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
                driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
                Thread.sleep(3000);
                int j=1;
                while(j<4){
                    driver.findElement(By.id("hrefIncAdt")).click();
                    j++;
                }
                Select dropdown=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
                dropdown.selectByValue("AED");
            }
            else{

            }



        }
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Puppy");
        driver.findElement(By.id("alertbtn")).click();
        String text=driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        //driver.close();


    }
}
