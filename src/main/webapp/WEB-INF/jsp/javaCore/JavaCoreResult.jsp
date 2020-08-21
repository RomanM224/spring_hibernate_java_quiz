<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.maistruk.model.java_core.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/resultStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="/spring_hibernate_java_quiz" >
		<input type="submit" value = "Home" class = "home_button">
	</form>
	
		<%
	    List<JavaCoreQuestionAnswer> questionAnswerList = (ArrayList<JavaCoreQuestionAnswer>) session.getAttribute("javaCoreQuestionAnswerList");
			int questionAmount = questionAnswerList.size();
			List<JavaCoreAnswerFlags> answerFlagsList = (ArrayList<JavaCoreAnswerFlags>) session.getAttribute("javaCoreAnswerFlagsList");
			int rightAnswerAmout = 0;
			for(JavaCoreAnswerFlags answerFlags : answerFlagsList){
			    if(answerFlags.checkAnswer()){
			        rightAnswerAmout++;
			    }
			}
	%>
		<p id="scoreNumGreen">Your Score:<span id="scoreNumRed"><%
		    out.println(rightAnswerAmout);
		%></span>/<%
		    out.println(questionAmount);
		%></p>
	
	<%
		    int questionNum = 0;
					for(JavaCoreQuestionAnswer questionAnswer : questionAnswerList){
					    JavaCoreAnswerFlags springAnswerFlags = answerFlagsList.get(questionNum);
					    questionNum++;
					    out.write(" <div class = \"questionBox\">"+ questionNum + ": " + questionAnswer.getJavaCoreQuestion().getQuestion() + "</div><br>");
					    if(questionAnswer.getJavaCoreAnswer1().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + questionAnswer.getJavaCoreAnswer1().getAnswer() + "</div><br>");
					    }else{
					        out.write("<div class = \"answerText\">" + questionAnswer.getJavaCoreAnswer1().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getJavaCoreAnswer2().getFlag()){
					    	out.write("<div class = \"answerTextRight\">" + questionAnswer.getJavaCoreAnswer2().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + questionAnswer.getJavaCoreAnswer2().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getJavaCoreAnswer3().getFlag()){
					   		out.write("<div class = \"answerTextRight\">" + questionAnswer.getJavaCoreAnswer3().getAnswer() + "</div><br>");
					    }else{
					   		out.write("<div class = \"answerText\">" + questionAnswer.getJavaCoreAnswer3().getAnswer() + "</div><br>");
					    }
					    if(questionAnswer.getJavaCoreAnswer4().getFlag()){
						    out.write("<div class = \"answerTextRight\">" + questionAnswer.getJavaCoreAnswer4().getAnswer() + "</div><br>");
					    }else{
						    out.write("<div class = \"answerText\">" + questionAnswer.getJavaCoreAnswer4().getAnswer() + "</div><br>");

					    }
		%>
	    <p class= "myAnswer">Your answer:
	    <%
	    if(springAnswerFlags.getMyAnswerFlag1()){
	        out.println(questionAnswer.getJavaCoreAnswer1().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag2()){
	        out.println(questionAnswer.getJavaCoreAnswer2().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag3()){
	        out.println(questionAnswer.getJavaCoreAnswer3().getAnswer());
	    }
	    if(springAnswerFlags.getMyAnswerFlag4()){
	        out.println(questionAnswer.getJavaCoreAnswer4().getAnswer());
	    }
	    out.println("</p>");
	    out.println("<hr width=\"75%\" color=\"#ff0000\" size=\"4\"/>");
	}
	%>

</body>
</html>