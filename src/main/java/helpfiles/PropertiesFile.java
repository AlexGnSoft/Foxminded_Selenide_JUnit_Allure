package helpfiles;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    public static Properties properties;

    public PropertiesFile(){
        BufferedReader reader;
        String propertyFilePath = "src/main/java/helpfiles/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser is not specified in the config.properties file.");
    }

    public String getBrowserSize() {
        String browser_size = properties.getProperty("browser_size");
        if(browser_size != null) return browser_size;
        else throw new RuntimeException("browser_size is not specified in the config.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("browser is not specified in the config.properties file.");
    }

    public static String getLoginCredentials() {
        String login = properties.getProperty("login");
        if(login != null) return login;
        else throw new RuntimeException("login is not specified in the config.properties file.");
    }

    public static String getPasswordCredentials() {
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("password is not specified in the config.properties file.");
    }

    public String getDriverPathChrome(){
        String driverPath_Chrome = properties.getProperty("driverPath_Chrome");
        if(driverPath_Chrome!= null) return driverPath_Chrome;
        else throw new RuntimeException("driverPath for Chrome not specified in the config.properties file.");
    }

    public String getDriverPathFireFox(){
        String driverPath_Firefox = properties.getProperty("driverPath_Firefox");
        if(driverPath_Firefox!= null) return driverPath_Firefox;
        else throw new RuntimeException("driverPath for FireFox not specified in the config.properties file.");
    }

    public static long getImplicitWait() {
        String implicitWait = properties.getProperty("implicit_Wait");
        if(implicitWait != null) return Long.parseLong(implicitWait);
        else throw new RuntimeException("implicitlyWait is not specified in the config.properties file.");
    }

    public long getExplicitWait() {
        String explicitWait = properties.getProperty("explicit_Wait");
        if(explicitWait != null) return Long.parseLong(explicitWait);
        else throw new RuntimeException("explicitWait is not specified in the config.properties file.");
    }

    public static String getDataBaseUrl() {
        String db_url = properties.getProperty("db_host");
        if(db_url != null) return db_url;
        else throw new RuntimeException("database is not specified in the config.properties file.");
    }

    public static String getDataBasePort() {
        String db_port = properties.getProperty("db_port");
        if(db_port != null) return db_port;
        else throw new RuntimeException("database port is not specified in the config.properties file.");
    }

    public static String getDataBaseName() {
        String db_name = properties.getProperty("db_name");
        if(db_name != null) return db_name;
        else throw new RuntimeException("database name is not specified in the config.properties file.");
    }

    public String getDataBaseLogin() {
        String db_user = properties.getProperty("db_user");
        if(db_user != null) return db_user;
        else throw new RuntimeException("database login is not specified in the config.properties file.");
    }

    public String getDataBasePassword() {
        String db_password = properties.getProperty("db_password");
        if(db_password != null) return db_password;
        else throw new RuntimeException("database password is not specified in the config.properties file.");
    }
}
