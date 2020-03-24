package framework.webPages.hotels;

import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;

public class HotelHomePage extends BasePage {
    BasePage basePage = new BasePage();

    public By destinationSearchField = By.xpath("//input[@id='qf-0q-destination']");
    private By scarchButton = By.xpath("//button[@class='cta cta-strong']");
    //private By list=By.xpath("//td[contains(text(),'...and more, keep typing to refine search')]");
    private By closebutton = By.xpath("//button[contains(@class,'cta cta-link')]");
    //private By clickOndelasredicon = By.xpath("//span[@class='deal-text']");
    private By todaysDeal = By.xpath("//section[@class='hotel-wrap']//aside[@class='pricing resp-module']//div[@class='price']//ins[contains(text(), '$')]");
    private By landmarkIcon = By.xpath("//h3[contains(text(),'Landmarks')]");
    private By clickOnAirport = By.id("f-label-lid-1662393");
    private By distance = By.xpath("//div[@id = 'filter-landmarks-contents']//select[@id='f-distance']");
   // private By hotelList = By.xpath("//div[@id='listings']//h3[@class='p-name']");
    private By chooseFiveStarHotels = By.xpath("//fieldset[@id='filter-star-rating']//li[*][1]");
    private By chooseFourStarHotels = By.xpath("//fieldset[@id='filter-star-rating']//li[*][2]");
    private By chooseThreeStarHotels = By.xpath("//fieldset[@id='filter-star-rating']//li[*][3]");
    private By chooseTwoStarHotels = By.xpath("//fieldset[@id='filter-star-rating']//li[*][4]");
    private By chooseOneStarHotels = By.xpath("//fieldset[@id='filter-star-rating']//li[*][5]");
    private By selectRoom = By.xpath("//select[@id='qf-0q-rooms']");
    private By displyRoom=By.xpath("//span[contains(text(),'Room')]");


    public void clearDestinationSearchField() {
        SharedSD.getDriver().findElement(destinationSearchField).clear();

    }

    public void selectHotel(String text) {
        SharedSD.getDriver().findElement(destinationSearchField).sendKeys(text);

    }

    public void clickOnClose() {
        clickOn(closebutton);
    }

    public void clickOnSearchButton() {
        clickOn(scarchButton);
    }

    // public void setClickOndelasredicon() {
    // clickOn(clickOndelasredicon);
    // }

    public String setTodaysDeal() {
        return SharedSD.getDriver().findElement(todaysDeal).getText();
    }

    public void setLandmarkIcon() {
        clickOn(landmarkIcon);
    }

    public void setClickOnJfkAirport() {
        clickOn(clickOnAirport);
    }

    //public String setDistance() {
     //   return SharedSD.getDriver().findElement(distance).getText();
   // }

    public void ClickOnFiveStarHotel(){clickOn(chooseFiveStarHotels);}
    public void ClickOnFourStarHotel(){clickOn(chooseFourStarHotels);}
    public void ClickOnThreeStarHotel(){clickOn(chooseThreeStarHotels);}
    public void ClickOnTwoStarHotel(){clickOn(chooseTwoStarHotels);}
    public void ClickOnOneStarHotel(){clickOn(chooseOneStarHotels);}

    public String getFiveStarHotels() {
        return getTextFromElement(chooseFiveStarHotels);
    }
    public String getFourStarHotels() {
        return getTextFromElement(chooseFourStarHotels);
    }
    public String getThreeStarHotels() {
        return getTextFromElement(chooseThreeStarHotels);
    }

    public String getTwoStarHotels(){
        return getTextFromElement(chooseTwoStarHotels);
    }
    public String getOneStarHotels(){
        return getTextFromElement(chooseOneStarHotels);
    }
   // public void getdropdownRooms(){
     //   clickOn(dropdownRoom);
   // }
    public void getDistanceMiles(){
       Select miles = new Select(SharedSD.getDriver().findElement(By.xpath("//div[@id = 'filter-landmarks-contents']//select[@id='f-distance']")));
        miles.selectByVisibleText("10 miles");
    }
    public void selectRoom(String text){ selectFromDropdown(selectRoom,text); }
    public boolean isRoomselected(){ return SharedSD.getDriver().findElement(By.xpath("//select[@id='qf-0q-rooms']")).isSelected(); }
    public boolean isRoomDisplyed(){ return isElementDisplayed(displyRoom); }
   // private By selectRoom=By.xpath("//select[@id='qf-0q-rooms']");

    public void maximizeScreen() {
        SharedSD.getDriver().manage().window().maximize();
    }

}
