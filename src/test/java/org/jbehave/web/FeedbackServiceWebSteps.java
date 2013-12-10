package org.jbehave.web;

import org.jbehave.business.Steps;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@Steps
public class FeedbackServiceWebSteps {

    @BeforeStories
    public void openApp() {
        insertFeedbackPage.open();
    }

    @AfterStories
    public void tearDown() {
        insertFeedbackPage.close();
    }

	@Autowired
	@Qualifier("insertFeedbackPage")
	private InsertFeedbackPage insertFeedbackPage;

    @Given("that I have already submitted a feedback")
    public void submittedFeedback() {
        submitCompleteFeedback();
    }

    @When("I try to submit another feedback")
    public void submitAnotherFeedback() {
        submitCompleteFeedback();
    }

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        insertFeedbackPage.fillFeedback("myName", "anotherPerson", "Yay!");
        insertFeedbackPage.submitForm();
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        assertThat(insertFeedbackPage.viewFeedback("feedback_1"), containsString("Yay!"));
    }

    @Then("I should see the recipient’s name")
    public void viewRecipient() {
        assertThat(insertFeedbackPage.viewRecipient("recipient_1"), containsString("anotherPerson"));
    }

    @Then("I should see my name")
    public void viewSender() {
        assertThat(insertFeedbackPage.viewSender("sender_1"), containsString("myName"));
    }

    @Then("I should see my previous feedback")
    public void viewPreviousFeedback() {
        viewFeedback();
        viewRecipient();
        viewSender();
    }

}
