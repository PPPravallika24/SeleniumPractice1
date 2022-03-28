package Basics;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BasicSelprogram {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-2");
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String name="Rahul";
        String title=driver.getTitle();
        Assert.assertEquals(title,"Rahul Shetty Academy - Login page");
        driver.findElement(By.xpath("//form/input[@placeholder='Username']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("rahulshetty");
        driver.findElement(By.xpath("//form/button[@class='submit signInBtn']")).click();
        Thread.sleep(2000);
        String msg=driver.findElement(By.xpath("//form/p")).getText();
        if(msg.equals("* Incorrect username or password")) {
            driver.findElement(By.linkText("Forgot your password?")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("John");
            driver.findElement(By.xpath("//form/input[@placeholder='Email']")).sendKeys("John@gmail.com");
            driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("9876543210");
            driver.findElement(By.xpath("//form/div/button[2]")).click();
            String text=getPassword(driver);
            driver.findElement(By.className("go-to-login-btn")).click();
            Thread.sleep(2000);
            /*if (text.equals("Please use temporary password 'rahulshettyacademy' to Login.")){
                driver.findElement(By.className("go-to-login-btn")).click();
                Thread.sleep(2000);
            }*/
            driver.findElement(By.xpath("//form/input[@placeholder='Username']")).sendKeys("Rahul");
            driver.findElement(By.cssSelector("input[type='password']")).sendKeys(text);
            driver.findElement(By.className("submit")).click();
            Assert.assertEquals("Hello"+name, "HelloRahul");
        }


    }
    public static String getPassword(WebDriver driver){
        String text=driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText();
        String password=text.split("'")[1].split("'")[0];
        System.out.println(password);
        return password;

    }



}
