package naukri.testModules;

import org.testng.annotations.Test;

import base.BaseTest;
import naukri.controllers.NaukriController;

/**
 * Tests for Naukri Profile (dashboard) API. Uses NaukriProfileController for all API logic.
 */
public class NaukriProfileTest extends BaseTest {

	@Test(description = "Get user self dashboard and verify response", priority=1)
	public void getDashboard() {
		NaukriController.getDashboard();
	}

	@Test(description = "Get Prfile details and verify response", priority=2)
	public void getProfileDetails() {
		NaukriController.getProfileDetails();
	}

	@Test(description = "Update resume headline and verify response", priority=3)
	public void updateResumeHeadLine(){
		NaukriController.updateResumeHeaderLine();
	}
}
