package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

   // WebDriver wd;

    EventFiringWebDriver wd;

    HelperUser user;
    ContactHelper addNewContact;

    DeleteContactsHelper deleteContact;


    public void init() {

        wd = new EventFiringWebDriver(new ChromeDriver());

        logger.info("Tests starts on Chrome Driver");


        //wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        user = new HelperUser(wd);

        addNewContact = new ContactHelper(wd);

        deleteContact = new DeleteContactsHelper(wd);

        wd.register(new MyListener());

    }

    public void stop() {

        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public ContactHelper getAddNewContact() {
        return addNewContact;
    }

    public DeleteContactsHelper getDeleteContact() {
        return deleteContact;
    }
}
