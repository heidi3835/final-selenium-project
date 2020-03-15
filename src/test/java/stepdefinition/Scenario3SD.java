package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;

public class Scenario3SD extends DarkSkyHomePage {
    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on Darksky Home Page$")
    public void iAmOnDarkSkyHomePage(){
        darkSkyHomePage.darkSkyLandingPage();
        SharedSD.getDriver().manage().window().maximize();
    }

    @When("^I expand todays timeline$")
    public void iExpandTodaysTimeLine() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();
        Thread.sleep(2000);
        jsScrollBy.executeScript("scrollBy(0,500);");
        Thread.sleep(2000);
        darkSkyHomePage.clickOnExpand();

    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowestAndHighestTempIsDisplayCorrectly(){

        System.out.println("Upper time line lowest temperature: " + darkSkyHomePage.getUpperLowestTemp());
        System.out.println("Upper time line highest temperature: " + darkSkyHomePage.getUpperHighestTemp());

        System.out.println("Lower time line highest temperature: " + darkSkyHomePage.getLowerLineLowestTemp());
        System.out.println("Lower time line lowest temperature: " + darkSkyHomePage.getLowerLineHighestTemp());


        Assert.assertEquals(getUpperLowestTemp(),getLowerLineHighestTemp());
        Assert.assertEquals(getUpperHighestTemp(),getLowerLineLowestTemp());



    }
}
