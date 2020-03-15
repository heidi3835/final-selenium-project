package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyHomePage;
import framework.webPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Scenario2SD extends DarkSkyHomePage {
    private HomePage homePage = new HomePage();
    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on Darksky home page$")
    public void IAmOnDarkSkyHomePage() throws InterruptedException {
        darkSkyHomePage.darkSkyLandingPage();
        SharedSD.getDriver().manage().window().maximize();
        Thread.sleep(2000);
        darkSkyHomePage.clearSearchField();
        Thread.sleep(2000);
        darkSkyHomePage.searchField("Boundary St, Houston, TX"); // I live in Texas
        Thread.sleep(2000);
        darkSkyHomePage.clickOnSearchIcon();
        Thread.sleep(2000);

    }
    @Then("^I verify timeline is displayed with two hours incremented$")
    public void IVerifyTimelineIsDisplayWithTwoHoursIncremented() {

        String time1 =darkSkyHomePage.hoursImplement();

        //Date date = new Date();
        //DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("ha");
       // LocalTime time = LocalTime.now();
        //String currentTime = FOMATTER.format(time);

        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("ha");

        String[] timeLineFromDarkSky = time1.split("\n");

        ArrayList<String> timelineArry = new ArrayList<String>();

        for (int i = 1; i < timeLineFromDarkSky.length; i++) {
            timelineArry.add(timeLineFromDarkSky[i]);
        }
        ArrayList<String> currentTimeInArry = new ArrayList<>();

        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusHours(2);
        String localTimeConvertToLowerCase = FORMATTER.format(localTime).toLowerCase();


        for (int i = 1; i < timelineArry.size()+1; i++) {
            currentTimeInArry.add(localTimeConvertToLowerCase);
            localTime = localTime.plusHours(2);
            localTimeConvertToLowerCase = FORMATTER.format(localTime).toLowerCase();
        }
        System.out.println("DarkSky time line hours: "+ timelineArry);

        System.out.println("Current time line hours: "+ currentTimeInArry);

        Assert.assertEquals(timelineArry,currentTimeInArry);
        }

    }






















