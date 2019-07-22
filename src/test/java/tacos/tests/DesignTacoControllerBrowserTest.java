package tacos.tests;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DesignTacoControllerBrowserTest {
//	@Test
//    public  void testmain() 
//    {
//		//add chromedriver exe to main folder, not to build path
//		// add dependency to pom
//		// system.set property
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\namag\\eclipse-workspace\\taco-cloud_jpa\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://google.com");
//    } 

  
  private static ChromeDriver browser;
  
  @LocalServerPort
  private int port;
  
  @Autowired
  TestRestTemplate rest;
  
  @BeforeClass
  public static void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\namag\\eclipse-workspace\\taco-cloud_jpa\\chromedriver.exe");
    browser = new ChromeDriver();
    browser.manage().timeouts()
        .implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @AfterClass
  public static void closeBrowser() {
    browser.quit();
  }
  
  @Test
  @Ignore("TODO: Need to get around authentication in this test")
  public void testDesignATacoPage() throws Exception {
    browser.get("http:localhost:" + port + "/design");

    List<WebElement> ingredientGroups = browser.findElementsByClassName("ingredient-group");
    assertEquals(5, ingredientGroups.size());
    
    WebElement wrapGroup = ingredientGroups.get(0);
    List<WebElement> wraps = wrapGroup.findElements(By.tagName("div"));
    assertEquals(2, wraps.size());
    assertIngredient(wrapGroup, 0, "FLTO", "Flour Tortilla");
    assertIngredient(wrapGroup, 1, "COTO", "Corn Tortilla");
    
    WebElement proteinGroup = ingredientGroups.get(1);
    List<WebElement> proteins = proteinGroup.findElements(By.tagName("div"));
    assertEquals(2, proteins.size());
    assertIngredient(proteinGroup, 0, "GRBF", "Ground Beef");
    assertIngredient(proteinGroup, 1, "CARN", "Carnitas");
  }
  
  private void assertIngredient(WebElement ingredientGroup, 
                                int ingredientIdx, String id, String name) {
    List<WebElement> proteins = ingredientGroup.findElements(By.tagName("div"));
    WebElement ingredient = proteins.get(ingredientIdx);
    assertEquals(id, 
        ingredient.findElement(By.tagName("input")).getAttribute("value"));
    assertEquals(name, 
        ingredient.findElement(By.tagName("span")).getText());
  }
  
}