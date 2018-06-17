package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Priti on 16-06-2018.
 */
public class MainPage {

    WebDriver driver;

    By logout = By.xpath("/html/body/div/header/div/p[1]");
    By create    = By.xpath("//*[@id=\"bAdd\"]");

    By edit =   By.xpath("//*[@id=\"bEdit\"]");
    By delete = By.xpath("//*[@id=\"bDelete\"]");

    public MainPage(WebDriver driver){

        this.driver = driver;

    }

    public void logout(){ driver.findElement(logout).click(); }

    public void clickCreate(){
        driver.findElement(create).click();

    }

    public void selectEmployee(String name){

        String employeeSelect = "//*[@id=\"employee-list\"]/li[contains(text(),'"+name+"')]";
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(employeeSelect))).perform();

    }
}

