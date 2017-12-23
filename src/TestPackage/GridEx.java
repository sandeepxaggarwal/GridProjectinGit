package TestPackage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridEx {

    public static void main(String[] args) throws IOException {
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
            cap.setPlatform(Platform.WINDOWS);

        }
        
        RemoteWebDriver driver = new RemoteWebDriver(new URL(
                "http://localhost:5555/wd/hub"), cap);
        driver.get("http://newtours.demoaut.com");

        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("login")).click();
        System.out.println(driver.getTitle());
        driver.close();
    }
}