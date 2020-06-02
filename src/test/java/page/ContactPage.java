package page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class ContactPage extends BasePage{
    //进入通讯录页面就需要find再click，find，click需要driver对象
//    public ContactPage add(String username,String uid,String phone){
//        App.driver.findElement(By.name("username")).sendKeys(username);
//        App.driver.findElement(By.name("acctid")).sendKeys(uid);
//        App.driver.findElement(By.name("mobile")).sendKeys(phone);
//        return this;
//    }

    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.linkText("删除");


    public ContactPage(RemoteWebDriver driver){
        super(driver);
    } //调用父类构造方法，初始化driver

    public ContactPage(){
        super();
    } //调用父类构造方法，初始化driver


    public ContactPage addMember(String username,String acctid,String mobile){
        while (driver.findElements(this.username).size()==0){
            click(addMember);
        }

        sendKeys(this.username,username);
        sendKeys(By.name("addtic"),acctid);
        sendKeys(By.name("mobile"),mobile);
        click(By.cssSelector(".js_btn_save"));
        return this;

    }

    public ContactPage search(String keyword){
        sendKeys(By.id("memberSearchInput"),keyword);
        return this;
    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }

    public ContactPage delete(){
        click(delete);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));
        return this;
    }

    public ContactPage importFromFile(URL path) {
        System.out.println(path.getPath());

        String path_utf="";
        try {
            path_utf= URLDecoder.decode(path.getFile(),"UTF-8");
            System.out.println(path_utf);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        upload(By.name("file"),path_utf);
        click(By.linkText("导入"));
        click(By.linkText("完成"));
        return this;

    }

    public DepartPage toDepart(){
        click(By.xpath("//li/a/span"));
        return new DepartPage(driver);
    }
}
