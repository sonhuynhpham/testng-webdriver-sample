package com.katalon.testops;

import com.katalon.testops.page.CalculatorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGCalculatorTest {

    private final String BASE_URL = "https://ahfarmer.github.io/calculator/";

    private final ThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return new ChromeDriver();
        }

        @Override
        public void remove() {
            get().quit();
            super.remove();
        }
    };

    private CalculatorPage initPage() {
        CalculatorPage page = new CalculatorPage(driver.get(), BASE_URL);
        page.open();
        return page;
    }

    private void assertResultEqual(CalculatorPage page, String expected) {
        assertEquals(page.getResult(), expected);
    }

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setupTest() {
        driver.get();

    }

    @AfterMethod
    public void teardown() {
        driver.remove();
    }

    @Test
    public void testDigits() {
        CalculatorPage page = initPage();

        page.number1.click();
        page.number2.click();
        page.number3.click();
        page.number4.click();
        page.number5.click();
        page.number6.click();
        page.number7.click();
        page.number8.click();
        page.number0.click();
        page.dot.click();
        page.number9.click();
        assertResultEqual(page, "123456780.9");

    }

    @Test
    public void testAdd() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.plus.click();

        page.number1.click();
        page.number2.click();
        assertResultEqual(page, "12");

        page.equal.click();
        assertResultEqual(page, "377");
    }

    @Test
    public void testSubtract() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.minus.click();

        page.number1.click();
        page.number2.click();
        assertResultEqual(page, "12");

        page.equal.click();
        assertResultEqual(page, "353");
    }

    @Test
    public void testMultiply() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.multiplication.click();

        page.number1.click();
        page.number2.click();
        assertResultEqual(page, "12");

        page.equal.click();
        assertResultEqual(page, "4380");
    }

    @Test
    public void testDivide() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.division.click();

        page.number1.click();
        page.number0.click();
        assertResultEqual(page, "10");

        page.equal.click();
        assertResultEqual(page, "36.5");
    }

    @Test
    public void testPercent() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.percent.click();
        assertResultEqual(page, "3.65");
    }

    @Test
    public void testPlusMinus() {
        CalculatorPage page = initPage();

        page.number3.click();
        page.number6.click();
        page.number5.click();
        assertResultEqual(page, "365");

        page.plusMinus.click();
        assertResultEqual(page, "-365");

        page.plusMinus.click();
        assertResultEqual(page, "365");
    }
}
