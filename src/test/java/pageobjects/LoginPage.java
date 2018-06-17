package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Priti on 14-06-2018.
 */
public class LoginPage {

   WebDriver driver;
   //WebDriverWait wait = new WebDriverWait(driver,10);


    By username = By.xpath("//*[@id=\"login-form\"]/fieldset/label[1]/input");
    By password = By.xpath("//*[@id=\"login-form\"]/fieldset/label[2]/input");
    By submit =   By.xpath("//*[@id=\"login-form\"]/fieldset/button");
    By message =  By.xpath("//*[@id=\"login-form\"]/fieldset/p[1]");
    By greeting = By.xpath("//*[@id=\"greetings\"]");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void setUserName(String strUsername){

        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(strUsername);

    }

    public void setPassword(String strPassword){

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);

    }

    public void clickSubmit(){

        driver.findElement(submit).click();
    }

    public String getInvalidMessage(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBePresentInElement(message,"Invalid username or password!"));
        return driver.findElement(message).getText();
    }

    public String getGreeting(){

        return driver.findElement(greeting).getText();
    }


    public void login(String strUsername, String strPassword){

        this.setUserName(strUsername);
        this.setPassword(strPassword);
        this.clickSubmit();
}

}
