package stepdefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import framework.webPages.HomePage;

import org.testng.Assert;

public class Scenario4SD {
    private HomePage homePage = new HomePage();
    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am on the darksky Register page$")
    public void Iamondarkskypage() throws InterruptedException {
        darkSkyHomePage.darkSkyLandingPage();
        Thread.sleep(2000);
        darkSkyHomePage.clickOnRegisterButton();
        Thread.sleep(2000);
        darkSkyHomePage.clickOnSignUpButton();
        Thread.sleep(2000);

    }
    @When("^I click on Register button$")
    public void iClickOnRegisterButton() {
        darkSkyHomePage.clickOnRegister();
    }


    @Then("^I verify I am on Register page by asserting Register header$")
        public void IVerifyIamOnRegisterPageByAssertingRegisterHeader(){
            Assert.assertEquals("Register",darkSkyHomePage.getText());

        }
    }




