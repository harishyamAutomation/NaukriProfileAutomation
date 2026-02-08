package api;

import java.util.HashMap;
import java.util.Map;

import core.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	private static String ACCESS_TOKEN = TokenManager.getToken();

	public static Map<String, String> defaultHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("accept", "application/json");
		headers.put("appid", "105");
		headers.put("authorization", "Bearer " + ACCESS_TOKEN);
		headers.put("content-type", "application/json");
		headers.put("systemid", "Naukri");
		return headers;
	}

    public static Map<String, String> putWrapperHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("accept", "application/json");
		headers.put("appid", "105");
		headers.put("authorization", "Bearer " + ACCESS_TOKEN);
		headers.put("content-type", "application/json");
		headers.put("systemid", "Naukri");
        headers.put("x-http-method-override", "PUT");
		return headers;
	}

    public static Map<String, String> accountHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("accept", "application/json");
		headers.put("appid", "103");
		headers.put("content-type", "application/json");
		headers.put("systemid", "jobseeker");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36");
		return headers;
	}

	public static RequestSpecification getAccountRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(PropertyReader.getProperty("baseURI"))
				.addHeaders(accountHeaders())
                .log(LogDetail.ALL)
				.build();
	}

    public static RequestSpecification getDefaultRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(PropertyReader.getProperty("baseURI"))
				.addHeaders(defaultHeaders())
                .log(LogDetail.ALL)
				.build();
	}

    public static RequestSpecification getPutWrappertRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(PropertyReader.getProperty("baseURI"))
				.addHeaders(putWrapperHeaders())
                .log(LogDetail.ALL)
				.build();
	}

	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder()
				.log(LogDetail.ALL)
				.build();
	}
}
