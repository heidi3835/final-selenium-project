package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.hotels.HotelHomePage;
import org.testng.Assert;

public class hotelScenario3 extends HotelHomePage {
    HotelHomePage hotelHomePage = new HotelHomePage();

    @Given("^I am on default locations search result screen$")
    public void IamOnDfaultLocationsSearchResultScreen() throws InterruptedException {
        hotelHomePage.maximizeScreen();
        hotelHomePage.clearDestinationSearchField();
        Thread.sleep(2000);
        hotelHomePage.selectHotel("Houston, Texas, United States of America");
        Thread.sleep(2000);
        hotelHomePage.clickOnClose();
        Thread.sleep(2000);
        hotelHomePage.clickOnSearchButton();
        Thread.sleep(2000);

    }

    @Then("^I verify todays deal is less than \\$(\\d+)$")
    public void IverifyTodaysDealIsLessThan200(int price) throws InterruptedException {

        hotelHomePage.setTodaysDeal();
        String todayDealPrice = hotelHomePage.setTodaysDeal();
        int hotelTodaysBestDeal = Integer.parseInt(todayDealPrice.substring(1));
        System.out.println("Hotel today's best deal in Houston TX : " + hotelTodaysBestDeal);

        if(hotelTodaysBestDeal<price){
            System.out.println(("Hotel price under $200"));
        }else{
            System.out.println("Hotel price more then $200");
        }
    }


    }


