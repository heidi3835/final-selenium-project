package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.hotels.HotelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class hotelScenario2 extends HotelHomePage {
    HotelHomePage hotelHomePage = new HotelHomePage();
    //BasePage basePage = new BasePage();
    JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();

    @Given("^I am on locations search result screen$")
    public void IamOnthelandingpage() throws InterruptedException {
        hotelHomePage.clearDestinationSearchField();
        Thread.sleep(2000);
        hotelHomePage.selectHotel("New York, New York, United States of America");
        Thread.sleep(2000);
        hotelHomePage.clickOnClose();
        Thread.sleep(2000);
        hotelHomePage.clickOnSearchButton();
        Thread.sleep(2000);
        hotelHomePage.setLandmarkIcon();

        jsScrollBy.executeScript("scrollBy(0,400);");
        Thread.sleep(2000);
        hotelHomePage.setClickOnJfkAirport();
        Thread.sleep(2000);
        hotelHomePage.getDistanceMiles();


    }
    @Then("^I verify system displays all hotels within (.+) miles radius of airport$")
    public void tenmilesaroundhotels(double mile) throws InterruptedException {


        while (true) {
            try {
                WebElement element = SharedSD.getDriver().findElement(By.xpath("//h3[contains(text(),'Want to see more hotels?')]"));
                ((JavascriptExecutor) SharedSD.getDriver()).executeScript(
                        "arguments[0].scrollIntoView();", element);
                break;
            } catch (Exception ex) {
                jsScrollBy.executeScript("scrollBy(0,7000);");
                Thread.sleep(2000);
            }
        }
        List<WebElement> miles = SharedSD.getDriver().findElements(By.xpath("//li[contains(text(),'miles to John F. Kennedy International Airport (JFK)')]"));
        List<WebElement> hotels= SharedSD.getDriver().findElements(By.className("property-name-link"));
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println(hotels.get(i).getText() + miles.get(i).getText());
        }

        }

    @And("^I verify Hilton Hotel is within (.+) radius$")
    public void verifyHiltonHotelIsWithinRadious(double miles) throws InterruptedException {
        List<WebElement> radius = SharedSD.getDriver().findElements(By.xpath("//li[contains(text(),'miles to John F. Kennedy International Airport (JFK)')]"));
        List<WebElement> allHotelsList = SharedSD.getDriver().findElements(By.className("property-name-link"));
        //  boolean isRadius = true;
        for (int i = 0; i < allHotelsList.size(); i++) {
            String radiusStr= radius.get(i).getText().substring(0,3);

            double milesDouble = Double.parseDouble(radiusStr);
            if ((allHotelsList.get(i).getText().contains("Hilton") && radiusStr.contains("John F. Kennedy International Airport")) && (milesDouble < miles)) {

                System.out.println("Hilton hotel is within 10 miles radius form JFK airport");
                break;
            }
        }
        }


    }
 // my comparisment is not working correctly 


