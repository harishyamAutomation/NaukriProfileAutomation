package naukri.controllers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import api.RestResource;
import api.Routes;
import core.PropertyReader;
import core.StatusCode;
import io.restassured.response.Response;

public class NaukriController {
    public static void getDashboard(){
        Response response = RestResource.naukriGet(Routes.DASHBOARD);
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        DashboardResponse dashboardResponse = response.as(DashboardResponse.class);
        assertNotNull(dashboardResponse.getDashBoard());
        assertEquals(dashboardResponse.getDashBoard().getUsername(), PropertyReader.getProperty("username"));
    }

    public static ProfileDetailResponse getProfileDetails(){
        Map<String, String> data = new HashMap<>();
        data.put("expand_level", "4");
        Response response = RestResource.naukriGet(Routes.PROFILE_DETAILS, data);
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        ProfileDetailResponse apiResponse = response.as(ProfileDetailResponse.class);
        assertNotNull(apiResponse.getUser());
        assertNotNull(apiResponse.getProfile());
        return apiResponse;
    }

    public static ResumeHeadLineRequest requestBuilder(String resumeHeadline, String profileId){
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

        return ResumeHeadLineRequest.builder()
        .profile(
            ResumeHeadLineRequest.Profile.builder()
                .resumeHeadline(resumeHeadline)
                .build())
        .profileId(profileId)
        .build();
        
    }

    public static void updateResumeHeaderLine(){

        ProfileDetailResponse profileDetail = getProfileDetails();

        Response response = RestResource.naukriPut(Routes.RESUME_HEADERLINE, requestBuilder(profileDetail.getProfile().get(0).getResumeHeadline(), profileDetail.getProfile().get(0).getProfileId()));
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        ResumeHeadLineResponse apiResponse = response.as(ResumeHeadLineResponse.class);
        assertNotNull(apiResponse.getProfile());
        assertNotNull(apiResponse.getProfile().get(0).getId());
        assertEquals(apiResponse.getProfile().get(0).getId(), profileDetail.getProfile().get(0).getProfileId());
    }
}