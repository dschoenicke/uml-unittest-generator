package outputjunit.testmethod;

import test.testobjects.ClassUnderTest;

public class TemplateParameterTestConverter {

	public static String createTestClassTemplateParameterTests(ClassUnderTest classUnderTest) {
		String templateParameterTestString = "\n\t@Test\n"
				+ "\tpublic void testClassTemplateParameters() {\n"
				+ "\t\tassertEquals(" + classUnderTest.getTemplateParameters().size() + ", classUnderTest.getTypeParameters().length, "
				+ "\"" + classUnderTest.getQualifiedName() + " is expected to have exactly " + classUnderTest.getTemplateParameters().size() + " template parameters!\");\n"
				+ "\t\t//TODO: Check template parameter names and upper bounds\n";
		
		return templateParameterTestString + "\t}\n";
	}
}
