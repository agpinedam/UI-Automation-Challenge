package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetData {
    private static GetData getData;
    private String domain;
    private String user;
    private String validPassword;
    private String invalidPassword;

    private void readCredentials () throws IOException {
        FileInputStream file = new FileInputStream(".\\src\\test\\java\\resources\\Environment.properties");
        Properties properties = new Properties();
        properties.load(file);
        domain = properties.getProperty("domain");
        user = properties.getProperty("user");
        validPassword = properties.getProperty("validPassword");
        invalidPassword = properties.getProperty("invalidPassword");
    }
    public static GetData getInstance() throws IOException{
        if(getData ==null){
            getData = new GetData();
            getData.readCredentials();
        }
        return getData;
    }
    public String getDomain(){return domain;}
    public String getUser(){return user;}
    public String getValidPassword(){return validPassword;}
    public String getInvalidPassword(){return invalidPassword;}
}
