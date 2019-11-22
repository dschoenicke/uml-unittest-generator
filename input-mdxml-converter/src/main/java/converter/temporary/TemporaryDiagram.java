package converter.temporary;

import java.util.LinkedHashSet;

import model.UmlDiagram;

public class TemporaryDiagram extends UmlDiagram {

	private LinkedHashSet<String> usedElements;
	
	public TemporaryDiagram(String name) {
		super(name);
		usedElements = new LinkedHashSet<>();
	}

	public LinkedHashSet<String> getUsedElements() {
		return usedElements;
	}

	public void addUsedElement(String element) {
		usedElements.add(element);
	}
}
