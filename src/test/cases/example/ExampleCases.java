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
 * ������������
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
		//�ر������
		driver.quit();
	}
		
	/*
	 * ��������:�½�һ��Repository
	 */
	@Test
	public void testCreateRepository(){
		//��gethub��¼���沢��¼
		taskLogin.loginWeb();
		//����½�Repository�ġ�new����ť
		taskExample.clickNewRepository();
		//����Repository��name
		taskExample.intputRepositoryName(ParaData.getData("repositoryName"));
		//����Repository����������
		taskExample.intputRepositoryDesc(ParaData.getData("description"));
		//ѡ��repository����Ϊprivate
		taskExample.selectVisibility_private();
        //���������ť
		taskExample.clickCreateBtn();
		//��֤�½��ɹ���ȡsettingҳ���repositoryname���½�ʱ��������ƱȽ�
		taskExample.intoSettings_page();
		String repositoryName=taskExample.getRepositoryName();
		System.out.println(repositoryName);
		Assert.assertEquals(ParaData.getData("repositoryName"),repositoryName);
		Assert.assertTrue(true);
	}
	/*
	 * ����������ɾ��repository
	 */
	@Test
	public void  testDeleteRepository(){
		taskLogin.loginWeb();
		//�����Ϊ��testlzr����repository
		taskExample.clickRepository_testlzr();
		//��������ҳ��
		taskExample.intoSettings_page();
		String repositoryName=taskExample.getRepositoryName();
		//ɾ��repository
		taskExample.deleteRepository(repositoryName);
	}
	
	public static void main(String[] args) {
		ExampleCases ec=new ExampleCases();
		//�½�repository
		ec.addTestCase("testCreateRepository");
		//ɾ��repository
		ec.addTestCase("testDeleteRepository");
		ec.run();
	}
}
