import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {
    public static WebDriver driver;
    @Before
    public static void initDriver(){
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://demo.automationtesting.in/Slider.html");
        }
    }
    public static void quiDriver(){

    }


}
