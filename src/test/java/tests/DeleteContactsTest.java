package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactsTest extends TestBase{

    @BeforeMethod
    public void precondition(){

        if (app.getAddNewContact().isLogOut()){
            app.getAddNewContact().logIn();
        }
    }


    @Test
    public void deleteOneContact(){

        app.getDeleteContact().openContactForm();

        app.getDeleteContact().deleteOneContact();

        app.getDeleteContact().pause(2000);

    }

    @Test
    public void deleteAllContactsPositiveTest(){

        app.getDeleteContact().openContactForm();

        app.getDeleteContact().deleteAllContacts();

        app.getDeleteContact().pause(2000);

        Assert.assertTrue(app.getDeleteContact().allContactsIsDelete());
    }


}
