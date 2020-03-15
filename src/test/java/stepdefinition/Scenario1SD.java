package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.DarkSkyHomePage;


import java.util.ArrayList;
import java.util.Collections;


public class Scenario1SD extends DarkSkyHomePage {
    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("^I am Darksky Home Page$")
    public void IAmOnDarkSkyHomePage() throws InterruptedException {
        darkSkyHomePage.darkSkyLandingPage();
        Thread.sleep(2000);
        SharedSD.getDriver().manage().window().maximize();
        Thread.sleep(2000);
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyLowAndHighTemDisplayCorectly() {

        darkSkyHomePage.getCurrentTemp();


        String subsTodayCurrentTemperature = darkSkyHomePage.getCurrentTemp().substring(0,darkSkyHomePage.getCurrentTemp().indexOf('˚'));

        int todayCurrentTemp = Integer.parseInt(subsTodayCurrentTemperature);
        System.out.println("Current temperature is: " + todayCurrentTemp +"˚");

        String allElementsOfTempInString = darkSkyHomePage.getTimeLineTemp();
        //System.out.println(getTimeLineTemp());

        String[] tempStrArray = allElementsOfTempInString.split("\\n");
        //System.out.println(tempStrArray);

        ArrayList<Integer> temperature = new ArrayList<Integer>();

        for (int i = 0; i < tempStrArray.length; i++) {
            tempStrArray[i] = tempStrArray[i].substring(0, tempStrArray[i].indexOf('°'));

            temperature.add(Integer.parseInt(tempStrArray[i]));
        }

        Collections.sort(temperature);


        System.out.println("Minimum temperature is: "+ temperature.get(0)+"˚");
        int minNumFromArray = temperature.get(0);
        int maxNumFromArray = temperature.get(temperature.size()-1);

        System.out.println("Maximum temperature is: " +temperature.get(temperature.size()-1) +"˚");


        if(todayCurrentTemp>minNumFromArray ||todayCurrentTemp<maxNumFromArray){

            System.out.println("Current temperature is not greater or less then daily timeline temperature");
        }
        else{

            System.out.println("Current temperature is greater or less then daily timeline temperature");
        }
    }


    }
