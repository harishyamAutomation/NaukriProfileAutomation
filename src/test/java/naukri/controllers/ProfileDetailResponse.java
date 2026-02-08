package naukri.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
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

public class ProfileDetailResponse {

    // ================= ROOT =================

    @JsonProperty("user")
    private User user;

    @JsonProperty("itskills")
    private List<Object> itSkills;

    @JsonProperty("certifications")
    private List<Object> certifications;

    @JsonProperty("educations")
    private List<Object> educations;

    @JsonProperty("employments")
    private List<Object> employments;

    @JsonProperty("projects")
    private List<Object> projects;

    @JsonProperty("schools")
    private List<Object> schools;

    @JsonProperty("languages")
    private List<Object> languages;

    @JsonProperty("noticePeriod")
    private List<Object> noticePeriod;

    @JsonProperty("disability")
    private List<Object> disability;

    @JsonProperty("onlineProfile")
    private List<Object> onlineProfile;

    @JsonProperty("presentation")
    private List<Object> presentation;

    @JsonProperty("patent")
    private List<Object> patent;

    @JsonProperty("publication")
    private List<Object> publication;

    @JsonProperty("workSample")
    private List<Object> workSample;

    @JsonProperty("profileAdditional")
    private Object profileAdditional;

    @JsonProperty("lookupData")
    private Object lookupData;

    @JsonProperty("additionalDetails")
    private Object additionalDetails;

    @JsonProperty("profile")
    private List<Profile> profile;
    
    @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        @JsonProperty("username") private String username;
        @JsonProperty("email") private String email;
        @JsonProperty("mobile") private String mobile;
        @JsonProperty("resdexVisibility") private String resdexVisibility;
        @JsonProperty("canChooseProfileDuringApply") private Boolean canChooseProfileDuringApply;
        @JsonProperty("residencePhone") private Object residencePhone;
        @JsonProperty("communicationSettings") private Object communicationSettings;
        @JsonProperty("creationDate") private String creationDate;
        @JsonProperty("userProperties") private Object userProperties;
        @JsonProperty("lastThirtyDaysApplicationCount") private String lastThirtyDaysApplicationCount;
        @JsonProperty("alternateEmail") private String alternateEmail;
        @JsonProperty("isMobileVerified") private Boolean isMobileVerified;
        @JsonProperty("isEmailVerified") private Boolean isEmailVerified;
        @JsonProperty("isSecondaryEmailVerified") private Boolean isSecondaryEmailVerified;
        @JsonProperty("isPremium") private Boolean isPremium;
    }

    @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public static class Profile {

    @JsonProperty("profileName")
    private String profileName;

    @JsonProperty("profileId")
    private String profileId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("keySkills")
    private String keySkills;

    @JsonProperty("resumeHeadline")
    private String resumeHeadline;

    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("contactAddress")
    private String contactAddress;

    @JsonProperty("mailCity")
    private String mailCity;

    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("maritalStatus")
    private Object maritalStatus;

    @JsonProperty("industry")
    private Object industry;

    @JsonProperty("functionalArea")
    private Object functionalArea;

    @JsonProperty("role")
    private Object role;

    @JsonProperty("desiredJobType")
    private List<String> desiredJobType;

    @JsonProperty("desiredEmploymentType")
    private List<String> desiredEmploymentType;

    @JsonProperty("locationPrefId")
    private List<Object> locationPrefId;

    @JsonProperty("desiredIndustryTypeId")
    private List<Object> desiredIndustryTypeId;

    @JsonProperty("negPrefIndustries")
    private Object negPrefIndustries;

    @JsonProperty("shiftPrefTime")
    private Object shiftPrefTime;

    @JsonProperty("expectedObjectCurrency")
    private String expectedObjectCurrency;

    @JsonProperty("expectedObject")
    private Object expectedObject;

    @JsonProperty("absoluteExpectedObject")
    private String absoluteExpectedObject;

    @JsonProperty("category")
    private Object category;

    @JsonProperty("workStatus")
    private Object workStatus;

    @JsonProperty("workPermitForCountry")
    private List<Object> workPermitForCountry;

    @JsonProperty("disability")
    private Object disability;

    @JsonProperty("noticePeriod")
    private Object noticePeriod;

    @JsonProperty("city")
    private Object city;

    @JsonProperty("country")
    private Object country;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("absoluteObject")
    private String absoluteObject;

    @JsonProperty("newLocationPrefId")
    private List<Object> newLocationPrefId;

    @JsonProperty("entityIndustryTypeId")
    private Object entityIndustryTypeId;

    @JsonProperty("entityIndustry")
    private Object entityIndustry;

    @JsonProperty("predictiveResumeHeadline")
    private String predictiveResumeHeadline;

    @JsonProperty("lastModTime")
    private String lastModTime;

    @JsonProperty("lastModAgo")
    private String lastModAgo;

    @JsonProperty("joinDate")
    private String joinDate;

    @JsonProperty("profileFlag")
    private String profileFlag;

    @JsonProperty("predictiveFuncAreaId")
    private Integer predictiveFuncAreaId;

    @JsonProperty("incompleteSections")
    private Object incompleteSections;

    @JsonProperty("desiredRole")
    private List<Object> desiredRole;

    @JsonProperty("entityDepartment")
    private Object entityDepartment;

    @JsonProperty("entityRoleCategory")
    private Object entityRoleCategory;

    @JsonProperty("entityRole")
    private Object entityRole;

    @JsonProperty("videoProfile")
    private Object videoProfile;

    @JsonProperty("cvInfo")
    private Object cvInfo;

    @JsonProperty("photoInfo")
    private Object photoInfo;

    @JsonProperty("isActiveProfile")
    private Boolean isActiveProfile;

    @JsonProperty("pc")
    private Integer pc;
}

}