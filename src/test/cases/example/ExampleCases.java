package test.cases.example;

import org.openqa.selenium.WebDriver;

import com.zongrong.web.Assert;
import com.zongrong.web.TestBase;
import com.zongrong.web.annotation.After;
import com.zongrong.web.annotation.Before;
import com.zongrong.web.annotation.BeforeClass;
import com.zongrong.web.annotation.Test;
import com.zongrong.web.data.ParaData;

import test.task.example.ExampleTasks;
import test.task.login.LoginTasks;

/**
 * 测试用例举例
 * @author zongrong_liang
 *
 */
public class ExampleCases extends TestBase{
	WebDriver driver=null;
	LoginTasks taskLogin=null;
	ExampleTasks taskExample=null;
	String dataFile="data/example/example.properties";
	
	@BeforeClass
	public void initClass(){
		ParaData.initPropertiesFile(this.dataFile);
	}	
	@Before
	public void init(){
		driver=getWebDriver();
		taskLogin=new LoginTasks(driver);
		taskExample=new ExampleTasks(driver);
	}
	@After
	public void clean(){
		//关闭浏览器
		driver.quit();
	}
		
	/*
	 * 测试用例:新建一个Repository
	 */
	@Test
	public void testCreateRepository(){
		//打开gethub登录界面并登录
		taskLogin.loginWeb();
		//点击新建Repository的【new】按钮
		taskExample.clickNewRepository();
		//输入Repository的name
		taskExample.intputRepositoryName(ParaData.getData("repositoryName"));
		//输入Repository的描述内容
		taskExample.intputRepositoryDesc(ParaData.getData("description"));
		//选择repository属性为private
		taskExample.selectVisibility_private();
        //点击创建按钮
		taskExample.clickCreateBtn();
		//验证新建成功，取setting页面的repositoryname与新建时输入的名称比较
		taskExample.intoSettings_page();
		String repositoryName=taskExample.getRepositoryName();
		System.out.println(repositoryName);
		Assert.assertEquals(ParaData.getData("repositoryName"),repositoryName);
		Assert.assertTrue(true);
	}
	/*
	 * 测试用例：删除repository
	 */
	@Test
	public void  testDeleteRepository(){
		taskLogin.loginWeb();
		//点击名为“testlzr”的repository
		taskExample.clickRepository_testlzr();
		//进入设置页面
		taskExample.intoSettings_page();
		String repositoryName=taskExample.getRepositoryName();
		//删除repository
		taskExample.deleteRepository(repositoryName);
	}
	
	public static void main(String[] args) {
		ExampleCases ec=new ExampleCases();
		//新建repository
		ec.addTestCase("testCreateRepository");
		//删除repository
		ec.addTestCase("testDeleteRepository");
		ec.run();
	}
}
