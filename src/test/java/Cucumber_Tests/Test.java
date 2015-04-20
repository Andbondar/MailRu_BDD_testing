package Cucumber_Tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by bondar on 4/20/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue = {"Cucumber_Tests"},
        format = {"pretty", "html:target/cucumberHTMLReport"},
        tags = { "@Test" }
)
public class Test extends PageInstance{
    @BeforeClass
    public static void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @After
    public static void tearDownAfterEach(){
        driver.close();
    }
}
