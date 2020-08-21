<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maistruk.model.java_core.*"%>
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
	    List<JavaCoreQuestionAnswer> questionAnswerList = (ArrayList<JavaCoreQuestionAnswer>) session.getAttribute("javaCoreQuestionAnswerList");
			List<JavaCoreAnswerFlags> answerFlagsList = (ArrayList<JavaCoreAnswerFlags>) session.getAttribute("javaCoreAnswerFlagsList");
			JavaCoreQuestionAnswer questionAnswer = questionAnswerList.get(questionAnswerList.size() - 1);
			//SpringQuestionAnswer springQuestionAnswer = springQuestionAnswerList.get(0);
	%>
	
	<div class="questionBox">
	<p class="questionText"> <%out.write(questionAnswer.getJavaCoreQuestion().getQuestion()); %> </p>
	
	</div>
	<form action="javaCoreNextQuestion" method="post">
	<label id="answerText1" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer1" name="answer1"/> <%out.write(questionAnswer.getJavaCoreAnswer1().getAnswer()); %></label>
	<label id="answerText2" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer2" name="answer2"/><%out.write(questionAnswer.getJavaCoreAnswer2().getAnswer()); %> </label>
	<label id="answerText3" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer3" name="answer3"/> <%out.write(questionAnswer.getJavaCoreAnswer3().getAnswer()); %></label>
	<label id="answerText4" class="answerText"> <input type="checkbox" class="answerCheckbox" value="answer4" name="answer4"/> <%out.write(questionAnswer.getJavaCoreAnswer4().getAnswer()); %></label>
	<input type="submit" id="btnNetxtQuestion" value="Next question"/>
	</form>

	
	<script src="resources/js/javas.js"></script>


</body>
</html>