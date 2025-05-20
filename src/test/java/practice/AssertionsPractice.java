package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sample() 
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		/*if(1==1)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
		Assert.assertEquals(0, 1);
		
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
	}
	@Test
	public void samplesoft() 
	{
		SoftAssert sa= new SoftAssert();
		
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
			
		sa.assertEquals(0, 1);//fail
			
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
		
		sa.assertAll();//log

	}
}
