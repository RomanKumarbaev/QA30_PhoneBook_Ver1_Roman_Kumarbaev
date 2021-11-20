package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase {


    @BeforeMethod (alwaysRun = true)
    public void preCondition() {

        if (app.getUser().isLogged()) {

            app.getUser().logOut();
        }

    }

    @Test(groups = {"web"})
    public void RegistrationPositiveTest() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "Suren" + i + "@gmail.com";
        String password = "Nnoa12345$";

        User user = new User().withEmail("Suren" + i + "@gmail.com").withPassword("Nnoa12345$");

        logger.info("Test Registration Positive starts with email>>>>" + email);
        logger.info("Test Registration Positive starts with password>>>>" + password);


        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isLogged());
    }


    @Test
    public void WrongRegistrationEmail() {


        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User().withEmail("Suren" + i + "gmail.com").withPassword("Nnoa12345$");


        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().openLoginRegistrationForm();
        app.getUser().submitRegistration();

        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isErrorMessageWrongFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }


}
