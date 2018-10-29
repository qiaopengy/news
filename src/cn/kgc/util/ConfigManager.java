package cn.kgc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取数据库属性文件，获得数据库连接信息
public class ConfigManager {

	// 让用户只能创建一个ConfigManager? 单例模式
	private Properties properties = null;

	private static ConfigManager configManager;

	// 构造方法
	private ConfigManager() {
		// 这是构造内的语句，只要new了这个类，就一定会执行

		// 指定配置文件的路径
		String configFile = "database.properties";
		// 创建输入流，调用ConfigManager类的class的获取class载入方法并把配置文件信息转成流
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		// 创建一个properties对象
		properties = new Properties();
		try {
			// 调用properties对象的load方法，把这个流载入properties对象内。
			properties.load(is);
			// 载入后流就可以关闭了
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 提供给用户一个唯一的ConfigManager对象
	public static synchronized ConfigManager getInstence() {

		// 如果是空则创建一个新的configManager对象,同时也会执行构造内的方法
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		// 只要不是空，就一直会返回已有的这个对象，实现了单例
		return configManager;
	}

	// 载入了流的peoperties对象就可以通过getProperty的方法，传入键，而返回值
	public String getString(String key) {
		return properties.getProperty(key);
	}
}
