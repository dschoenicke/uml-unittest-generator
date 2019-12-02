package test;

/**
 * Determines the type of a {@link TestAssertion}.
 * 
 * @author dschoenicke
 *
 */
public enum TestAssertionType {

	CLASSEXISTS,
	COUNT,
	HASCONSTRUCTOR,
	HASENUMCONSTANT,
	HASFIELD,
	HASMETHOD,
	HASNESTHOST,
	HASSUPERCLASS,
	HASSUPERINTERFACE,
	HASTEMPLATEPARAMETER,
	HASTYPE,
	ISCLASS,
	ISENUMERATION,
	ISINTERFACE,
	MODIFIERS;
}
