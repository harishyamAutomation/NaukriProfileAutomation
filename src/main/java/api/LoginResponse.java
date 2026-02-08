package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

	@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    @JsonProperty("cookies")
    private List<Cookie> cookies;

    @JsonProperty("userInfo")
    private UserInfo userInfo;

    @JsonProperty("userStateInfo")
    private UserStateInfo userStateInfo;

    // ================= INNER CLASSES =================

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Cookie {

        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;

        @JsonProperty("expiry")
        private Long expiry;

        @JsonProperty("httpOnly")
        private Boolean httpOnly;

        @JsonProperty("secure")
        private Boolean secure;

        @JsonProperty("sameSite")
        private String sameSite;

        @JsonProperty("domain")
        private String domain;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserInfo {

        @JsonProperty("userId")
        private Long userId;

        @JsonProperty("userType")
        private String userType;

        @JsonProperty("userRole")
        private String userRole;

        @JsonProperty("ipAddress")
        private String ipAddress;

        @JsonProperty("userAgent")
        private String userAgent;

        @JsonProperty("subUserType")
        private String subUserType;

        @JsonProperty("userData")
        private UserData userData;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {

        @JsonProperty("username")
        private String username;

        @JsonProperty("email")
        private String email;

        @JsonProperty("serviceType")
        private String serviceType;

        @JsonProperty("resId")
        private Long resId;

        @JsonProperty("isTechOpsLogin")
        private Boolean isTechOpsLogin;

        @JsonProperty("isEmail")
        private Boolean isEmail;

        @JsonProperty("isPaidClient")
        private Boolean isPaidClient;

        @JsonProperty("emailVerified")
        private Boolean emailVerified;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserStateInfo {

        @JsonProperty("userState")
        private String userState;

        @JsonProperty("validState")
        private Boolean validState;
    }
}