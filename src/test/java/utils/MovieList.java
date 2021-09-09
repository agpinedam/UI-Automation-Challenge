package utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import models.ListRequest;

import javax.xml.ws.Response;

import static io.restassured.path.json.JsonPath.given;

public class MovieList {
    /*
    public void createList() {
        String json = createRequest();
        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("/list?api_key="+apikey+"&session_id="+sessionId)
                .then()
                .extract()
                .response();
    }
    private String createRequest(){
        ListRequest listRequest = new ListRequest("List from java "
                , new Faker().letterify("random ??????? description ??????? ??????????")
                , "en");
        return new Gson().toJson(listRequest);
    }

         */
}
