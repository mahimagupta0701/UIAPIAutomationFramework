
package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class PetClient {

    private final String baseUrl = "https://petstore3.swagger.io/api/v3";

    public Response createPet(String payload) {
        return given()
                .baseUri(baseUrl)
                .basePath("/pet")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payload)
                .when()
                .post();
    }
}
