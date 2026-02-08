package core;

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
			InputStream propertyFile = new FileInputStream("src/main/config.properties");
			Properties properties = new Properties();
			properties.load(propertyFile);
			propertyValue = properties.getProperty(key);
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
