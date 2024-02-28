package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import io.loopcamp.pages.ProductPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductStepDefs {

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));
    }
    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String, String>> productDetails) {
        ProductPage productPage = new ProductPage();
        for(Map<String, String> productDetail: productDetails){
            //System.out.println("Product Details");
            //System.out.println(productDetail.get("Category"));
            //System.out.println(productDetail.get("Product"));
            //System.out.println(productDetail.get("expectedPrice"));

            productPage.clickCategory(productDetail.get("Category"));

            String actual = productPage.getProductPrice(productDetail.get("Product"));
            String expectedPrice = productDetail.get("expectedPrice");

            assertEquals(actual, expectedPrice);

        }

    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {
        ProductPage productPage = new ProductPage();
        for (List<String> productDetail : productDetails){
            //System.out.println("===========Product Detail===========");
            //System.out.println("Product Category: " + productDetail.get(0));
            //System.out.println("Product Name: " + productDetail.get(1));
            //System.out.println("Product Price: " + productDetail.get(2));

            productPage.clickCategory(productDetail.get(0));

            String actualPrice = productPage.getProductPrice(productDetail.get(1));
            String expectedPrice = productDetail.get(2);
            assertEquals(actualPrice, expectedPrice);


        }
    }

    @Then("User should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String, List<String>> students) {

        List<String> group1 = students.get("Group 1");
        List<String> group2 = students.get("Group 2");
        List<String> group3 = students.get("Group 3");

        System.out.println("group1 = " + group1);
        System.out.println("group2 = " + group2);
        System.out.println("group3 = " + group3);
    }
}
