package tools

class PropertyReader {

	static read(String path, String property) {
		final url = PropertyReader.getResource path
		final properties = new Properties()
		final propertiesFile = new File(url.toURI())
		propertiesFile.withInputStream { properties.load it }

		properties."$property"
	}
}
