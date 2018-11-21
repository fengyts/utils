package ng.bayue.generator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertieUtil {

	private Properties props;

	public PropertieUtil(String filePath) throws Exception {
		this.props = initProp(filePath);
	}

	public PropertieUtil(Properties props) {
		this.props = props;
	}

	private Properties initProp(String filePath) throws Exception {
		File file = new File(filePath);
		return initProp(file);
	}

	private Properties initProp(File propertieFile) throws Exception {
		Properties prop = new Properties();
		InputStream inStream = new FileInputStream(propertieFile);
		prop.load(inStream);
		inStream.close();
		return prop;
	}

	public String getValue(String key) {
		return props.getProperty(key);
	}

}
