package com.example.demo2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = "h2 > a[href]")
    private List <WebElement> results;

    public void clickElement(WebDriver driver ,int num) {
        results.get(num).click();
        System.out.println("Произведено нажатие по результату поиска номер " + (num + 1));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getTextFromSearchField() {
        String value = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + value);
        return value;
    }

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
