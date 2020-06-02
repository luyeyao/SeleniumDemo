package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.StringTokenizer;

public class DepartPage extends BasePage{
    By addDepart = By.xpath("//li/a/span");//三点按钮

    public DepartPage(RemoteWebDriver driver){
        super(driver);
    }

    public DepartPage addDepart(String departname){
        click(addDepart);
        sendKeys(By.xpath("//a[contains(text(),'添加子部门')]"),departname);
        click(By.linkText("确定"));
        return this;
    }

    public DepartPage search(String keyword){
        sendKeys(By.id("memberSearchInput"),keyword);
        return this;
    }

    public DepartPage delete(){
        click(By.xpath("//li/ul/li/a/span"));
        click(By.xpath("//a[contains(text(),'删除')])[3]"));
        click(By.linkText("确定"));
        return this;

    }









}
