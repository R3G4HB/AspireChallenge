package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

public class ReportListener implements ITestListener, IAnnotationTransformer {

  @Override
  public void onTestStart(ITestResult result) {
    String testName = result.getName();
    Reporter.log(testName + " - Test Started.");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    String testName = result.getName();
    Reporter.log(testName + " - Test Success.");
  }

  public void onTestFailure(ITestResult result) {
    String testName = result.getName();
    CommonFunctionsUtil.captureScreenshot();
    Reporter.log(testName + " - Test Failed.");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    String testName = result.getName();
    Reporter.log(testName + " - Test Skipped.");
  }

  @Override
  @SuppressWarnings("rawtypes")
  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    annotation.setRetryAnalyzer(RetryUtil.class);
  }

}
