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
	 * 点击新建repository按钮【new】
	 */
	public void clickNewRepository(){
		obj.getObjectByKey("example_newButton_xpath").click();
	}
	/**
	 * 点击进入已存在的repository,"testlzr"
	 */
	public void clickRepository_testlzr(){
		obj.getObjectByKey("example_Repository_testlzr_xpath").click();
	}
	/**
	 * 进入repository的设置页面
	 */
	public void intoSettings_page(){
		obj.getObjectByKey("example_repository_setting_xpath").click();
	}
	/**
	 * 进入“testlzr”的repository中，获取该该repository的name
	 */
	public String getRepositoryName(){
		String name=obj.getObjectByKey(With.id,"example_repositorySetting_RepositoryName_id").getAttribute("value");		
		return name;
	}
	/**
	 * 删除Repository
	 */
	public void deleteRepository(String repositoryName){
		obj.getObjectByKey("example_deleteRepository_button_xpath").click();;
		obj.getObjectByKey("example_deleteRepositoryName_xpath").sendKeys(repositoryName);
		obj.getObjectByKey("example_deleteRepository_confirmButton_xpath").submit();
	}
	
	//=========================================================================//
	//                     "新建repository"界面中的操作                                                 //
	//=========================================================================//
	/**
	 * 新建repository，输入repository name
	 */
	public void intputRepositoryName(String name){
		obj.getObjectByKey(With.id,"example_create_repositoryName_id").sendKeys(name);
	}
	/**
	 * 新建repository,输入description
	 */
	public void intputRepositoryDesc(String desc){
		obj.getObjectByKey(With.id, "example_create_repositoryDesc_id").sendKeys(desc);
	}
	/**
	 * 新建repository，选择private属性
	 */
	public void selectVisibility_private(){
		obj.getObjectByKey(With.id, "example_create_repositoryVisibility_id").click();
	}
	
	/**
	 * 新建repository，点击【create repository】按钮
	 */
	public void clickCreateBtn(){
		obj.getObjectByKey("example_createRepository_button_xpath").submit();
	}

}
