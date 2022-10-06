package ru.netology.rest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MobileBankApiTestJ1 {

    @Test
    void shouldReturnDemoId() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", hasSize(3))
                .body("[1].currency", equalTo("USD"))
        ;
    }
}
