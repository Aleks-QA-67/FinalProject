package api;

import common.TestConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import javax.swing.text.DefaultStyledDocument;

import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;

public class RestApiBuilder {

    public static RequestSpecification auth() {
        return new RequestSpecBuilder()
                .setBaseUri(TestConfig.getApiBaseUrl())
                .setContentType(String.valueOf(DefaultStyledDocument.ElementSpec.ContentType))
                .setAuth(RestAssured.preemptive().basic(
                        TestConfig.getAdminLogin(),
                        TestConfig.getAdminPassword()))
                .addFilter(new AllureRestAssured())
                .build();
    }
}