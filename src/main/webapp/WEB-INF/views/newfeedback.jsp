<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
	<link href="../../scripts/css/feedback.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<form:form id="feedback_form" modelAttribute="feedbackInfo">
        <div>Sender: <form:input path="sender"/></div>
        <div>Recipient: <form:input path="recipient"/></div>
        <div>Feedback: <form:input path="feedback"/></div>
        <input id="submit" type="submit" value="Submit" />
	</form:form>

    <c:if test="${not empty feedbacks}">
        <hr>

        <h2>Feedback:</h2>

        <c:set var="count" value="0" scope="page" />
        <c:forEach var="feedback" items="${feedbacks}">
            <div>Feedback <c:out value="${count}"></c:out></div>

            <div class="feedback_value">
                Sender:
                <span id="sender_<c:out value="${count}"></c:out>">
                    <c:out value="${feedback.sender}"></c:out>
                </span>
            </div>

            <div class="feedback_value">
                Recipient:
                <span id="recipient_<c:out value="${count}"></c:out>">
                    <c:out value="${feedback.recipient}"></c:out>
                </span>
            </div>

            <div class="feedback_value">
                Feedback:
                <span id="feedback_<c:out value="${count}"></c:out>">
                    <c:out value="${feedback.feedbackDescription}"></c:out>
                </span>
            </div>

            <hr>

            <c:set var="count" value="${count + 1}" scope="page"/>
        </c:forEach>
	</c:if>
</body>
</html>