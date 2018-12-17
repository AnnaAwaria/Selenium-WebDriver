package com.capgemini.tests.rest;

import com.capgemini.tests.rest.model.Pet;
import com.capgemini.tests.rest.testdata.PetGenerator;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CrudPetRestApiTest {

    private Pet pet;

    @BeforeMethod
    public void createPet(){
        pet = PetGenerator.getPet();
    }


    @Test
    public void firstRestApiTest() {

        JsonPath response = given()
                .log()
                .all()
                .contentType("application/json")
                .body(pet)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        assertThat(response.getLong("id")).isEqualTo(pet.getId());
        assertThat(response.getString("name")).isEqualTo(pet.getName());

        System.out.println(response.prettyPrint());

        pet.setName("KIŁA");

        JsonPath responsePut = given()
                .log()
                .all()
                .contentType("application/json")
                .body(pet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        System.out.println(responsePut.prettyPrint());


        JsonPath responseForGet = given()
                .log()
                .all()
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + pet.getId())
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        assertThat(responseForGet.getString("name")).isEqualTo(pet.getName());

        System.out.println(responseForGet.prettyPrint());


        given()
                .log()
                .all()
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + pet.getId())
                .then()
                .assertThat()
                .statusCode(200);

        JsonPath responseForGetAfterDelete = given()
                .log()
                .all()
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + pet.getId())
                .then()
                .assertThat()
                .statusCode(404)
                .extract()
                .body()
                .jsonPath();

        System.out.println(responseForGetAfterDelete.prettyPrint());

    }

}