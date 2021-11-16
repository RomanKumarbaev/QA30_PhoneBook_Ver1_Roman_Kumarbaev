package manager;

import models.AddNewContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public boolean res;

    public void openContactForm() {

        click(By.xpath("//a[.='CONTACTS']"));
    }

    public void deleteAllContacts() {

        if (!isContactHave()){

            while (wd.findElements(By.xpath("//h3")).size()>0){

                pause(500);
                click(By.xpath("//h3"));
                pause(500);
                click(By.xpath("//button[2]"));
                pause(500);

                if(isContactHave()){
                    break;
                }


            }}
    }

    public boolean allContactsIsDelete() {
        if(wd.findElements(By.xpath("//div[@class='contact-page_message__2qafk']")).size()>0){
            return true;
        }else
            return false;
    }

    public void deleteOneContact() {
        int a, b;



        a=wd.findElements(By.xpath("//h3")).size();

        if(!isContactHave()){

            click(By.xpath("//h3"));
            pause(500);
            click(By.xpath("//button[2]"));
            pause(500);
        }

        b= wd.findElements(By.xpath("//h3")).size();

        if (a==b+1 || a==0 ){
            res=true;
        } else {res=false;}

    }

    public boolean isContactHave() {
        if(wd.findElements(By.xpath("//div[@class='contact-page_message__2qafk']")).size()>0){

            return true;
        } else return false;

    }

    public boolean isDeleteOneContact(boolean res) {
        return res;
    }

    public boolean isLogOut() {
        return wd.findElements(By.xpath("//a[.='LOGIN']")).size() > 0;
    }

    public void logIn() {
        String email = "noa@gmail.com";
        String password = "Nnoa12345$";

        openLogInForm();
        fillLogInForm(email,password);
        submitLogin();

        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);

    }

    private void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    private void fillLogInForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);

    }

    private void openLogInForm() {
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void openAddForm() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void fillAddForm(AddNewContact addNewContact) {

        if(isFormAddPresent()){
            type(By.xpath("//input[@placeholder='Name']"),addNewContact.getName());
            type(By.xpath("//input[@placeholder='Last Name']"), addNewContact.getLastname());
            type(By.xpath("//input[@placeholder='Phone']"), addNewContact.getPhone());
            type(By.xpath("//input[@placeholder='email']"), addNewContact.getEmail());
            type(By.xpath("//input[@placeholder='Address']"), addNewContact.getAddress());
            type(By.xpath("//input[@placeholder='description']"), addNewContact.getDescription());

        }

    }

    private boolean isFormAddPresent() {
    if (wd.findElements(By.xpath("//div[@class='add_form__2rsm2']")).size()>0){
        return true;
    }else
        return false;

    }

    public void submitAdd() {
        click(By.xpath("//button[.='Save']"));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isContactAdd() {
 return wd.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']")).size()>0;

    }


}
