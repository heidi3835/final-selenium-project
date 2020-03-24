package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.hotels.HotelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class hotelScenario1 extends HotelHomePage {
    HotelHomePage hotelHomePage = new HotelHomePage();
    JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();

    @Given("^I am on the default locations search result screen$")
    public void Iamlocatoinsearchresult() throws InterruptedException {
        hotelHomePage.maximizeScreen();
        hotelHomePage.selectHotel("Houston, Texas, United States of America");
        Thread.sleep(2000);
        hotelHomePage.clickOnClose();
        Thread.sleep(2000);
        hotelHomePage.clickOnSearchButton();
        Thread.sleep(2000);


    }
    @When("^I select property class (.*)$")
    public void selectpropertyclass(String star) throws InterruptedException {
        jsScrollBy.executeScript("scrollBy(0,500);");
        Thread.sleep(2000);

        switch (star) {
            case "5-star":
                hotelHomePage.ClickOnFiveStarHotel();
                break;
            case "4-star":
                hotelHomePage.ClickOnFourStarHotel();
                break;
            case "3-star":
                hotelHomePage.ClickOnThreeStarHotel();
                break;
            case "2-star":
                hotelHomePage.ClickOnTwoStarHotel();
                break;
            case "1-star":
                hotelHomePage.ClickOnOneStarHotel();
                break;
        }
    }

    @Then("^I verify system displays only (.*) hotels on search result$")
    public void hotelsListwithRating(String star) throws InterruptedException {

        while(true){
            try {
                WebElement element = SharedSD.getDriver().findElement(By.xpath("//h3[contains(text(),'Want to see more hotels?')]"));
                ((JavascriptExecutor) SharedSD.getDriver()).executeScript(
                        "arguments[0].scrollIntoView();", element);
                break;
            }
            catch(Exception ex){
                jsScrollBy.executeScript("scrollBy(0,4000);");
                Thread.sleep(2000);
            }
        }
        List<WebElement> hStars = SharedSD.getDriver().findElements(By.xpath("//div[@id='listings']//following::li//following::div[contains(@class,'additional-details')]//span[contains(@class,'star-rating')]"));
        //"//div[@id='listings']//following::div[contains(@class,'additional-details')]//span[contains(@class,'star-rating')]"));
        //   ("//div[@id='search-results']//div[@class='resp-col main']//div[@id='listings']//following::ol//following::li//span[contains(@class,'star-rating')]"));
        List<WebElement> hlsList = SharedSD.getDriver().findElements(By.xpath("//div[@id='listings']//h3[@class='p-name']"));
        for (int i = 0; i < hlsList.size(); i++) {
            System.out.println("Hotels list with " + hStars.get(i).getText() + " " + hlsList.get(i).getText());
        }
        boolean hoStar = true;
        if (star.equals(hotelHomePage.getFiveStarHotels())){
            hoStar = true;
        } else {
            hoStar = false;
            Assert.assertTrue(hoStar,"Error hotel star");
        }
    }
}














