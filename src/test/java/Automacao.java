import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.dnd.DropTarget;
import java.time.Duration;

public class Automacao extends TestBase {

// Cenario 1
  @Test
  public void RegisterTest(){
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Joao", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Carlos", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Rua Matias Ferreira 310 Centro", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).click();
    Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    Driver.driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("JoaoCarlos@outlook.com", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("54192192341", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]")).click();
    Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    Driver.driver.findElement(By.xpath("//*[@id=\"checkbox1\"]")).click();
    Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    // select language bugging
    Driver.driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
    Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();

    Driver.driver.findElement(By.xpath("//*[@id=\"section\"]/div/h2")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"Skills\"]")).click();
    Select skill = new Select(Driver.driver.findElement(By.xpath("//*[@id=\"Skills\"]")));
    skill.selectByVisibleText("C");


    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
    Driver.driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Japan", Keys.ENTER);


    Driver.driver.findElement(By.xpath("//*[@id=\"yearbox\"]")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"yearbox\"]")).click();
    Select year = new Select(Driver.driver.findElement(By.xpath("//*[@id=\"yearbox\"]")));
    year.selectByValue("1997");

    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();
    Select month = new Select(Driver.driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
    month.selectByValue("June");

    Driver.driver.findElement(By.xpath("//*[@id=\"daybox\"]")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"daybox\"]")).click();
    Select day = new Select(Driver.driver.findElement(By.xpath("//*[@id=\"daybox\"]")));
    day.selectByValue("10");

    Driver.driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"firstpassword\"]")).sendKeys("12345", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("12345", Keys.ENTER);

    Driver.driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();





  }
  // Cenario 2
  @Test
  public void FrameTest(){
    Driver.driver.get("https://demo.automationtesting.in/Frames.html");
    Driver.driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[3]/a")).click();
    Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    Driver.driver.switchTo().frame(0);
    Driver.driver.findElement(By.tagName("input")).sendKeys("test");
  }
// Cenario 3
  @Test
  public void DataPickTest(){

    Driver.driver.get("https://demo.automationtesting.in/Datepicker.html");
    Driver.driver.findElement(By.xpath("//*[@id=\"datepicker1\"]")).click();
    new WebDriverWait(Driver.driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.className("ui-datepicker-calendar"))));
    String monthYearValue = Driver.driver.findElement(By.className("ui-datepicker-title")).getText();
    String month = monthYearValue.split(" ")[0].trim();
    String year = monthYearValue.split(" ")[1].trim();
    while (!(month.equals("August") && year.equals("1997"))){
      Driver.driver.findElement(By.xpath("//a[@title='Prev']")).click();
      monthYearValue = Driver.driver.findElement(By.className("ui-datepicker-title")).getText();
      month = monthYearValue.split(" ")[0].trim();
      year = monthYearValue.split(" ")[1].trim();

    }
    Driver.driver.findElement(By.xpath("//a[text()='13']")).click();

    Driver.driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).click();
    Driver.driver.findElement(By.xpath("//*[@id=\"datepicker2\"]")).sendKeys("08/13/1997", Keys.ENTER);


  }
// Cenario 4
  @Test
  public void SliderTest(){
    Driver.driver.get("https://demo.automationtesting.in/Slider.html");
    WebElement element = Driver.driver.findElement(By.xpath("//*[@id=\"slider\"]/a"));
    Actions action = new Actions(Driver.driver);
    action.dragAndDropBy(element,197,185).perform();
    WebElement slider = Driver.driver.findElement(By.xpath("//*[@id=\"slider\"]/a"));
    String alignment = slider.getCssValue("left");
    alignment.equals("50%");
  }

}
