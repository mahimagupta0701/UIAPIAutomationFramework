
package apistepdefinitions;

import clients.PetClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.APIUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class PetStepDefs {

    Response response;

    @Given("I create a pet with name {string}, category {string}, photoUrl {string}, tag {string}, status {string}")
    public void i_create_a_pet(String name, String category, String photoUrl, String tag, String status) {
        String rawPayload = APIUtils.loadPayload("src/test/resources/payloads/pet.json");
        String finalPayload = APIUtils.replacePayloadPlaceholders(rawPayload, name, category, photoUrl, tag, status);
        PetClient petClient = new PetClient();
        System.out.println(finalPayload);
        response = petClient.createPet(finalPayload);
        System.out.println(response.toString());
    }


    @Given("I get the pet with ID {int}")
    public void i_get_the_pet_with_id(Integer petId) {
        response = given()
                .baseUri("https://petstore3.swagger.io/api/v3")
                .accept("application/json")
                .when()
                .get("/pet/" + petId);
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
        System.out.println("Response Body:\n" + response.getBody().asString());
    }

    @Given("I update the pet with ID {int} to have name {string}, category {string}, photoUrl {string}, tag {string}, status {string}")
    public void i_update_the_pet_with_id_to_have_details(Integer id, String name, String category, String photoUrl, String tag, String status) {
        // Load the payload from pet.json
        String jsonPayload = APIUtils.readJsonFromFile("src/test/resources/payloads/pet.json");

        // Replace placeholders dynamically
        jsonPayload = jsonPayload
                .replace("\"id\": 10", "\"id\": " + id)
                .replace("\"name\": \"doggie\"", "\"name\": \"" + name + "\"")
                .replace("\"name\": \"Dogs\"", "\"name\": \"" + category + "\"") // nested category
                .replace("http://image.jpg", photoUrl)
                .replace("\"name\": \"friendly\"", "\"name\": \"" + tag + "\"") // nested tag
                .replace("\"status\": \"available\"", "\"status\": \"" + status + "\"");

        // Send PUT request
        response = RestAssured
                .given()
                .baseUri("https://petstore3.swagger.io")
                .basePath("/api/v3/pet")
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .body(jsonPayload)
                .when()
                .put()
                .then()
                .extract()
                .response();
    }
    @Given("I delete the pet with ID {int}")
    public void i_delete_the_pet_with_id(Integer petId) {
        response = given()
                .baseUri("https://petstore3.swagger.io/api/v3")
                .when()
                .delete("/pet/" + petId)
                .then()
                .extract()
                .response();
    }





}
