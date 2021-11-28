package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {


    @BeforeMethod
    public  void  preCon(){

        if (app.getUser().isLogged()){
            app.getUser().logOut();
        }

    }




    @Test (groups = {"web"})
    public void LoginTest2() {
        String email = "noa@gmail.com";
        String password = "Nnoa12345$";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().pause(1000);

        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void LoginTestModel() {
        String email = "noa@gmail.com";
        String password = "Nnoa12345$";

        User user = new User().withEmail(email).withPassword(password);


        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().pause(5000);

        app.getUser().submitLogin();

        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());

    }

    @AfterMethod
    public void postCondition(){
        app.getUser().logOut();

    }


}
