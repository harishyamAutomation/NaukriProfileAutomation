package api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import core.PropertyReader;
import io.restassured.response.Response;

public class RestResource {

	public static Response postAccount() {
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("username", PropertyReader.getProperty("username"));
		requestBody.put("password", "password");
		return given(SpecBuilder.getAccountRequestSpec())
				.body(requestBody)
				.when().post(Routes.LOGIN)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract().response();
	}

	public static Response naukriGet(String path) {
		return given(SpecBuilder.getDefaultRequestSpec())
				.when().get(path)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract().response();
	}

	public static Response naukriGet(String path, Map<String, String> queryParams) {
		return given(SpecBuilder.getDefaultRequestSpec())
				.queryParams(queryParams)
				.when().get(path)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract().response();
	}

	public static Response naukriPost(String path, Object requestBody) {
		return given(SpecBuilder.getDefaultRequestSpec())
				.body(requestBody)
				.when().post(path)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract().response();
	}

	public static Response naukriPut(String path, Object requestBody) {
		return given(SpecBuilder.getPutWrappertRequestSpec())
				.body(requestBody)
				.when().post(path)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract().response();
	}
}
