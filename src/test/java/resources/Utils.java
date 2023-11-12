package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlace;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    RequestSpecification reqSpec;
    public RequestSpecification getRequestSpecification(AddPlace payload) throws IOException {
        return reqSpec = new RequestSpecBuilder()
                .setBaseUri(getGlobalVariable("baseURI"))
                .setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123")
                .setBody(payload)
                .build();
    }

    public String getGlobalVariable(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/GlobalVriables.properties");
        properties.load(fileInputStream);
        return  properties.getProperty(key);
    }




}
