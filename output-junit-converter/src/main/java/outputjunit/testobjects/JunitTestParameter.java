package outputjunit.testobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JunitTestParameter {
	
	private String name;
	
	private String type;
	
	private int modifiers;
}
