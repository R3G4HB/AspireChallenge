package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtil implements IRetryAnalyzer {
    private static int count = 1;
    private static String retryCountStr = BaseUtil.propMap.get("retryCount");;
    private static int retryCount = Integer.parseInt(retryCountStr);

    @Override
    public boolean retry(ITestResult result) {
       while(count<=retryCount) {
           count++;
           return true;
       }
       return false;
    }
    
}
