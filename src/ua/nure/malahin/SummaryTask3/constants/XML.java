package ua.nure.malahin.SummaryTask3.constants;

/**
 * Holds entities declared in XSD document.
 * 
 * @author S.Malahin
 *
 */
public enum XML {
	// elements names
    	WEAPON("Weapon"),
	KNIFE("Knife"), TYPE("Type"), HANDY("Handy"), 
	ORIGIN("Origin"), VISUAL("Visual"), WIDTH("Width"),
	SIZE("Size"), MATERIAL("Material"), HAFT("Haft"),
	TYPEWOOD("typeWood"), KROVOSTOK("Krovostok"), VALUE("Value");

	private String value;

	XML(String value) {
		this.value = value;
	}
	
	/**
	 * Determines if a name is equal to the string value wrapped by this enum element.<br/>
	 * If a SAX/StAX parser make all names of elements and attributes interned you can use
	 * <pre>return value == name;</pre> instead <pre>return value.equals(name);</pre>
	 * @param name string to compare with value. 
	 * @return value.equals(name)
	 */
	public boolean equalsTo(String name) {
		return value.equals(name);
	}

	public String value() {
		return value;
	}
}
