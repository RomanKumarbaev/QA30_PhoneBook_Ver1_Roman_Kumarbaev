package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactsTest extends TestBase{

    @BeforeMethod
    public void precondition(){


        if (app.getContact().isLogOut()){
            app.getContact().logIn();
        }
    }


    @Test
    public void deleteOneContact(){



        app.getContact().openContactForm();

        app.getContact().deleteOneContact();

        app.getContact().pause(2000);

        Assert.assertTrue(app.getContact().isDeleteOneContact(app.getContact().res));

    }

    @Test
    public void deleteAllContactsPositiveTest(){

        app.getContact().openContactForm();

        app.getContact().deleteAllContacts();

        app.getContact().pause(2000);

        Assert.assertTrue(app.getContact().allContactsIsDelete());
    }


}
