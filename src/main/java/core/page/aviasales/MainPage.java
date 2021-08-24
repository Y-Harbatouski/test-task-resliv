

package core.page.aviasales;

import core.driver.DriverManager;
import core.enums.Passengers;
import core.page.AbstractPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends AbstractPageObject {
    private final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    @FindBy(id = "origin")
    private WebElement origin;

    @FindBy(id = "destination")
    private WebElement destination;
    //    @FindBy(css = ".--departure .trip-duration__date-input")
    @FindBy(css = ".--departure")
    private WebElement departureCalendar;

    @FindBy(css = ".--return")
    private WebElement returnCalendar;

    @FindBy(className = "calendar__months")
    private WebElement calendarBody;

    @FindBy(css = ".--avia.additional-fields")
    private WebElement addPassengersDropdown;

    @FindBy(css = "[data-testid='form-submit']")
    private WebElement findTicketsBtn;

    @FindBy(css = "div.page-header")
    private WebElement pageHeader;

    @FindBy(css = ".--increment")
    private List<WebElement> incrementPassengers;

    @FindBy(css = ".--decrement")
    private List<WebElement> decrementPassengers;


    @FindBy(css = ".calendar-caption__select")
    private WebElement calendarMonthDropdown;

    @FindBy(css = ".calendar-day__date")
    private List<WebElement> calendarDays;

    @FindBy(className = "of_input_checkbox__label")
    private WebElement bookingCheckbox;

    public MainPage() {
    }

    public MainPage addPassenger(Passengers passenger) {
        addPassengersDropdown.click();
        incrementPassengers.get(passenger.getValue()).click();
        addPassengersDropdown.click();
        return this;
    }

    public MainPage waitForPageToLoad() {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(this.origin, "value"));
        return this;
    }

    public MainPage fillOrigin(String origin) {
        String select = Keys.chord(Keys.CONTROL, "a");
        this.origin.sendKeys(select + origin + Keys.ENTER);
        return this;
    }

    public MainPage clickBookingCheckbox() {
        bookingCheckbox.click();
        return this;
    }

    public MainPage fillDestination(String destination) {
        this.destination.click();
        this.destination.sendKeys(destination + Keys.ENTER);
        return this;
    }

    public MainPage findTickets() {
        this.findTicketsBtn.click();
        return this;
    }

    public MainPage selectDate(String dateFrom, String dateTo) {
        departureCalendar.click();
        wait.until(ExpectedConditions.visibilityOf(calendarBody));
        selectDateUtil(dateFrom);
        selectDateUtil(dateTo);
        return this;
    }

    private void selectDateUtil(String date) {
        new Select(this.calendarMonthDropdown).selectByValue(date.substring(0, 7));
        String day = date.substring(8, 10).replaceAll("^0", "");
        String dateXpath = String.format("(//div[text()='%s'])[1]", day);
        try {
            DriverManager.getDriver().findElement(By.xpath(dateXpath)).click();
        } catch (StaleElementReferenceException ex) {
            DriverManager.getDriver().findElement(By.xpath(dateXpath)).click();
        }
    }
}
