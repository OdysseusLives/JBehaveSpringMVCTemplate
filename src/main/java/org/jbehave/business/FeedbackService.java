package org.jbehave.business;


import java.util.ArrayList;

public interface FeedbackService {

	public Feedback addNewFeedback(String sender, String recipient, String feedbackDescription);

    public ArrayList<Feedback> getFeedbacks();
}
