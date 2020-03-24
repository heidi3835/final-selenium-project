package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.hotels.HotelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class hotelScenario4 extends HotelHomePage {
    HotelHomePage hotelHomePage = new HotelHomePage();
    @Given("^I am on hotels.com home page$")
    public void iAmOnHotelscomHomePage(){
        hotelHomePage.maximizeScreen();
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations","Invalid Home Page");
    }

    @Then("^I select (.*) from room dropdown$")
    public void selectRoomsFromDropdown(String room) throws InterruptedException {
        switch (room) {
            case "1":
                hotelHomePage.selectRoom("1");
                Thread.sleep(2000);
                break;
            case "2":
                hotelHomePage.selectRoom("2");
                Thread.sleep(2000);
                break;
            case "3":
                hotelHomePage.selectRoom("3");
                Thread.sleep(2000);
                break;
            case "4":
                hotelHomePage.selectRoom("4");
                break;
            case "5":
                hotelHomePage.selectRoom("5");
                break;
            case "6":
                hotelHomePage.selectRoom("6");
                break;
            case "7":
                hotelHomePage.selectRoom("7");
                break;
            case "8":
                hotelHomePage.selectRoom("8");
                break;
            case "9":
                hotelHomePage.selectRoom("9");
                break;
        }
    }



    @Then("^I verify (.*) is displayed$")
    public void iVerfyNumberOfDropdownDisplayed(String verify){
        List<WebElement> roomsnmber = SharedSD.getDriver().findElements(By.xpath("//span[contains(text(),'Room')]"));
        for (int i = 0; i < roomsnmber.size(); i++) {
            System.out.println("Display room after clicking rooms dropdown :"+roomsnmber.get(i).getText());
        }
        Assert.assertTrue(hotelHomePage.isRoomDisplyed(),"It is not display");
    }
}



