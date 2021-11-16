package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteContactsHelper extends HelperBase{

    public DeleteContactsHelper(WebDriver wd) {
        super(wd);}


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


        if(!isContactHave()){

            click(By.xpath("//h3"));
            pause(500);
            click(By.xpath("//button[2]"));
            pause(500);
        }

    }

    public boolean isContactHave() {
        if(wd.findElements(By.xpath("//div[@class='contact-page_message__2qafk']")).size()>0){

            return true;
        } else return false;

    }
}
