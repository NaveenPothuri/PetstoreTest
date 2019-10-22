package org.pstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.pstore.classes.StatusEnum;

import static io.restassured.RestAssured.given;
import static org.pstore.Constants.BASE_URL;
import static org.pstore.PetActions.PET_ENDPOINT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;



public class PetTest {

 RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL).build();
            
  
 
 @Test
    public void addNewPet() {
    
        given(requestSpecification)
                .body("{\n" +
                        "  \"id\": 89898888,\n" +
                        "  \"name\": \"MyLittlePet\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"" + StatusEnum.pending.toString() + "\"\n" +
                        "}")
                .post(PET_ENDPOINT);

        given(requestSpecification)
                .pathParam("petId", "89898888")
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body("name", equalTo("MyLittlePet"))
                .extract().body().jsonPath()
                .prettyPrint();
    }
         
     
    @Test
    public void updateExistingPet() {
        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 499278344,\n" +
                        "  \"name\": \"Fido6\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .put(PET_ENDPOINT);

        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("petId", "499278344")
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body("name", equalTo("Fido6"))
                .extract().body().jsonPath()
                .prettyPrint();
    }
    
    @Test
    public void deletePetById() {
        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .header("api_key", Authentication.Login("britka", "12345678"))
                .pathParam("petId", "898988888")
                .expect().statusCode(200)
                .when()
                .delete(PET_ENDPOINT + "/{petId}");

        Assert.assertEquals(
                given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("petId", "898988888")
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .extract().body().jsonPath().getObject("", MessageResponse.class)
                .getMessage(), "Pet not found");
    }
                
            
            
            
}
