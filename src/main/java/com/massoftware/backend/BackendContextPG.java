package com.massoftware.backend;

import java.io.File;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.cx.AbstractContext;
import org.dsw.jdbc.ConnectionWrapper;
import org.dsw.jdbc.DataSourceProperties;
import org.dsw.jdbc.DataSourceWrapper;

public class BackendContextPG extends AbstractContext {

	public final static String PG = "Postgresql";

	private DataSourceWrapper dataSourceWrapper;

	private static BackendContextPG backendContext;

	private String dbFilesPath;
	private String iconosPath;

	private BackendContextPG() {
		try {

			init();

		} catch (Exception e) {
			printFatal(e);
		}
	}

	public static synchronized BackendContextPG get() {
		if (backendContext == null) {
			backendContext = new BackendContextPG();
		}

		return backendContext;
	}

	public synchronized DataBase getDataBase() {
		return new DataBase(dataSourceWrapper, "geo");
	}

	public synchronized String getIconosPath() {
		return iconosPath;
	}

	// private Properties loadProperties() {
	//
	// Properties properties = new Properties();
	//
	// properties.put("jdbc.driverClassName", "org.postgresql.Driver");
	// properties.put("jdbc.userName", "postgres");
	// properties.put("jdbc.userPassword", "cordoba");
	// properties.put("jdbc.url",
	// "jdbc:postgresql://localhost:5432/massoftware?searchpath=massoftware");
	// properties.put("jdbc.maxActive", "10");
	// properties.put("jdbc.initialSize", "5");
	// properties.put("jdbc.maxIdle", "5");
	// properties.put("jdbc.validationQuery", "SELECT 1");
	// properties.put("jdbc.verbose", "true");
	// properties.put("file.path",
	// "D:\\dev\\source\\\\massoftware_front\\files_db");
	//
	// return properties;
	// }

	private void init() throws Exception {

		// massoftware.properties
		// Properties properties = loadProperties(
		// System.getProperty("user.dir") + File.separatorChar + "massoftware.conf");

		System.err.println("System.getProperty(\"user.dir\") " + System.getProperty("user.dir"));

		Properties properties = loadProperties("massoftware.properties");

		// -------------------------------------------------------------------

		dbFilesPath = properties.getProperty("file.path");

		iconosPath = dbFilesPath + File.separatorChar + "iconos";

		String path = "jdbc.";

		DataSourceProperties dataSourceProperties = new DataSourceProperties();

		dataSourceProperties.setDriverClassName(properties.getProperty(path + "driverClassName"));
		dataSourceProperties.setUrl(properties.getProperty(path + "url"));
		dataSourceProperties.setUserName(properties.getProperty(path + "userName"));
		dataSourceProperties.setUserPassword(properties.getProperty(path + "userPassword"));
		dataSourceProperties.setInitialSize(new Integer(properties.getProperty(path + "initialSize")));
		dataSourceProperties.setMaxActive(new Integer(properties.getProperty(path + "maxActive")));
		dataSourceProperties.setMaxIdle((new Integer(properties.getProperty(path + "maxIdle"))));
		dataSourceProperties.setValidationQuery(properties.getProperty(path + "validationQuery"));
		dataSourceProperties.setVerbose((new Boolean(properties.getProperty(path + "verbose"))));

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(dataSourceProperties.getDriverClassName());
		ds.setUrl(dataSourceProperties.getUrl());
		ds.setUsername(dataSourceProperties.getUserName());
		ds.setPassword(dataSourceProperties.getUserPassword());
		ds.setInitialSize(dataSourceProperties.getInitialSize());
		ds.setMaxActive(dataSourceProperties.getMaxActive());
		ds.setMaxIdle(dataSourceProperties.getMaxIdle());
		ds.setValidationQuery(dataSourceProperties.getValidationQuery());

		dataSourceWrapper = new DataSourceWrapper(ds, dataSourceProperties);

	}

	// ================================================================================
	
	public synchronized Object[][] find(String sql, Object[] args) throws Exception {

		if (args == null) {
			args = new Object[0];
		}

		ConnectionWrapper connectionWrapper = dataSourceWrapper.getConnectionWrapper();

		try {

			Object[][] table = null;

			if (args.length == 0) {
				table = connectionWrapper.findToTable(sql);
			} else {
				table = connectionWrapper.findToTable(sql, args);
			}

			// for (Object item : list) {
			// if (item instanceof Valuable) {
			// ((Valuable) item).validate();
			// }
			// }

			return table;

		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		} finally {
			connectionWrapper.close(connectionWrapper);
		}

	}


}
