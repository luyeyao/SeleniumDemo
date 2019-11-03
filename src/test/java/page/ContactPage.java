package page;

import org.openqa.selenium.By;

public class ContactPage {
    //进入通讯录页面就需要find再click，find，click需要driver对象
    public ContactPage add(String username,String uid,String phone){
        App.driver.findElement(By.name("username")).sendKeys(username);
        App.driver.findElement(By.name("acctid")).sendKeys(uid);
        App.driver.findElement(By.name("mobile")).sendKeys(phone);
        return this;
    }

    public void and(){

    }
}
