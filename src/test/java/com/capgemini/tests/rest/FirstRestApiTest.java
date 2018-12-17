package com.capgemini.tests.rest;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class FirstRestApiTest {

    @Test
    public void firstRestApiTest() {

        JsonPath response = given()
                .log()
                .all()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 12345464565656,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"placuszek\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        assertThat(response.getLong("id")).isEqualTo(12345464565656L);
        assertThat(response.getString("name")).isEqualTo("placuszek");

        System.out.println(response.prettyPrint());


        JsonPath responsePut = given()
                .log()
                .all()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 12345464565656,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"pieseczek\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
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
                .get("https://petstore.swagger.io/v2/pet/12345464565656")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        assertThat(responseForGet.getString("name")).isEqualTo("pieseczek");

        System.out.println(responseForGet.prettyPrint());


        given()
                .log()
                .all()
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/12345464565656")
                .then()
                .assertThat()
                .statusCode(200);

        JsonPath responseForGetAfterDelete = given()
                .log()
                .all()
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/12345464565656")
                .then()
                .assertThat()
                .statusCode(404)
                .extract()
                .body()
                .jsonPath();

        System.out.println(responseForGetAfterDelete.prettyPrint());

    }

}