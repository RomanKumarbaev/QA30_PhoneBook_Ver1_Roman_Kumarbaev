package manager;

import models.AddNewContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelperAddNewContact extends HelperBase {

    public HelperAddNewContact(WebDriver wd) {
        super(wd);
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

    public void deleteContact(String number) {

        String obj = String.format("//h3[.='%s']",number);

        click(By.xpath(obj));
        click(By.xpath("//button[.='Remove']"));

    }

    public boolean isDeletedContact(String number) {
        String obj = String.format("//h3[.='%s']",number);
        if(wd.findElements(By.xpath(obj)).size()<1){
            return true;
        }else
            return false;

    }
}
