package ng.bayue.generator.config;

import java.util.Properties;

public abstract class AbstractContext {

	private PropertiesConfigLoader loader;

	public PropertiesConfigLoader getLoader() {
		return loader;
	}

	public void setLoader(PropertiesConfigLoader loader) {
		this.loader = loader;
	}

	public Properties getProp() {
		return PropertiesConfigLoader.getProperties();
	}

}
