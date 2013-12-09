package org.jbehave.web;

public class FeedbackForm {

	private String sender;
	private String recipient;
	private String feedback;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

	public String getRecipient() {
		return recipient;
	}

    public void setFeedback(String feedback){
        this.feedback = feedback;
    }

	public String getFeedback() {
		return feedback;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackForm other = (FeedbackForm) obj;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		return true;
	}

}
