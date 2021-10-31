package tests;

import models.User;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {


    @Test
    public void LoginPositiveTest() {
        //login
//
//        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
//        loginBtn.click();
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("noa@gmail.com");
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Nnoa12345$");
//
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);
//
//        wd.findElement(By.xpath("//button[text()='Sign Out']")).click();

    }

    @Test
    public void LoginTest2() {
//        String email = "noa@gmail.com";
//        String password = "Nnoa12345$";

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");


        app.getUser().openLoginRegistrationForm();

        //app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().pause(5000);
        app.getUser().submitLogin();

        app.getUser().pause(5000);

//        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        //Assert.assertTrue(app.getUser().isLogged());

    }


}
