package org.jbehave.business;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FeedbackServiceImpl implements FeedbackService {

    private ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();

    public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription) {
        Feedback feedback = new Feedback(sender, recipient, feedbackDescription);
        feedbacks.add(feedback);
        return feedback;
	}

    public ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }
}
