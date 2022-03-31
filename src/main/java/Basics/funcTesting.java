package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class funcTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String[] name={"Cauliflower","Cucumber","Beetroot"};
        Thread.sleep(3000);
        addItems(driver,name);

        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        //explicit wait
        WebDriverWait w =new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(3000);

        Select dropdown=new Select(driver.findElement(By.xpath("//option[text()='Select']")));
        dropdown.selectByValue("United States");
        driver.findElement(By.className("chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();

    }

    public static void addItems(WebDriver driver, String[] name){
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
