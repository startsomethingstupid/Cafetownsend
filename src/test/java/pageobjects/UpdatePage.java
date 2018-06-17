package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Priti on 16-06-2018.
 */
public class UpdatePage extends CreatePage {

    //By employeeSelect = By.xpath("//*[@id=\"employee-list\"]");
    By update = By.xpath("/html/body/div/div/div/form/fieldset/div/button[1]");
    By delete = By.xpath("/html/body/div/div/div/form/fieldset/div/p");

    public UpdatePage(WebDriver driver){

        this.driver = driver;

    }


    public void clickUpdate(){
        driver.findElement(update).click();
    }

    public void clickDelete(){

        driver.findElement(delete).click();
        driver.switchTo().alert().accept();

    }
}
