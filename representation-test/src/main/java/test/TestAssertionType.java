package test;

/**
 * Determines the type of a {@link TestAssertion}.
 * 
 * @author dschoenicke
 *
 */
public enum TestAssertionType {

	CLASSEXISTS,
	MODIFIERS,
	ISCLASS,
	ISINTERFACE,
	ISENUMERATION,
	HASCONSTRUCTOR,
	HASFIELD,
	HASMULTIPLICITY,
	HASMETHOD,
	HASPARAMETER,
	HASRETURNTYPE,
	HASTEMPLATEPARAMETER;
}
