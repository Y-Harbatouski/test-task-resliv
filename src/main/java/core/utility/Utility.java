package core.utility;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class Utility {

    static String retryingFindText(WebElement element) {
        String result = null;
        int attempts = 0;
        while (attempts < 3) {
            try {
                result = element.getText();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        return result;
    }
}
