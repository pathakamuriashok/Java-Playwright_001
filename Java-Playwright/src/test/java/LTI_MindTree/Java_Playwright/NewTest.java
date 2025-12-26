package LTI_MindTree.Java_Playwright;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
	  System.out.println("Am From :: ==> @Test");
	  System.out.println(n+"   "+s);
  } 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Am From :: ==> @BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Am From :: ==> @AfterMethod");
  }


  @DataProvider
  public Object[][] dp() {
	  System.out.println("Am From :: ==> @DataProvider");
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
    
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Am From :: ==> @BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Am From :: ==> @AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Am From :: ==> @BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Am From :: ==> @AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Am From :: ==> @BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Am From :: ==> @AfterSuite");
  }

}
