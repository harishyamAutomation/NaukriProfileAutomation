package naukri.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardResponse {

    @JsonProperty("dashBoard")
    private DashBoard dashBoard;

    // ================= INNER CLASSES =================

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DashBoard {

        @JsonProperty("username")
        private String username;

        @JsonProperty("rawCtc")
        private String rawCtc;

        @JsonProperty("hasInboxFlag")
        private String hasInboxFlag;

        @JsonProperty("rawTotalExperience")
        private String rawTotalExperience;

        @JsonProperty("profileFlag")
        private String profileFlag;

        @JsonProperty("unreadMostRelevantMail")
        private String unreadMostRelevantMail;

        @JsonProperty("unseenOthersMailPresent")
        private String unseenOthersMailPresent;

        @JsonProperty("profileId")
        private String profileId;

        @JsonProperty("profileViewCount")
        private Integer profileViewCount;

        @JsonProperty("recruiterActionsLatestDate")
        private String recruiterActionsLatestDate;

        @JsonProperty("totalSearchAppearancesCount")
        private Integer totalSearchAppearancesCount;

        @JsonProperty("totalSearchAppearancesLatestDate")
        private String totalSearchAppearancesLatestDate;

        @JsonProperty("rd")
        private String rd;

        @JsonProperty("rc")
        private String rc;

        @JsonProperty("rp")
        private String rp;

        @JsonProperty("mod_dt")
        private String modDt;

        @JsonProperty("modDtGtThanSixMonths")
        private Integer modDtGtThanSixMonths;

        @JsonProperty("name")
        private String name;

        @JsonProperty("firstNaukri")
        private String firstNaukri;

        @JsonProperty("mvn")
        private String mvn;

        @JsonProperty("incompleteSection")
        private String incompleteSection;

        @JsonProperty("pc")
        private Integer pc;

        @JsonProperty("ca")
        private Integer ca;

        @JsonProperty("education")
        private Education education;

        @JsonProperty("designationId")
        private String designationId;

        @JsonProperty("profileSegment")
        private String profileSegment;

        @JsonProperty("organization")
        private String organization;

        @JsonProperty("desig")
        private String desig;

        @JsonProperty("isPremium")
        private Boolean isPremium;

        @JsonProperty("isPaidUser")
        private Boolean isPaidUser;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Education {

        @JsonProperty("entityInstitute")
        private EntityInstitute entityInstitute;

        @JsonProperty("course")
        private String course;

        @JsonProperty("institute")
        private String institute;

        @JsonProperty("spec")
        private String spec;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EntityInstitute {

        @JsonProperty("id")
        private String id;

        @JsonProperty("value")
        private String value;
    }
}
