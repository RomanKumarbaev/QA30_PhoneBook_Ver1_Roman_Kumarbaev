import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RegestrationTest extends TestBase{


@BeforeMethod
public void preCondition(){

    if (isLogged()){

        logOut();
    }

}

    @Test
    public void RegistrationPositiveTest(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        String email = "Suren"+i+"@gmail.com";
        String password="Nnoa12345$";

        System.out.println("Email: "+email);


        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));

    }


    @Test
public void WrongRegistrationEmail(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;

    String email = "Suren"+i+"gmail.com", password="Nnoa12345$";

    System.out.println("Email: "+email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitRegistration();
        Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));

    }


}
