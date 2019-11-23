package com.lab.stepdefinition;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.lab.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lab.objectrepositary.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	static   HomePage h=new HomePage();
	

@Given("User enters into the home page")
public void user_enters_into_the_home_page() {
System.out.println("stepdefinition");
driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

   send(h.getSearch(),"shampoo");
}

@When("User addtobag the product")
public void user_addtobag_the_product() throws AWTException {
	
	 enter();
	 h.getShopNow().click();

	
}

@Then("User enters into the checkout page")
public void user_enters_into_the_checkout_page() {
	
		h.getAddCart().click();
}

@Given("User enter into the home page")
public void user_enter_into_the_home_page() {
		   send(h.getSearch(),"washer");

}

@When("User select the product")
public void user_select_the_product() throws AWTException {
	
	 enter();
	 h.getShopNow().click();

}

@Then("User enters into payment page")
public void user_enters_into_payment_page() {
	 HomePage h=new HomePage();
		h.getAddCart().click();
	
}

@Given("User enter into the login page")
public void user_enter_into_the_login_page() {

	
move(h.getSigin());

}

@When("User enter the details")
public void user_enter_the_details() {
		 send(h.getuName(),"sathya");
	 send(h.getPass(),"1234");
}

@Then("User enters into the account page")
public void user_enters_into_the_account_page() {

h.getSubmit().click();

}
}
