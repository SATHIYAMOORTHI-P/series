package com.lab.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lab.hooks.Hooks;

public class HomePage {
public static WebDriver driver;
	public HomePage() {
PageFactory.initElements(driver,this);	
}
	@FindBy(xpath="(//button[@type='button'])[10]")
	private WebElement close;
	
public WebElement getClose() {
		return close;
	}
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement search;
	
@FindBy(xpath="(//a[@class='product-brief__cta product-brief__cta--shop-now button js-spp-link'])[1]")
private WebElement shopNow;
	
@FindBy(xpath="(//span[text()='Add to Cart'])[3]")
private WebElement addCart;

@FindBy(xpath="(//a[@class='site-header__menu-item js-nav-content'])[1]")
private WebElement sigin;

@FindBy(xpath="(//input[@type='email'])[1]")
private WebElement uName;

@FindBy(xpath="(//input[@type='password'])[2]")
private WebElement pass;

@FindBy(xpath="//input[@type='submit']")
private WebElement submit;

public WebElement getSearch() {
	return search;
}

public WebElement getShopNow() {
	return shopNow;
}

public WebElement getAddCart() {
	return addCart;
}

public WebElement getSigin() {
	return sigin;
}

public WebElement getuName() {
	return uName;
}

public WebElement getPass() {
	return pass;
}

public WebElement getSubmit() {
	return submit;
}


}
