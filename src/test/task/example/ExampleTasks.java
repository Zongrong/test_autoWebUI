package test.task.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zongrong.web.TaskBase;
import com.zongrong.web.data.PageObject;
import com.zongrong.web.data.PageObject.With;

public class ExampleTasks extends TaskBase{
	WebDriver driver=null;
	PageObject obj=null;	
	String dataFile="obj/example/example.properties";
	
	public ExampleTasks(WebDriver driver){
		this.driver=driver;
		obj=new PageObject(driver, dataFile);
	}
	
	/**
	 * ����½�repository��ť��new��
	 */
	public void clickNewRepository(){
		obj.getObjectByKey("example_newButton_xpath").click();
	}
	/**
	 * ��������Ѵ��ڵ�repository,"testlzr"
	 */
	public void clickRepository_testlzr(){
		obj.getObjectByKey("example_Repository_testlzr_xpath").click();
	}
	/**
	 * ����repository������ҳ��
	 */
	public void intoSettings_page(){
		obj.getObjectByKey("example_repository_setting_xpath").click();
	}
	/**
	 * ���롰testlzr����repository�У���ȡ�ø�repository��name
	 */
	public String getRepositoryName(){
		String name=obj.getObjectByKey(With.id,"example_repositorySetting_RepositoryName_id").getAttribute("value");		
		return name;
	}
	/**
	 * ɾ��Repository
	 */
	public void deleteRepository(String repositoryName){
		obj.getObjectByKey("example_deleteRepository_button_xpath").click();;
		obj.getObjectByKey("example_deleteRepositoryName_xpath").sendKeys(repositoryName);
		obj.getObjectByKey("example_deleteRepository_confirmButton_xpath").submit();
	}
	
	//=========================================================================//
	//                     "�½�repository"�����еĲ���                                                 //
	//=========================================================================//
	/**
	 * �½�repository������repository name
	 */
	public void intputRepositoryName(String name){
		obj.getObjectByKey(With.id,"example_create_repositoryName_id").sendKeys(name);
	}
	/**
	 * �½�repository,����description
	 */
	public void intputRepositoryDesc(String desc){
		obj.getObjectByKey(With.id, "example_create_repositoryDesc_id").sendKeys(desc);
	}
	/**
	 * �½�repository��ѡ��private����
	 */
	public void selectVisibility_private(){
		obj.getObjectByKey(With.id, "example_create_repositoryVisibility_id").click();
	}
	
	/**
	 * �½�repository�������create repository����ť
	 */
	public void clickCreateBtn(){
		obj.getObjectByKey("example_createRepository_button_xpath").submit();
	}

}
