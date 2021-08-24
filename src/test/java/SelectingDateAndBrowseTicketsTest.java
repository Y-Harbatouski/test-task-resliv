import core.enums.Passengers;
import core.page.aviasales.FoundResultsPage;
import core.page.aviasales.MainPage;
import core.testbase.BaseWeb;
import core.utility.Asserts;
import core.utility.TimeUtils;
import org.testng.annotations.Test;

public class SelectingDateAndBrowseTicketsTest extends BaseWeb {
    @Test(description = "Selecting tickets and checking the cost")
    public void selectTicketsAndCheckTheCosTest() {
        String departureDate = TimeUtils.addDaysToDateNow(1);
        String backDate = TimeUtils.addDaysToDateNow(2);

        new MainPage().
                waitForPageToLoad().
                fillOrigin("Москва").
                fillDestination("Санкт-Петербург").
                selectDate(departureDate, backDate).
                addPassenger(Passengers.CHILD).
                clickBookingCheckbox().
                findTickets();

        FoundResultsPage resultsPage = new FoundResultsPage();
        resultsPage.waitForLoadPage();

        Asserts.listElementTextsToBeEqualsString(resultsPage.getHomeCitiesTop(), "Москва");
        Asserts.listElementTextsToBeEqualsString(resultsPage.getEndpointCitiesTop(), "Санкт-Петербург");
        Asserts.listElementTextsToBeEqualsString(resultsPage.getHomeCitiesBottom(), "Москва");
        Asserts.listElementTextsToBeEqualsString(resultsPage.getEndpointCitiesBottom(), "Санкт-Петербург");
        Asserts.listElementTextsToBeContainsString(resultsPage.getFlyDateTop(), TimeUtils.convertToDateFormatResultsPage(departureDate));
        Asserts.listElementTextsToBeContainsString(resultsPage.getFlyDateBottom(), TimeUtils.convertToDateFormatResultsPage(backDate));
        Asserts.checkListElementTextsIsSortedAsc(resultsPage.getPriceButtons());
    }
}
