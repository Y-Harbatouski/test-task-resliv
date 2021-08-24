package core.utility;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Asserts {
    private static Logger log = LoggerFactory.getLogger("Assert logger");

    public static void listElementTextsToBeEqualsString(List<WebElement> elementList, String text) {
        for (WebElement element : elementList) {
            log.info(String.format("Checking that the element equals text [%s]", text));
            try {
                Assert.assertEquals(element.getText(), text);
            } catch (StaleElementReferenceException ex) {
                Assert.assertEquals(element.getText(), text);
            }
        }
    }

    public static void listElementTextsToBeContainsString(List<WebElement> elementList, String text) {
        for (WebElement element : elementList) {
            log.info(String.format("Checking that the element contains text [%s]", text));
            try {
                Assert.assertTrue(element.getText().contains(text));
            } catch (StaleElementReferenceException ex) {
                Assert.assertTrue(element.getText().contains(text) );
            }
        }
    }

    public static void checkListElementTextsIsSortedAsc(List<WebElement> elementList) {
        List<String> fromWeb = new ArrayList<>();
        List<String> sorted = new ArrayList<>();

        for (WebElement element : elementList) {
            fromWeb.add(Utility.retryingFindText(element));
        }
        sorted.addAll(fromWeb);
        sorted.sort(Comparator.comparingInt(o -> Integer.parseInt(o.replaceAll("[^\\d ]", ""))));

        for (int i = 0; i < fromWeb.size(); i++) {
            log.info(String.format("checking equals: from web: [%s] - sorted: [%s]", fromWeb.get(i), sorted.get(i)));
            Assert.assertEquals(fromWeb.get(i), sorted.get(i));
        }
    }
}
