package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import test.java.BaseTest;

public class HomePage {

    //@Test
    public void clickSignInButton()
    {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Clicking on SignIn button");
        elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
    }
}
