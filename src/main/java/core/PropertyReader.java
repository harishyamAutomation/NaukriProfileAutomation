package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String key) {
		String propertyValue = null;

		try {
			Properties properties = new Properties();

			// 1) Try external file at project root (src/main/config.properties)
			File external = new File("src/main/config.properties");
			if (external.exists()) {
				try (InputStream propertyFile = new FileInputStream(external)) {
					properties.load(propertyFile);
					propertyValue = properties.getProperty(key);
				}
			} else {
				// 2) Try classpath resource 'config.properties' (e.g. src/main/resources/config.properties)
				InputStream resourceStream = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties");
				if (resourceStream != null) {
					properties.load(resourceStream);
					propertyValue = properties.getProperty(key);
				} else {
					// 3) Fallback to example bundled with repo: 'config.properties.example' on classpath
					InputStream exampleStream = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties.example");
					if (exampleStream != null) {
						properties.load(exampleStream);
						propertyValue = properties.getProperty(key);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		return propertyValue;
	}

	public static void setProperty(String key, String value) {

		try {
			InputStream propertyFile = new FileInputStream("src/main/config.properties");
			Properties properties = new Properties();
			properties.load(propertyFile);
			properties.setProperty(key, value);
			OutputStream saveChanges = new FileOutputStream("src/main/config.properties");
			properties.store(saveChanges, "Value updated : " + value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
