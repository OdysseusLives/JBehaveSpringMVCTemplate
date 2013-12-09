package org.jbehave.business;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Steps
public class FeedbackServiceBusinessSteps {
    @Autowired
    private FeedbackServiceImpl feedbackService;
    private Feedback feedback;
    private Feedback expectedFeedback;

    private static final String SENDER = "sender";
    private static final String RECIPIENT = "recipient";
    private static final String FEEDBACK_DESCRIPTION = "feedback description";


    @BeforeStories
    public void generateExpectedFeedback() {
        expectedFeedback = new Feedback(SENDER, RECIPIENT, FEEDBACK_DESCRIPTION);
    }

    @When("I submit a feedback with my name, the recipient’s name and the feedback")
    public void submitCompleteFeedback() {
        feedback = feedbackService.addNewFeedback(SENDER, RECIPIENT, FEEDBACK_DESCRIPTION);
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
}
