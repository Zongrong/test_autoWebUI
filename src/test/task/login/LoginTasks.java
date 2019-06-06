package test.task.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.zongrong.web.TaskBase;
import com.zongrong.web.data.PageObject;
import com.zongrong.web.data.PageObject.With;
import com.zongrong.web.data.ParaData;

public class LoginTasks extends TaskBase{
	WebDriver driver=null;
	PageObject obj=null;	
	String dataFile="obj/login/login.properties";
	
	public LoginTasks(WebDriver driver){
		this.driver=driver;
		obj=new PageObject(driver,dataFile);
	}
	
	/**
	 * ��¼��վ:ָ����ַ���˺š�����
	 * @param url
	 * @param account
	 * @param password
	 */
	public void loginWeb(String url,String account,String password){
		try {
			driver.get(url);//���ߣ�driver.navigate().to(url);
			obj.getObjectByKey(With.id,"login_userName_id").sendKeys(account);
			obj.getObjectByKey(With.id,"login_password_id").sendKeys(password);
			obj.getObjectByKey("login_button_xpath").click();			
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * ��¼��վ��Ĭ����ַ���˺š�����
	 */
	public void loginWeb(){
		try {
			driver.get(ParaData.getSysData("mgtURL"));
			obj.getObjectByKey(With.id,"login_userName_id").sendKeys(ParaData.getSysData("login_account"));
			obj.getObjectByKey(With.id,"login_password_id").sendKeys(ParaData.getSysData("login_password"));
			obj.getObjectByKey("login_button_xpath").click();			
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}
