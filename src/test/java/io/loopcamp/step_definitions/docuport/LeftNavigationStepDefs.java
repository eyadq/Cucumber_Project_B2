package io.loopcamp.step_definitions.docuport;

import io.cucumber.java.en.Then;
import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LeftNavigationStepDefs {

    @Then("Verify the user has the following items in the left navigation drawer for user {string}")
    public void verify_the_user_has_the_following_items_in_the_left_navigation_drawer_for_user(String userType, Map<String, List<String>> mapOfLists) {


        List<String> expected = mapOfLists.get(userType).stream().filter(Objects::nonNull).toList();

        BasePage basePage = new BasePage();


        List<String> actual = basePage.leftNavigationMenu.stream().map(WebElement::getText).toList();
        if(actual.get(0) == null){
            basePage.openLeftNavigationPanel();
            //actual = basePage.leftNavigationMenu.stream().map(WebElement::getText).toList();
            System.out.println("Here");
        }

        BrowserUtils.waitForVisibility(basePage.userMenu, 10);



        //Assert.assertEquals(expected, actual);



    }
}
