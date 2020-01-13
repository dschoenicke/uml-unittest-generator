package outputjunit.testobjects.converter;

import java.util.ArrayList;

import outputjunit.testobjects.JunitTestMethod;
import outputjunit.testobjects.JunitTestParameter;
import test.testobjects.ClassUnderTest;
import test.testobjects.MethodUnderTest;
import test.testobjects.ParameterUnderTest;

public class MethodConverter {

	public static ArrayList<JunitTestMethod> convertMethods(ClassUnderTest classUnderTest) {
		ArrayList<JunitTestMethod> methods = new ArrayList<>();
		
		for (MethodUnderTest method : classUnderTest.getMethods()) {
			JunitTestMethod junitTestMethod = new JunitTestMethod(method.getName(), method.getModifiers(), method.getReturnType().getType());
			
			for (ParameterUnderTest parameter : method.getParameters()) {
				junitTestMethod.addParameter(new JunitTestParameter(parameter.getName(), parameter.getType(), parameter.getModifiers()));
			}
			
			methods.add(junitTestMethod);
		}
		
		return methods;
	}
}
