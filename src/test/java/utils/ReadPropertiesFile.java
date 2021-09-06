package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    private static ReadPropertiesFile readPropertiesFile;
    private String domain;
    private String user;
    private String validPassword;
    private String invalidPassword;

    private void readCredentials () throws IOException {
        FileInputStream file = new FileInputStream(".\\src\\test\\java\\resources\\Configuration.properties");
        Properties properties = new Properties();
        properties.load(file);
        domain = properties.getProperty("domain");
        user = properties.getProperty("user");
        validPassword = properties.getProperty("validPassword");
        invalidPassword = properties.getProperty("invalidPassword");
    }
    public static ReadPropertiesFile getInstance() throws IOException{
        if(readPropertiesFile==null){
            readPropertiesFile = new ReadPropertiesFile();
            readPropertiesFile.readCredentials();
        }
        return readPropertiesFile;
    }
    public String getDomain(){return domain;}
    public String getUser(){return user;}
    public String getValidPassword(){return validPassword;}
    public String getInvalidPassword(){return invalidPassword;}
}
