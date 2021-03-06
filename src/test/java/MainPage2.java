import org.junit.experimental.theories.Theories;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainPage2 {

    WebDriver driver;
    @Test
    public void login(){
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        try{
            Thread.sleep(15000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void loadCookie(WebDriver driver){
        try{
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line =bufferedReader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (dt.equals("null")){
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);//把string转换成data
                    expiry = sdf.parse(dt);
                }
                //stirng转换成boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
                driver.manage().addCookie(cookie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveCookie(WebDriver driver) {
        //每次只取一条cookie进行处理
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ';' +
                        cookie.getValue() + ";" +
                        cookie.getDomain() + ";" +
                        cookie.getPath() + ";" +
                        cookie.getExpiry() + ";" +
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
