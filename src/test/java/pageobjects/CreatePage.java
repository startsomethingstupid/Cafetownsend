package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Priti on 16-06-2018.
 */
public class CreatePage {

    WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver,10);


    By create    = By.xpath("//*[@id=\"bAdd\"]");
    By cancel    = By.xpath("//*[@id=\"sub-nav\"][2]/li/a");
    By firstName = By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input");
    By lastName  = By.xpath("/html/body/div/div/div/form/fieldset/label[2]/input");
    By startDate = By.xpath("/html/body/div/div/div/form/fieldset/label[3]/input");
    By email     = By.xpath("/html/body/div/div/div/form/fieldset/label[4]/input");
    By add       = By.xpath("/html/body/div/div/div/form/fieldset/div/button[2]");


    public CreatePage(){

    }
    public CreatePage(WebDriver driver){

        this.driver = driver;

    }

    public void setFirstName(String fName) {

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName) {

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setStartDate(String sDate) {

        driver.findElement(startDate).clear();
        driver.findElement(startDate).sendKeys(sDate);
    }

    public void setEmail(String sEmail) {

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(sEmail);
    }

    public void clickAdd() {
        driver.findElement(add).click();
    }

    public void setDetails(String fName, String lName, String sDate, String email){
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setStartDate(sDate);
        this.setEmail(email);
    }



    public Boolean confirmCreate(){
        return driver.findElement(create).isDisplayed();
    }

    public void clickCancel(){
        driver.findElement(cancel).click();
    }

    public Boolean errorCreate(){
        return driver.findElement(add).isDisplayed();
    }

}
