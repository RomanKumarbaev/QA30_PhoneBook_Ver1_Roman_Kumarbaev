package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegestrationTest extends TestBase {


    @BeforeMethod
    public void preCondition() {

        if (app.getUser().isLogged()) {

            app.getUser().logOut();
        }

    }

    @Test
    public void RegistrationPositiveTest() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        String email = "Suren" + i + "@gmail.com";
        String password = "Nnoa12345$";

        System.out.println("Email: " + email);


        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        // Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());
    }


    @Test
    public void WrongRegistrationEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        String email = "Suren" + i + "gmail.com", password = "Nnoa12345$";

        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        //Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertFalse(app.getUser().isLogged());

    }


}
