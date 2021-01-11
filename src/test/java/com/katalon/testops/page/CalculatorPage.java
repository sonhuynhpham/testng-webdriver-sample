package com.katalon.testops.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends PageTemplate {

    @FindBy(xpath = "//button[text()='0']")
    public WebElement number0;

    @FindBy(xpath = "//button[text()='1']")
    public WebElement number1;

    @FindBy(xpath = "//button[text()='2']")
    public WebElement number2;

    @FindBy(xpath = "//button[text()='3']")
    public WebElement number3;

    @FindBy(xpath = "//button[text()='4']")
    public WebElement number4;

    @FindBy(xpath = "//button[text()='5']")
    public WebElement number5;

    @FindBy(xpath = "//button[text()='6']")
    public WebElement number6;

    @FindBy(xpath = "//button[text()='7']")
    public WebElement number7;

    @FindBy(xpath = "//button[text()='8']")
    public WebElement number8;

    @FindBy(xpath = "//button[text()='9']")
    public WebElement number9;

    @FindBy(xpath = "//button[text()='AC']")
    public WebElement allClear;

    @FindBy(xpath = "//button[text()='.']")
    public WebElement dot;

    @FindBy(xpath = "//button[text()='%']")
    public WebElement percent;

    @FindBy(xpath = "//button[text()='+']")
    public WebElement plus;

    @FindBy(xpath = "//button[text()='-']")
    public WebElement minus;

    @FindBy(xpath = "//button[text()='÷']")
    public WebElement division;

    @FindBy(xpath = "//button[text()='x']")
    public WebElement multiplication;

    @FindBy(xpath = "//button[text()='=']")
    public WebElement equal;

    @FindBy(xpath = "//button[text()='+/-']")
    public WebElement plusMinus;

    @FindBy(xpath = "//div[@class='component-display']/div")
    public WebElement result;

    public CalculatorPage(WebDriver driver, String baseUrl) {
        init(driver);
        this.baseUrl = baseUrl;
    }

    public String getResult() {
        return result.getText();
    }
}
