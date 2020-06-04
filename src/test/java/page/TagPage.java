package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TagPage extends BasePage{
    By addtag = By.cssSelector(".member_colLeft_top_addBtn");


    public TagPage (RemoteWebDriver driver){super(driver);}

    public TagPage addTag(String tagname){
        click(addtag);
        sendKeys(By.name("name"),tagname);
        click(By.linkText("确定"));
        return this;
    }
    public TagPage search(String keyword){
        sendKeys(By.id("memberSearchInput"),keyword);
        return this;

    }

    public TagPage delete(){
        click(By.xpath("//main[@id='main']/div/div/div/div/div[2]/div/ul/li/a/i"));
        click(By.linkText("删除"));
        click(By.linkText("确定"));
        return this;
    }



}
