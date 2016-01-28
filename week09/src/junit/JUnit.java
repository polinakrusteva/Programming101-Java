package junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JUnit {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> a = Tests.class;
		Method[] allMethods = a.getDeclaredMethods();
		List<Method> testAnnotatedMethods = new ArrayList<Method>();
		
		for(Method method : allMethods){
			if(method.isAnnotationPresent(Test.class)){
				testAnnotatedMethods.add(method);
			}
		}
		
		Tests obj = new Tests();
		
		for(Method method : testAnnotatedMethods){
			method.invoke(obj);
		}
	}

}