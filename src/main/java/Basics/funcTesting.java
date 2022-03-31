package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class funcTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] name={"Cauliflower","Cucumber","Beetroot"};
        Thread.sleep(3000);

        int j=0;
        List<WebElement> products=driver.findElements(By.xpath("//h4[@class='product-name']"));
        for(int i=0;i<products.size();i++){

            String[] proName=products.get(i).getText().split("-");
            String froName=proName[0].trim();
            List itemsNeededList = Arrays.asList(name);
            if(itemsNeededList.contains(froName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
            }
            if(j==name.length){
                break;
            }
        }


    }
}
