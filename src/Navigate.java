import org.junit.Test;
import Rules.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Navigate extends AbstractBase
{
    @Test
    @Retry
    public void NavigateToDownload() throws Exception
    {


        //Go to Code 42
        myDriver.get(myBaseURL);
        //Go to Nav Menu
        myDriver.findElement(By.id("headerToggleNav")).click();
        //Go to Products
        Assert.assertTrue(myDriver.findElement(By.linkText("Products")).getText().equals("Products"));
        myDriver.findElement(By.linkText("Products")).click();
        //Go to Button
        myDriver.findElement(By.xpath("//div[@class='product-module product-crashplan']/div[@class='product-content']/a[@class='btn-outlined'][1]")).click();
        //Go to Free
        myDriver.findElement(By.xpath("//li[@class='feature-banner-setting set-to-live c42-carousel-slide']/div[@class='feature-banner-content']/a[@class='btn btn-con']")).click();
        //Click download
        myDriver.findElement(By.linkText("Download")).click();
        //Click download
        myDriver.findElement(By.linkText("Download CrashPlan")).click();
        Thread.sleep(5000);
        myScreen.click(SaveButton); // click fire fox save
        Thread.sleep(25000);
        System.out.println("Installation with Sikuli is not behaving under Sikuli 1.0.2 Please Install CrashPlan or Logout for next test");

    }
}
