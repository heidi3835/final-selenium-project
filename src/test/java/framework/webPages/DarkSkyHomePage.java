package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class DarkSkyHomePage extends BasePage{

    private By apiRegisterButton = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    public By signUpButton = By.xpath("//a[@class='button filled']");
    public By registerButton = By.xpath("//button[contains(text(),'Register')]");
    public By registerTxt = By.xpath("//h1[@class='stand-alone title']");
    public By expandTimeLine = By.xpath("//a[@data-day='0']//span[@class='open']");
    public By upperLineLowestTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    public By upperLineHighestTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    public By lowerLineHighestTemp = By.xpath("//div[contains(@class,'revealed')]//span[@class='lowTemp swap']//span[@class='temp']");
    public By lowerLineLowestTemp = By.xpath("//div[contains(@class,'revealed')]//span[@class='highTemp swip']//span[@class='temp']");
    public By currentTempature = By.xpath("//span[@class='summary swap']");
    public By timeLineTempature = By.xpath("//div[@id='timeline']//div[@class='temps']");
    public By LowTempature = By.xpath("//span[@class='low-temp-text']");
    public By HighTempature = By.xpath("//span[@class='high-temp-text']");
    public By twoHoursImplement = By.xpath("//div[@id='timeline']//div[@class='hours']");
    private By searchTexasState=By.xpath("//form[@id='searchForm']//input");
    private By searchIcon=By.xpath("//a[@class='searchButton']//img");


    public void darkSkyLandingPage (){
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }



    public void clickOnRegisterButton(){clickOn(apiRegisterButton);}
    public void clickOnSignUpButton(){clickOn(signUpButton);}
    public void clickOnRegister(){clickOn(registerButton);}
    public String getText(){ return getTextFromElement(registerTxt); }
    public void clickOnExpand(){ clickOn(expandTimeLine);}
    public String getUpperLowestTemp(){return getTextFromElement(upperLineLowestTemp);}
    public String getUpperHighestTemp(){return getTextFromElement(upperLineHighestTemp);}
    public String getLowerLineHighestTemp(){return getTextFromElement(lowerLineLowestTemp);}// lowest to high
    public String getLowerLineLowestTemp(){return getTextFromElement(lowerLineHighestTemp);}//high to low

    public String getCurrentTemp(){return getTextFromElement(currentTempature);}
    public String getTimeLineTemp(){return getTextFromElement(timeLineTempature);}
    public String lowTemp(){return getTextFromElement(LowTempature);}
    public String highTemp(){return getTextFromElement(HighTempature);}
    public String hoursImplement(){
        return getTextFromElement(twoHoursImplement);
    }

    public void searchField(String value){
        SharedSD.getDriver().findElement(searchTexasState).sendKeys(value);
    }
    public void clearSearchField() {
        SharedSD.getDriver().findElement(searchTexasState).clear();
    }
    public void clickOnSearchIcon(){
        clickOn(searchIcon);
    }

}
