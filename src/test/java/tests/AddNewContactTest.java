package tests;

import models.AddNewContact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

    int i=(int)((System.currentTimeMillis()/1000)%3600);
    String email = String.format("vika%d@gmai.com",i);
    String number = String.format("%d5%d",i,i) ;


    @BeforeMethod
    public void precondition(){

        if (app.getAddNewContact().isLogOut()){
            app.getAddNewContact().logIn();
        }
    }


    @Test
    public void addNewContactPositiveTest(){



        AddNewContact addNewContact= AddNewContact.builder()
                .name("Vasya"+i)
                .lastname("Pupkinson")
                .phone(number)
                .email(email)
                .address("Pushkina 16")
                .description("Friend"+i)
                .build();
        app.getAddNewContact().openAddForm();
        app.getAddNewContact().fillAddForm(addNewContact);
        app.getAddNewContact().submitAdd();

        app.getAddNewContact().pause(2000);

        Assert.assertTrue(app.getAddNewContact().isContactAdd());
    }

    @AfterMethod
    public void postCondition(){

        app.getAddNewContact().deleteContact(number);

        app.getAddNewContact().pause(500);

        Assert.assertTrue(app.getAddNewContact().isDeletedContact(number));

    }

}
