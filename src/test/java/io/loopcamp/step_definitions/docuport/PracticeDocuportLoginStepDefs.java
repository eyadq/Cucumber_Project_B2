//package io.loopcamp.step_definitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.loopcamp.pages.docuport.BasePage;
//import io.loopcamp.pages.docuport.LoginPage;
//import io.loopcamp.pages.docuport.ProfilePage;
//import io.loopcamp.utilities.BrowserUtils;
//import io.loopcamp.utilities.ConfigurationReader;
//import io.loopcamp.utilities.DocuportConstants;
//import io.loopcamp.utilities.Driver;
//import org.junit.Assert;
//import org.openqa.selenium.WebElement;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
//
//public class PracticeDocuportLoginStepDefs {
//
//    LoginPage loginPage = new LoginPage();
//    @Given("user is on Docuport login page for {string}")
//    public void userIsOnDocuportLoginPageFor(String arg0) {
//        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
//        BrowserUtils.takeScreenshot();
//    }
//
//    @When("user enters username for {string}")
//    public void userEntersUsernameFor(String arg0) {
//        String username = "";
//        switch (arg0){
//            case "client":
//                username = DocuportConstants.USERNAME_CLIENT;
//                break;
//            case "employee":
//                username = DocuportConstants.USERNAME_EMPLOYEE;
//                break;
//            case "advisor":
//                username = DocuportConstants.USERNAME_ADVISOR;
//                break;
//            case "supervisor":
//                username = DocuportConstants.USERNAME_SUPERVISOR;
//                break;
//        }
//        loginPage.usernameInput.sendKeys(username);
//        BrowserUtils.takeScreenshot();
//    }
//
//    @When("user enters password for {string}")
//    public void user_enters_password_for(String role) {
//        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
//        BrowserUtils.takeScreenshot();
//    }
//    @And("user clicks login button for {string}")
//    public void userClicksLoginButtonFor(String arg0) {
//        loginPage.loginButton.click();
//    }
//
//    @Then("user should see the home page for {string}")
//    public void userShouldSeeTheHomePageFor(String userType) {
//        if(userType.equals("client")){
//            BrowserUtils.waitForClickable(loginPage.continueButton, DocuportConstants.large);
//            loginPage.continueButton.click();
//            BrowserUtils.waitForClickable(loginPage.userMenu, DocuportConstants.large);
//        }
//
//        String username = "";
//        switch (userType) {
//            case "client":
//                username = DocuportConstants.USERNAME_CLIENT;
//                break;
//            case "employee":
//                username = DocuportConstants.USERNAME_EMPLOYEE;
//                break;
//            case "advisor":
//                username = DocuportConstants.USERNAME_ADVISOR;
//                break;
//            case "supervisor":
//                username = DocuportConstants.USERNAME_SUPERVISOR;
//            case "smitty":
//                username = DocuportConstants.USERNAME_SMITTY_WERBENJAGERMANJENSEN;
//                break;
//
//        ProfilePage profilePage = new ProfilePage();
//        profilePage.userMenu.click();
//        profilePage.options.stream().map(each-> each.getAttribute("innerText")).toList(); //need this line to actually click on the profile button?
//        profilePage.selectOption("Profile");
//
//        Assert.assertEquals("The actual user type role obtained from the profile did not meet expected value from the scenario", username, profilePage.emailAddress.getText().toLowerCase());
//
//        BrowserUtils.takeScreenshot();
//    }
//
//    @When("user enters credentials")
//    public void user_enters_credentials(Map <String, String> credentials) {
//
////        for (Map.Entry <String, String> entry: credentials.entrySet()){
////            String key = entry.getKey();
////            System.out.println("key = " + key);
////            String value = entry.getValue();
////            System.out.println("value = " + value);
////        }
//
//        loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
//    }
//
//    @Given("user is on Docuport login page")
//    public void userIsOnDocuportLoginPage() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
//    }
//
//    @Then("user should see the home page for user")
//    public void userShouldSeeTheHomePageForUser(List<String> roles) {
//    }
//
//
//}
