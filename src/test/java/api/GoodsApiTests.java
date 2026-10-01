package api;

import api.GoodsApi;
import api.ApiAssert;
import common.TestConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static api.ApiAssert.assertThat;

@Epic("API")
@Feature("Goods")
public class GoodsApiTests {

    private final GoodsApi goodsApi = new GoodsApi();

    @BeforeAll
    static void printConfig() { TestConfig.printConfig(); }

    @Test
    @Tag("smokeApi")
    @DisplayName("GET /goods/list")
    void listGoods() {
        assertThat(goodsApi.list(0, 10)).statusCode(200);
    }

    @Test
    @Tag("smokeApi")
    @DisplayName("POST /goods/add")
    void addGoods() {
        String name = "API " + System.currentTimeMillis();
        Response r = goodsApi.add(name, 999);
        assertThat(r).statusCode(200).fieldEquals("name", name);
    }

    @Test
    @DisplayName("GET /goods/{id} — 404")
    void getByIdNotFound() {
        assertThat(goodsApi.getById(999999)).statusCode(404);
    }
}