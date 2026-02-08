package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println(">>> Under RetryListener -> Transform method");

		if (testAnnotation.getRetryAnalyzerClass() == null) {
			System.out.println("Under RetryListener -> condition");
			testAnnotation.setRetryAnalyzer(FailRetry.class);
		} else {
			testAnnotation.setRetryAnalyzer(FailRetry.class);
		}
	}
}
