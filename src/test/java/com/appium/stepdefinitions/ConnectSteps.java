package com.appium.stepdefinitions;

import bean.User;
import com.appium.example.BaseAppium;
import com.appium.example.Login;
import com.utils.PropertyLoader;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ConnectSteps {

    PropertyLoader loadproperty = new PropertyLoader();
    User user;

    @Given("^we are a user$")
    public void we_are_a_user() {
        user = new User(loadproperty.loadProperties().getProperty("loginUser"), loadproperty.loadProperties().getProperty("passwordUser"));
    }

    @And("^we enter to application$")
    public void we_enter_to_application() {
        BaseAppium baseAppium = new BaseAppium();
        try {
            baseAppium.init();
        } catch (Exception e) {
            System.out.println("Error connecting to Appium Service");
        }
    }

    @When("^we make login with user and password$")
    public void we_make_login_with_user_and_password() {
        Login login = new Login();
        login.login(user);
    }

    @Then("^the login is successfull$")
    public void the_login_is_successfull() {
        Login login = new Login();
        Assert.assertTrue(login.isUserLogged());
        login.logout();
    }

    @After
    public void close() {
        BaseAppium baseAppium = new BaseAppium();
        baseAppium.tearDown();
    }

}
