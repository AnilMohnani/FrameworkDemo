
package testcases;		

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;

import resources.Base;		

public class ListenerTest extends Base implements ITestListener						
{		Base b=new Base();
     
    		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    		
    public void onTestFailure(ITestResult result) {
		//screenshot
    	Calendar calender=Calendar.getInstance();
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");	   
    	
		try {
			b.getScreenshot(result.getName() +  formater.format(calender.getTime()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    		
    public void onTestSkipped(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestStart(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
    }		
}