package junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JUnit {

	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> a = Tests.class;
		Method[] allMethods = a.getDeclaredMethods();

		Tests obj = new Tests();

		for (Method method : allMethods) {
			if (method.isAnnotationPresent(Test.class)) {
				method.invoke(obj);
				System.out.println(method.getName() + " passed successfully!");
			}
		}
	}
}