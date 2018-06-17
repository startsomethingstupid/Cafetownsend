package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.CreatePage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.UpdatePage;

public class TestExecution {

    public WebDriver driver;
    LoginPage newLogin;
    CreatePage createPage;
    UpdatePage updatePage;
    MainPage mainPage;

    @BeforeClass
    public void startBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
    }

    @DataProvider(name = "invalidLogin")
    public static Object[][] invalidCredentials() {

        return new Object[][] {{ "test", "Skywalker" },
                               { "Luke", "test"      },
                               { "Luke", ""          },
                               {  ""   , "Skywalker" }};
    }

    @Test(dataProvider = "invalidLogin",priority = 0)
    public void invalidLogin(String sUsername,String sPassword) throws InterruptedException {


        newLogin = new LoginPage(driver);
        newLogin.login(sUsername,sPassword);
        Assert.assertEquals(newLogin.getInvalidMessage(),"Invalid username or password!");
        System.out.println("Invalid Login. Details Username ="+sUsername+" and Password = "+sPassword);
    }

    @Test (priority = 1)
    public void validLogin() {

        newLogin = new LoginPage(driver);
        newLogin.login("Luke","Skywalker");
        Assert.assertEquals(newLogin.getGreeting(),"Hello Luke");
        System.out.println("Login successful.");
    }

    @DataProvider(name = "invalidCreateEmployee")
    public static Object[][] invalidEmployee() {

        return new Object[][] { {"Selenium", "", "2018-01-01", "a@b.cam"},
                                {"", "Test", "2018-01-01", "a@b.cam"},
                                {"Selenium", "Test", "", "a@b.cam"},
                                {"Selenium", "Test", "2018-01-01", "ab.cam"}};

    }

    @Test (dataProvider="invalidCreateEmployee", priority = 2)
    public void invalidCreateEmployee (String fName, String lName, String sDate, String email)throws InterruptedException{
        createPage = new CreatePage(driver);
        mainPage = new MainPage(driver);
        mainPage.clickCreate();
        createPage.setDetails(fName,lName,sDate,email);
        createPage.clickAdd();
        Thread.sleep(5000);
        Assert.assertTrue(createPage.errorCreate());
        System.out.println("Invalid Create. Details First Name ="+fName+" and Last Name = "+lName+" Start Date = "+sDate+" Email = "+email);
        createPage.clickCancel();
    }

    @Test (priority = 3)
    public void createEmployee(){

        createPage = new CreatePage(driver);
        mainPage.clickCreate();
        createPage.setDetails("Selenium","Test","2018-01-01","a@b.cam");
        createPage.clickAdd();
        Assert.assertTrue(createPage.confirmCreate());
        System.out.println("Create Employee successful.");

    }

    @Test (priority = 4)
    public void updateEmployee(){

        updatePage = new UpdatePage(driver);
        mainPage.selectEmployee("Selenium");
        updatePage.setDetails("Selenium1","Test","2018-01-01","a@b.cam");
        updatePage.clickUpdate();
        Assert.assertTrue(updatePage.confirmCreate());
        System.out.println("Update Employee successful.");
    }

    @Test (priority = 5)
    public void deleteEmployee(){

        mainPage.selectEmployee("Selenium");
        updatePage.clickDelete();
        Assert.assertTrue(updatePage.confirmCreate());
        System.out.println("Delete Employee successful.");
    }

    @Test(priority = 6)
    public void correctLogout(){

        mainPage.logout();
        System.out.println("Logout successful.");
    }
}
