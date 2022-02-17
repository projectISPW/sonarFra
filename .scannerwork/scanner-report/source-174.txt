package seleniumtest.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

 class TestBinaryConverter {
    public void  testBinary(String binary,Integer input) {
        String local;
        System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.rapidtables.com/convert/number/decimal-to-binary.html");
        driver.findElement(By.xpath("//*[@id=\"x\"]")).sendKeys(""+input);
        driver.findElement(By.xpath("//*[@id=\"calcform\"]/div[3]/button[1]")).click();
        local=driver.findElement(By.xpath("//*[@id=\"y\"]")).getAttribute("value");
        assertEquals(binary,local);
    }
    @Test
    void testBinary(){
        Integer input=555;
        String binary=Integer.toBinaryString(input);
        testBinary(binary,input);
    }
}
