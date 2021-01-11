package com.katalon.testops.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageTemplate {

    protected WebDriver driver;

    protected String baseUrl;

    public void init(WebDriver driver) {
        this.driver = driver;
        initElements(driver);
    }

    public void initElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(baseUrl);
    }
}
