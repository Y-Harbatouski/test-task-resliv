package core.testbase;

import core.driver.DriverManager;
import core.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static core.config.ConfigurationManager.configuration;

@Listeners({TestListener.class})
public abstract class BaseWeb {

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(configuration().url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
