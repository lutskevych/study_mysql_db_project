package utils;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class DbProperties {
    private String url;
    private String userName;
    private String password;
    private String propertiesPath = "db.properties";
    private Properties properties = new Properties();
    private InputStream inputStream = null;

    public DbProperties() {
        loadProperties();
        initialiseFields();
    }

    private void loadProperties() {
        try {
            inputStream = DbProperties.class.getClassLoader().getResourceAsStream(propertiesPath);
            if (inputStream == null) {
                System.out.println("Unable to load " + propertiesPath);
            }
            properties.load(inputStream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initialiseFields() {
        url = properties.getProperty("db.url");
        userName = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
    }

}
