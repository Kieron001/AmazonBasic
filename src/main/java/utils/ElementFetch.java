package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue)
    {
        switch (identifierType){

            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;

        }
    }

    public List<WebElement> getListOfWebElements(String identifierType, String identifierValue)
    {
        switch (identifierType){

            case "ID":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "NAME":
                return BaseTest.driver.findElements(By.name(identifierValue));
            case "CLASSNAME":
                return BaseTest.driver.findElements(By.className(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(identifierValue));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(identifierValue));
            default:
                return null;

        }
    }
}
