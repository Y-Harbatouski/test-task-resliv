package core.page.aviasales;

import core.driver.DriverManager;
import core.page.AbstractPageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class FoundResultsPage extends AbstractPageObject {
    private static Logger log = LoggerFactory.getLogger("Found results page logger");
    private final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40));

    @FindBy(css = "[data-testid='ticket-desktop-segment-forth'] [data-testid='origin-endpoint'] [data-testid='city']")
    private List<WebElement> homeCitiesTop;

    @FindBy(css = "[data-testid='ticket-desktop-segment-forth'] [data-testid='destination-endpoint'] [data-testid='city']")
    private List<WebElement> endpointCitiesTop;

    @FindBy(css = "[data-testid='ticket-desktop-segment-back'] [data-testid='origin-endpoint'] [data-testid='city']")
    private List<WebElement> endpointCitiesBottom;

    @FindBy(css = "[data-testid='ticket-desktop-segment-back'] [data-testid='destination-endpoint'] [data-testid='city']")
    private List<WebElement> homeCitiesBottom;

    @FindBy(xpath = "//a[@data-test-element='button' and not (contains (@class,'--with-brand-color'))]//*[@data-test-element='price']")
    private List<WebElement> priceButtons;

    @FindBy(className = ".prediction__header")
    private WebElement loadingSection;

    @FindBy(css = ".loader__stripes.--animation-started.--blue")
    private WebElement loadingBar;

    @FindBy(css = "[data-testid='ticket-desktop-segment-forth'] .segment-route__date")
    private List<WebElement> flyDateTop;

    @FindBy(css = "[data-testid='ticket-desktop-segment-back'] .segment-route__date")
    private List<WebElement> flyDateBottom;

    public FoundResultsPage() {
    }

    public void waitForLoadPage() {
        log.info("waiting for the page to load...");
        wait.pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.invisibilityOf(loadingSection));
        wait.pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.invisibilityOf(loadingBar));
        log.info("page loaded");
    }

    public List<WebElement> getHomeCitiesTop() {
        return homeCitiesTop;
    }

    public List<WebElement> getEndpointCitiesTop() {
        return endpointCitiesTop;
    }

    public List<WebElement> getEndpointCitiesBottom() {
        return endpointCitiesBottom;
    }

    public List<WebElement> getHomeCitiesBottom() {
        return homeCitiesBottom;
    }

    public List<WebElement> getPriceButtons() {
        return priceButtons;
    }

    public List<WebElement> getFlyDateTop() {
        return flyDateTop;
    }

    public List<WebElement> getFlyDateBottom() {
        return flyDateBottom;
    }
}
