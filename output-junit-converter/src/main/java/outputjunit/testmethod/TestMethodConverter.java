package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;

public class TestMethodConverter {

	public static String createTestMethods(ClassUnderTest classUnderTest) {
		return 
				PropertyTestConverter.createTestClassPropertyTests(classUnderTest) + 
				RelationshipTestConverter.createTestClassRelationshipTests(classUnderTest) + 
				TemplateParameterTestConverter.createTestClassTemplateParameterTests(classUnderTest) +
				FieldTestConverter.createTestClassFieldTests(classUnderTest) +
				ConstructorTestConverter.createTestClassConstructorTests(classUnderTest) +
				MethodTestConverter.createTestClassMethodTests(classUnderTest);
	}
}
