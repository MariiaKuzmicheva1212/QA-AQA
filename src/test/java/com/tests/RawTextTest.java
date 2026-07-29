package com.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RawTextTest {


        @Test
        public void testPostRequest() {
            RestAssured.baseURI = "https://postman-echo.com";

            String requestBody = "This is expected to be sent back as part of response body.";

            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/post")
                    .then()
                    .extract().response();

            Assert.assertEquals(response.getStatusCode(), 200, "Статус код не 200");

            Assert.assertNotNull(response.getBody().asString(), "Тело ответа пустое");

            String dataValue = response.jsonPath().getString("data");
            Assert.assertEquals(dataValue, requestBody, "data не совпадает с отправленным текстом");

            Assert.assertNull(response.jsonPath().get("json"), "json должен быть null");

            String host = response.jsonPath().getString("headers.host");
            Assert.assertNotNull(host, "Заголовок host отсутствует");
            Assert.assertEquals(host, "postman-echo.com", "host не совпадает");

            String contentType = response.jsonPath().getString("headers.content-type");
            Assert.assertNotNull(contentType, "content-type отсутствует в заголовках");
            Assert.assertEquals(contentType, "application/json", "content-type не совпадает");

            String contentLength = response.jsonPath().getString("headers.content-length");
            Assert.assertNotNull(contentLength, "content-length отсутствует");
            Assert.assertEquals(contentLength, String.valueOf(requestBody.length()),
                    "content-length не совпадает с длиной отправленного текста");

            String url = response.jsonPath().getString("url");
            Assert.assertEquals(url, "https://postman-echo.com/post", "URL в ответе не совпадает");

            Assert.assertNotNull(response.jsonPath().get("args"), "Поле args отсутствует");
            Assert.assertNotNull(response.jsonPath().get("data"), "Поле data отсутствует");
            Assert.assertNotNull(response.jsonPath().get("files"), "Поле files отсутствует");
            Assert.assertNotNull(response.jsonPath().get("form"), "Поле form отсутствует");
            Assert.assertNotNull(response.jsonPath().get("headers"), "Поле headers отсутствует");
            Assert.assertNotNull(response.jsonPath().get("url"), "Поле url отсутствует");

            Assert.assertFalse(dataValue.isEmpty(), "data пустая строка");

            Assert.assertTrue(dataValue.contains("expected to be sent back"),
                    "data не содержит ожидаемый текст");

            System.out.println("Все проверки успешно пройдены!");
            System.out.println("Отправленный текст: " + requestBody);
            System.out.println("Ответ: " + response.getBody().asPrettyString());
        }
    }