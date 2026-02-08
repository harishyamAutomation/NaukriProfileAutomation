package api;

import static org.testng.Assert.assertEquals;

import io.restassured.response.Response;

public class TokenManager {

	public static String getToken() {
		Response response = RestResource.postAccount();
		assertEquals(response.getStatusCode(), 200);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		return loginResponse.getCookies().get(0).getValue();
	}
}
