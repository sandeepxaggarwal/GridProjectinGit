package TestPackage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid_Multiple {

      static RemoteWebDriver driver;

      @BeforeTest
      @Parameters({"remoteurl"})
      public void beforetest(String remoteurl) throws IOException{
        DesiredCapabilities cap = null;
        FileInputStream fis = new FileInputStream(
                "C:\\WebDriverWorkspace\\GridProject\\src\\TestPackage\\Config.properties");

        Properties prop = new Properties();
        prop.load(fis);
        if (prop.getProperty("browser").equals("chrome")) {
            cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.ANY);
        } else if (prop.getProperty("browser").equals("firefox")) {
            cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.ANY);
        } else if (prop.getProperty("browser").equals("iexplore")) {
            cap = DesiredCapabilities.internetExplorer();
            cap.setBrowserName("iexplore");
            cap.setPlatform(Platform.WINDOWS);}
        driver = new RemoteWebDriver(new URL(remoteurl), cap);
        

        }

        @Test
        public void doLogin() throws InterruptedException{
        driver.get("http://newtours.demoaut.com");
        Thread.sleep(10000);
        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("login")).click();
        System.out.println(driver.getTitle());
        
       
       
        
    }
}