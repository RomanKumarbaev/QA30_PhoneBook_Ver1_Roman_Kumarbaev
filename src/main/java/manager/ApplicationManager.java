package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

     //WebDriver wd;

    EventFiringWebDriver wd;

    HelperUser user;
    ContactHelper addNewContact;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equals(BrowserType.CHROME)){
            logger.info("Tests starts on Chrome Driver");
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)){
            logger.info("Tests starts on FireFox Driver");
            wd = new EventFiringWebDriver(new FirefoxDriver());
        }






        //wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        user = new HelperUser(wd);

        addNewContact = new ContactHelper(wd);


        wd.register(new MyListener());

    }

    public void stop() {

        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return addNewContact;
    }


}
