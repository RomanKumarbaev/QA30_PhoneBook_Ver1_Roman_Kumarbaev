package tests;

import models.AddNewContact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{




    @BeforeMethod (alwaysRun = true)
    public void precondition(){

        if (app.getContact().isLogOut()){
            app.getContact().logIn();
        }
    }


    @Test (invocationCount = 3,groups = {"web","smoke"})
    public void addNewContactPositiveTest(){

        int i=(int)((System.currentTimeMillis()/1000)%3600);
        String email = String.format("vika%d@gmai.com",i);
        String number = String.format("%d5%d",i,i) ;


        AddNewContact addNewContact= AddNewContact.builder()
                .name("Vasya"+i)
                .lastname("Pupkinson")
                .phone(number)
                .email(email)
                .address("Pushkina 16")
                .description("Friend"+i)
                .build();
        app.getContact().openAddForm();
        app.getContact().fillAddForm(addNewContact);
        app.getContact().submitAdd();

        Assert.assertTrue(app.getContact().isContactAdd());

    }



}
