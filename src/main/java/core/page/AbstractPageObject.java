package core.page;

import core.config.ConfigurationManager;
import core.driver.DriverManager;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPageObject {
    public AbstractPageObject() {
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), ConfigurationManager.configuration().timeout()), this);
    }
}
