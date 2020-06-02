package page;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{
    public MainPage(){
//        @Before
//        public void setUp() {
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            js = (JavascriptExecutor) driver;
//            vars = new HashMap<String, Object>();
//        }
        super();//先调用父类的构造方法，初始化对象并等待，代替了原先的before↑
        String url="https://work.weixin.qq.com/";
        driver.get(url);
        driver.manage().deleteAllCookies();

        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();
        //System.out.println(driver.manage().getCookies());
        driver.manage().addCookie(new Cookie("wwrtx.refid","7090945153519632"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","GVheDSkCuRa5JOr-vLpzyve3zgzheF-8BC7pNwmRcJwdZ7vqPvAG1u0tPJv3zQpi"));
        //driver.manage().addCookie(new Cookie("wwrtx.vid","1688852676951685"));
        driver.navigate().refresh();

        driver.get(url);
    }

    public ContactPage toContact(){
        click(By.cssSelector("#menu_contacts"));
        return new ContactPage(driver);
    }


}
