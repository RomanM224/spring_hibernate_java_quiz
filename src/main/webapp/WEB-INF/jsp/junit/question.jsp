<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maistruk.model.junit.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/questionStyles.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<%
	    List<JunitQuestionAnswer> questionAnswerList = (ArrayList<JunitQuestionAnswer>) session.getAttribute("junitQuestionAnswerList");
		List<JunitAnswerFlags> answerFlagsList = (ArrayList<JunitAnswerFlags>) session.getAttribute("junitAnswerFlagsList");
		JunitQuestionAnswer questionAnswer = questionAnswerList.get(questionAnswerList.size() - 1);
	%>
	
	<div class="questionBox">
	<p class="questionText"> <%out.write(questionAnswer.getQuestion().getQuestion()); %> </p>
	
	</div>
	<form action="junitNextQuestion" method="post">
	<label id="answerText1" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer1" name="answer1"/> <%out.write(questionAnswer.getAnswer1().getAnswer()); %></label>
	<label id="answerText2" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer2" name="answer2"/> <%out.write(questionAnswer.getAnswer2().getAnswer()); %> </label>
	<label id="answerText3" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer3" name="answer3"/> <%out.write(questionAnswer.getAnswer3().getAnswer()); %></label>
	<label id="answerText4" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer4" name="answer4"/> <%out.write(questionAnswer.getAnswer4().getAnswer()); %></label>
	<input type="submit" id="btnNetxtQuestion" value="Next question"/>
	</form>

	<script src="resources/js/javas.js"></script>
	
</body>
</html>