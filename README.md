<<<<<<< HEAD
# NaukriProfileAutomation
=======
# NaukriProfile

REST API automation project for Naukri Profile APIs, structured similarly to the SpotifyAPI project.

## Tech stack

- **Java 15**, **Maven**
- **REST Assured** (API tests)
- **TestNG** (test framework, retry listener)
- **ExtentReports** (HTML reporting)
- **Gson** (JSON), **SLF4J/Logback** (logging)

## Project layout

```
NaukriProfile/
├── pom.xml
├── config.properties.example   → copy to config.properties
├── src/main/java/
│   ├── base/         BaseTest (suite/method hooks, ExtentReports)
│   ├── core/         Constants, OutputLog, PropertyReader, StatusCode
│   ├── helper/       BaseTestHelper (folders, timestamps)
│   ├── listeners/    FailRetry, RetryListener
│   └── util/         ExtentReport, JSONReader, UserRequestSpecification
└── src/test/
    ├── java/webAPI/  AccessToken, TestProfile
    └── resources/
        ├── extent-config.xml
        ├── testData/profileTestData.json
        └── testSuites/ProfileRegression.xml
```

## Setup

1. **Clone/open** the project (same parent folder as SpotifyAPI: `RestAPI/`).

2. **Config**
   - Copy `config.properties.example` to `config.properties`.
   - Set `baseURI`, `profilePath`, `accessTokenURI`, `clientID`, `clientSecret` (and `accessToken` if needed) per your Naukri API.

3. **Run tests**
   - From project root:
     ```bash
     mvn clean test
     ```
   - Suite used by default: `src/test/resources/testSuites/ProfileRegression.xml`.

4. **Reports**
   - ExtentReports HTML: `reports/<date>/<timestamp>Naukri_Profile_Regression.html`.
   - Surefire: `target/surefire-reports/`.

## Tests

- **AccessToken**: gets OAuth access token (adjust body/endpoint to Naukri auth API).
- **TestProfile**: sample profile get/summary tests; update endpoints and assertions to match Naukri Profile API.

Update `profileTestData.json` and test methods as per actual Naukri Profile API contracts.
>>>>>>> 98406c1 (Update Naukri Profile)
