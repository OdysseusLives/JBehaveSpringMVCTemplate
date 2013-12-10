package org.jbehave.business;

import org.jbehave.core.annotations.*;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Steps
public class FeedbackServiceBusinessSteps {
    private FeedbackServiceImpl feedbackService;
    private Feedback feedback;
    private Feedback expectedFeedback;
    private List<Feedback> feedbacks;

    private static final String SENDER = "sender";
    private static final String RECIPIENT = "recipient";
    private static final String FEEDBACK_DESCRIPTION = "feedback description";


    @BeforeScenario
    public void generateExpectedFeedback() {
        expectedFeedback = new Feedback(SENDER, RECIPIENT, FEEDBACK_DESCRIPTION);
        feedbackService = new FeedbackServiceImpl();
    }

    @Given("that I have already submitted a feedback")
    public void submittedFeedback() {
        submitCompleteFeedback();
    }

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        feedback = feedbackService.addNewFeedback(SENDER, RECIPIENT, FEEDBACK_DESCRIPTION);
    }

    @When("I try to submit another feedback")
    public void submitAnotherFeedback() {
        feedbackService.addNewFeedback(SENDER, RECIPIENT, FEEDBACK_DESCRIPTION);
    }

    @Then("I should see the feedback")
    public void viewFeedback() {
        assertThat(feedback.getFeedbackDescription(), is(expectedFeedback.getFeedbackDescription()));
    }

    @Then("I should see the recipient’s name")
    public void viewRecipient() {
        assertThat(feedback.getRecipient(), is(expectedFeedback.getRecipient()));
    }

    @Then("I should see my name")
    public void viewSender() {
        assertThat(feedback.getSender(), is(expectedFeedback.getSender()));
    }

    @Then("I should see my previous feedback")
    public void viewPreviousFeedback() {
        feedbacks = feedbackService.getFeedbacks();
        assertThat(feedbacks.size(), is(2));
    }
}
