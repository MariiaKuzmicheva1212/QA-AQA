package com.tests;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestWoopsTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "Статус код не 200");

        Assert.assertNotNull(response.getBody().asString(), "Тело ответа пустое");

        String foo1Value = response.jsonPath().getString("args.foo1");
        String foo2Value = response.jsonPath().getString("args.foo2");

        Assert.assertEquals(foo1Value, "bar1", "foo1 не равен bar1");
        Assert.assertEquals(foo2Value, "bar2", "foo2 не равен bar2");

        String url = response.jsonPath().getString("url");
        Assert.assertEquals(url, "https://postman-echo.com/get?foo1=bar1&foo2=bar2",
                "URL в ответе не совпадает");

        String host = response.jsonPath().getString("headers.host");
        Assert.assertNotNull(host, "Заголовок host отсутствует");
        Assert.assertEquals(host, "postman-echo.com", "host не совпадает");

        String contentType = response.getContentType();
        Assert.assertNotNull(contentType, "Content-Type отсутствует");

        Assert.assertNotNull(response.jsonPath().get("args"), "Поле args отсутствует");
        Assert.assertNotNull(response.jsonPath().get("headers"), "Поле headers отсутствует");
        Assert.assertNotNull(response.jsonPath().get("url"), "Поле url отсутствует");

        Assert.assertTrue(response.jsonPath().getMap("args").containsKey("foo1"),
                "args не содержит ключ foo1");
        Assert.assertTrue(response.jsonPath().getMap("args").containsKey("foo2"),
                "args не содержит ключ foo2");

        System.out.println("Все проверки успешно пройдены!");
        System.out.println("Ответ: " + response.getBody().asPrettyString());
    }
}