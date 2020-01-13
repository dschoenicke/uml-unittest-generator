package outputjunit.testobjects.converter;

import java.util.ArrayList;

import outputjunit.testobjects.JunitTestConstructor;
import outputjunit.testobjects.JunitTestParameter;
import test.testobjects.ClassUnderTest;
import test.testobjects.ConstructorUnderTest;
import test.testobjects.ParameterUnderTest;

public class ConstructorConverter {

	public static ArrayList<JunitTestConstructor> convertConstructors(ClassUnderTest classUnderTest) {
		ArrayList<JunitTestConstructor> constructors = new ArrayList<>();
		
		for (ConstructorUnderTest constructor : classUnderTest.getConstructors()) {
			JunitTestConstructor junitTestConstructor = new JunitTestConstructor(constructor.getModifiers());
			
			for (ParameterUnderTest parameter : constructor.getParameters()) {
				junitTestConstructor.addParameter(new JunitTestParameter(parameter.getName(), parameter.getType(), parameter.getModifiers()));
			}
			
			constructors.add(junitTestConstructor);
		}
		
		return constructors;
	}
}
